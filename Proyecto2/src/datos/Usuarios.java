package datos;
import clases.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Usuarios {
    private static String nombreArchivo = "usuarios.txt";
    private static Usuario[] usuariosDisponibles = new Usuario[10];
    private static int contadorUsuarios = 0;
    private static Usuario usuarioActual = new Usuario("usuario", "usuario", 0, 0);

    public Usuarios(){
        asegurarArchivoExiste();
    }

    public void asegurarArchivoExiste() {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    public static void CargarDatos() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                    String[] partes = linea.split("\\|");

                    String username = partes[0];
                    String password = partes[1];
                    int xp = Integer.parseInt(partes[2]);
                    int nivel = Integer.parseInt(partes[3]);

                    Usuario nuevoUsuario = new Usuario(username, password, xp, nivel);
                    usuariosDisponibles[contadorUsuarios] = nuevoUsuario;
                    contadorUsuarios++;
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validar(String username, String password){
        for(int i = 0; i < contadorUsuarios; i++){
            if(usuariosDisponibles[i] != null && usuariosDisponibles[i].getId().equals(username) && usuariosDisponibles[i].getPassword().equals(password)){
                Usuario usuarioActual = usuariosDisponibles[i];
                return true;
            }
        }
        return false;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

}
