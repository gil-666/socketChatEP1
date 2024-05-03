
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Client {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private final FCliente interfaz;
    private String IP = "localhost";

    public Client() {
        interfaz = new FCliente();

        interfaz.setVisible(true);
        interfaz.getBEnviar().addActionListener(new EnviarMsg());

        interfaz.getTFMensaje().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    new EnviarMsg().enviarMensaje(interfaz.getNombre(), interfaz.getTFMensaje().getText(), false);
                    System.out.println("sent");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        interfaz.getBEnviarArchivo().addActionListener(new EnviarArchivo());
        IP = JOptionPane.showInputDialog("IP del servidor", IP);
        String user = JOptionPane.showInputDialog("Ingresa tu nombre de usuario", interfaz.nombre);
        interfaz.setNombre(user);
        interfaz.setTitle("GilMessenger Client: " + user);
        interfaz.getLNombre().setText(user);
        conectar();
        cargarHistorial();

    }

    private void conectar() {
        try {
            socket = new Socket(IP, 12345);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            recibirMensaje();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(interfaz, "El servidor esta lleno o no disponible!");
            System.exit(0);

        }
    }

    private void recibirMensaje() {
        new Thread(() -> {
            try {
                while (true) {
                    String tipo = in.readUTF();

                    if ("TEXT".equals(tipo)) {
                        String nomb = in.readUTF();
                        String msg = in.readUTF();
                        System.out.println("se recibio texto");
//                        Color receivedColor = new Color(red, green, blue);
                        String linea = nomb + ":" + msg;
                        StringBuilder historialDesencriptado = new StringBuilder();
                        String[] partes = linea.split(":"); // Dividir la línea en usuario y mensaje
                        System.out.println(partes.length);
                        if (partes.length == 2) {
                            String usuarioDesencriptado = new EncripcionAES().Desencriptar(partes[0]);
                            String mensajeDesencriptado = new EncripcionAES().Desencriptar(partes[1]);

                            historialDesencriptado.append(usuarioDesencriptado).append(": ").append(mensajeDesencriptado);
                        } else {
                            // Si no hay dos partes, simplemente agregamos la línea como está (podría ser un mensaje sin formato esperado)
                            historialDesencriptado.append(linea);
                        }
                        System.out.println("se recibio " + linea);
                        interfaz.getTAMensaje().append(historialDesencriptado + "\n");
                        if (interfaz.getChkBFondo().isSelected()) {
                            interfaz.getTAMensaje().setCaretPosition(interfaz.getTAMensaje().getDocument().getLength());
                            System.out.println("pa abajo");
                        }
                    } else if ("FILE".equals(tipo)) {
                        System.out.println("ARCHIVO DETECTADO");
                        String nombreArchivo = in.readUTF();
                        int longitudArchivo = in.readInt();
                        byte[] archivoBytes = new byte[longitudArchivo];
                        in.readFully(archivoBytes);
                        System.out.println("Se recibió un archivo: " + nombreArchivo);
                        guardarArchivoEnDisco(nombreArchivo, archivoBytes);
                        new EnviarMsg().enviarMensaje(interfaz.getNombre(), "envió un archivo " + nombreArchivo, true);
                    } else {
                        System.out.println("Se recibio un mensaje tipo desconocido");
                    }
//                  
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(interfaz, "El servidor esta lleno o no disponible!");
            }
        }).start();
    }

    public void cargarHistorial() {
        try {
            socket = new Socket(IP, 12345);
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            List<String> historial = (List<String>) input.readObject();
            input.close();

            StringBuilder historialDesencriptado = new StringBuilder();
            for (String linea : historial) {
                String[] partes = linea.split(":"); // dividir la línea en usuario y mensaje
                if (partes.length == 2) {
                    String usuarioDesencriptado = new EncripcionAES().Desencriptar(partes[0]);
                    String mensajeDesencriptado = new EncripcionAES().Desencriptar(partes[1]);
                    historialDesencriptado.append(usuarioDesencriptado).append(": ").append(mensajeDesencriptado).append("\n");
                } else {

                    historialDesencriptado.append(linea).append("\n");
                }
            }
            // Actualizar el área de chat en el hilo de la interfaz de usuario
            SwingUtilities.invokeLater(() -> interfaz.getTAMensaje().setText(historialDesencriptado.toString()));
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(interfaz, "Error al cargar el historial: " + ex.getMessage(), "Error", JOptionPane.ERROR);
            System.exit(0);
        }
    }

    public class EnviarMsg implements ActionListener {

        private void enviarMensaje(String nombre, String msg, Boolean esarchivo) {

            if (!interfaz.getTFMensaje().getText().isBlank() || esarchivo == true) {
                try {
                    out.writeUTF("TEXT");
                    out.writeUTF(new EncripcionAES().Encriptar(nombre));
                    out.writeUTF(new EncripcionAES().Encriptar(msg));

                    out.flush();
//                interfaz.getTAMensaje().setCaretPosition(interfaz.getTAMensaje().getDocument().getLength());
                    interfaz.getTFMensaje().setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(interfaz, "Mensaje no puede ser en blanco!!");
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            enviarMensaje(interfaz.getNombre(), interfaz.getTFMensaje().getText(), false);
        }

    }

    public class EnviarArchivo implements ActionListener {

        private void seleccionarArchivo() {

            JFileChooser fileChooser = new JFileChooser();
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg");
//            fileChooser.setFileFilter(filter);

            int resultado = fileChooser.showOpenDialog(interfaz);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                enviarArchivo(archivoSeleccionado);

            }

        }

        private void enviarArchivo(File archivo) {

            try (FileInputStream fis = new FileInputStream(archivo)) {
                out.writeUTF("FILE"); // envia un mensaje al servidor indicando que se enviará un archivo
                out.writeUTF(archivo.getName()); // envia el nombre del archivo al servidor
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead); // Envía los datos binarios del archivo al servidor
                }

                out.flush(); // asegura que todos los datos se envíen inmediatamente
                new File(System.getProperty("user.dir") + File.separator + archivo.getName()).delete();//limpia archivos temporales
                System.out.println("la ruta temporal es:" + System.getProperty("user.dir") + File.separator + archivo.getName());

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("se termino de enviar");

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(() -> {
                seleccionarArchivo();
            }
            ).start();
        }

    }

    private void guardarArchivoEnDisco(String nombreArchivo, byte[] archivoBytes) {
        try {
            // obtener la ruta absoluta de la carpeta recibidos
            String rutaCarpetaRecibidos = System.getProperty("user.dir") + File.separator + "src" + File.separator + "recibidos_"+interfaz.getNombre();

            // verifica si la carpeta recibidos existe
            File carpetaRecibidos = new File(rutaCarpetaRecibidos);
            if (!carpetaRecibidos.exists()) {
                carpetaRecibidos.mkdirs(); // Crea la carpeta y todas las subcarpetas necesarias
            }

            // crea el archivo en la carpeta
            String rutaArchivo = rutaCarpetaRecibidos + File.separator + nombreArchivo;
            try (FileOutputStream fos = new FileOutputStream(rutaArchivo)) {
                fos.write(archivoBytes);
            }

            System.out.println("Archivo guardado en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client();
            }
        });
    }

}
