import javax.swing.*;
import java.io.*;
import java.util.HashMap;

/* 10 Sorpréndenos creando un programa de tu elección que utilice InputStream,
        PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.*/

public class Aplicacion {

    public static void main(String[] args) {
        int darDatos= JOptionPane.showConfirmDialog(null, "¿Es el dueño de la aplicación?", "Por favor selecciona", JOptionPane.YES_NO_OPTION);
        if (darDatos == 0){
            String clave= JOptionPane.showInputDialog("Escriba la clave de acceso");
            int acceso;
            acceso = "soyeldueño".compareTo(clave);
            if (acceso == 0){
                System.out.println(leerFichero("texto.txt"));
            }else{
                JOptionPane.showMessageDialog(null,"Eres un hacker bastante malo");
            }
        }else {
            int decision = 0;
            while (decision == 0) {
                String Usuario = JOptionPane.showInputDialog("Escriba su usuario");
                String contraseña = JOptionPane.showInputDialog("Escriba su contraseña");

                añadeUsuario(Usuario, contraseña);

                decision = JOptionPane.showConfirmDialog(null, "¿Quieres añadir otro usuario?", "Por favor selecciona", JOptionPane.YES_NO_OPTION);
            }
        }



    }
    static HashMap<String,String> map = new HashMap<>();
    private static void añadeUsuario(String nombre, String contraseña) {
        map.put (nombre, contraseña);
        escribirFichero(nombre+" "+contraseña);
    }

    public static String leerFichero(String texto) {
        String resultado = null;
        try {
            InputStream fichero = new FileInputStream(texto);
            try {
                resultado = "";
                byte[] datos = fichero.readAllBytes();
                for (byte dato : datos) {
                    resultado += ((char) dato);
                    fichero.close();

                }
            } catch (IOException e) {
                System.out.println("No puedo leer el fichero " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero" + e.getMessage());
        }
        return resultado;
    }
    public static void escribirFichero(String texto) {
        PrintStream info = null;
        String anterior = leerFichero("texto.txt");
        try {
            info = new PrintStream("texto.txt");
            info.write(anterior.getBytes());
            info.write(("\n" + texto).getBytes());


        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            info.close();
        }
    }

}
