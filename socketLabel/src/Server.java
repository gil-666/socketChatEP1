
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<DataOutputStream> SalidaStream;
    private static final String ARCHIVO_HISTORIAL = "historial_chat.txt";

    public Server() {
        SalidaStream = new ArrayList<>(); //lista de salidas (clientes)
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Servidor activo.");
            File historialFile = new File(ARCHIVO_HISTORIAL);
            if (!historialFile.exists()) {
                historialFile.createNewFile();
            }
            while (true) { //cada cliente se convierte en un elemento de la lista salidaStream, 
//                                               asi es como el servidor sabe cuantos clientes hay
                Socket clientSocket = serverSocket.accept();
                if(SalidaStream.size() < 2){
                    
                enviarHistorialDeChat(serverSocket);
                System.out.println("Conexion " + clientSocket);
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                SalidaStream.add(out);
                iniciarServer(clientSocket, out);
                System.out.println("tamano salidastream: " + SalidaStream.size());
                }else{
                    System.out.println("servidor lleno");
                    clientSocket.close();
                }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void iniciarServer(Socket clientSocket, DataOutputStream out) {
        new Thread(() -> {
            try {
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                while (clientSocket.isConnected()) { // Verificar si el cliente aún está conectado
                    String tipo = in.readUTF();
                    if ("TEXT".equals(tipo)) {
                        String n = in.readUTF();
                        String msg = in.readUTF();
                        enviarMensaje(n, msg, tipo, out);
                        System.out.println("Mensaje Cliente: " + n + ":" + msg);
                        guardarMensajeEnHistorial(n, msg, tipo);
                    } else if ("FILE".equals(tipo)) {
                        String nomArchivo = in.readUTF();
                        recibirArchivo(nomArchivo, in);
                    }
                }
            } catch (Exception e) {
                SalidaStream.remove(out); // Elimina el cliente desconectado de la lista
                
                System.out.println("Se desconectó el cliente: '" + clientSocket.getInetAddress() + "'");
            }
        }).start();
    }

    private synchronized void enviarMensaje(String n, String msg, String tipo, DataOutputStream sender) {
        for (DataOutputStream out : SalidaStream) {
//            if (out != sender) {
            try {
                out.writeUTF(tipo);
                out.writeUTF(n);
                out.writeUTF(msg);

                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            }
        }
    }

    private void guardarMensajeEnHistorial(String nick, String mensaje, String tipo) {
        try (FileWriter fw = new FileWriter(ARCHIVO_HISTORIAL, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
            out.println(nick + ":" + mensaje);
            System.out.println("se guardo");
        } catch (IOException e) {
            System.err.println("Error al guardar mensaje en el historial: " + e.getMessage());
        }
    }

    private void enviarHistorialDeChat(ServerSocket historialSocket) {
        try (Socket socketCliente = historialSocket.accept(); ObjectOutputStream out = new ObjectOutputStream(socketCliente.getOutputStream())) {
            List<String> historial = Files.readAllLines(Paths.get(ARCHIVO_HISTORIAL));
            out.writeObject(historial);
        } catch (IOException e) {
            System.err.println("Error al enviar historial de chat: " + e.getMessage());
        }
    }

    private void recibirArchivo(String fileName, DataInputStream in) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            // Verificar si el flujo de entrada está disponible antes de leer
            while (in.available() > 0 && (bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead); // Guarda los datos binarios recibidos en el archivo
            }
            System.out.println("Archivo recibido: " + fileName);

            // Leer el archivo en un búfer de memoria
            byte[] fileBytes = Files.readAllBytes(Paths.get(fileName));

            // Reenviar el archivo a todos los clientes conectados
            for (DataOutputStream out : SalidaStream) {
                out.writeUTF("FILE"); // Indicar que se envía un archivo
                out.writeUTF(fileName); // Enviar el nombre del archivo
                out.writeInt(fileBytes.length); // Enviar el tamaño del archivo

                // Enviar el archivo en un solo mensaje
                out.write(fileBytes);
                out.flush();
            }

            System.out.println("Archivo reenviado a todos los clientes.");
        } catch (IOException e) {
            // Manejar la excepción de SocketException
            if (e instanceof SocketException) {
                System.out.println("Se desconectó el cliente mientras se recibía el archivo.");
            } else {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
