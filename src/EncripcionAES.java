
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author gil
 */
public class EncripcionAES {

    String LLAVE = "holabuenosdias";

//    public static void main(String[] args) {
//        String encriptada = "";
//        String aEncriptar = "";
//        EncripcionAES main = new EncripcionAES();
//        aEncriptar = JOptionPane.showInputDialog("Ingresa la cadena a encriptar: ");
//        encriptada = main.Encriptar(aEncriptar);
//        JOptionPane.showMessageDialog(null, encriptada);
//        JOptionPane.showMessageDialog(null, main.Desencriptar(encriptada));
//        
//    }
    public SecretKeySpec CrearClave(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }

    }

    //encriptar
    public String Encriptar(String encriptar) {

        try {
            SecretKeySpec secretKeySpec = CrearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.getEncoder().encodeToString(encriptada);
            return cadena_encriptada;

        } catch (Exception e) {
            return "";
        }
    }

    public String Desencriptar(String desencriptar) {

        try {
            SecretKeySpec secretKeySpec = CrearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] cadena = Base64.getDecoder().decode(desencriptar);
            byte[] desencriptacion = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacion);
            return cadena_desencriptada;

        } catch (Exception e) {
            return "";
        }
    }

    public byte[] EncriptarBytes(byte[] bytes) {
        try {
            SecretKeySpec secretKeySpec = CrearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] bytesEncriptados = cipher.doFinal(bytes);
            return bytesEncriptados;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] DesencriptarBytes(byte[] bytesEncriptados) {
        try {
            SecretKeySpec secretKeySpec = CrearClave(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] bytesDesencriptados = cipher.doFinal(bytesEncriptados);
            return bytesDesencriptados;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
