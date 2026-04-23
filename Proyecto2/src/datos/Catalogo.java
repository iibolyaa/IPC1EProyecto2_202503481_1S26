package datos;
import clases.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Catalogo {
    private static String nombreArchivo = "catalogo.txt";
    private static Juego[] juegosdisponibles = new Juego[10];
    private static int contadorJuegos = 0;

    public Catalogo(){
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

    //Cargar los datos del archivo al arreglo
    public static void CargarDatos() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                    String[] partes = linea.split("\\|");

                    String codigou = partes[0];
                    String nombre = partes[1];
                    String genero = partes[2];
                    double precio = Double.parseDouble(partes[3]);
                    String plataforma = partes[4];
                    int stock = Integer.parseInt(partes[5]);
                    String descripcion = partes[6];

                    Juego nuevoJuego = new Juego(codigou, nombre, genero, precio, plataforma, stock, descripcion);
                    juegosdisponibles[contadorJuegos] = nuevoJuego;
                    contadorJuegos++;
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Juego buscarjuego(String nombreJuego){
        for(int i = 0; i < contadorJuegos; i++){
            if(juegosdisponibles[i] != null && juegosdisponibles[i].getNombre().equals(nombreJuego)){
                Juego juego = juegosdisponibles[i];
                return juego;
            }
        }
        return null;
    }

}
