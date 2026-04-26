package datos;

import clases.Juego;
import estructuras.ListaCarrito;
import estructuras.NodoHistorial;
import estructuras.*;

import java.io.*;

public class Historial {
    private static String nombreArchivo = "historial.txt";
    private static ListaHistorial historial = new ListaHistorial();


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

    public static void CargarDatos() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String descripcion = linea;

                NodoHistorial nuevoNodo = new NodoHistorial(descripcion);
                historial.InsertarAlInicio(nuevoNodo);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    public static void setNombreArchivo(String nombreArchivo) {
        Historial.nombreArchivo = nombreArchivo;
    }

    public static ListaHistorial getHistorial() {
        return historial;
    }

    public static void setHistorial(ListaHistorial historial) {
        Historial.historial = historial;
    }
}
