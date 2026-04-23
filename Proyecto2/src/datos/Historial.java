package datos;

import estructuras.ListaCarrito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Historial {
    private static String nombreArchivo = "historial.txt";


    public Historial(){
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

    public static void registroCompra(String registro){
        PrintWriter escritor = null;
        try{
            escritor = new PrintWriter(new FileWriter(nombreArchivo, true));
                escritor.println(registro);
        }catch(IOException e){
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }finally{
            if(escritor != null){
                escritor.close();
            }
        }
    }
}
