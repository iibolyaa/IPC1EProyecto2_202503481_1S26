package datos;
import clases.*;
import estructuras.NodoMatriz;

import java.io.*;

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
                if(linea.contains("JG")) {
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

    public static void modificarStock(){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
            for(int i = 0; i < contadorJuegos; i++){
                Juego j = juegosdisponibles[i];
                String linea =
                        j.getCodigou() + "|" +
                        j.getNombre() + "|" +
                        j.getGenero() + "|" +
                        j.getPrecio() + "|" +
                        j.getPlataforma() + "|" +
                        j.getStock() + "|" +
                        j.getDescripcion();

                escritor.write(linea);
                escritor.newLine();
            }
            escritor.close();
        }catch (IOException e){
            System.out.println("Error al actualizar el archivo" + e.getMessage());
        }
    }

    public static Carta buscarCarta(String codigou){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(linea.contains(codigou)) {
                    String[] partes = linea.split("\\|");

                    String codigo = partes[0];
                    String nombre = partes[1];
                    String tipo = partes[2];
                    String rareza = partes[3];
                    int ataque = Integer.parseInt(partes[4]);
                    int defensa = Integer.parseInt(partes[5]);
                    int ps = Integer.parseInt(partes[6]);
                    String imagen = partes[7];

                    Carta nuevaCarta = new Carta(codigo, nombre, tipo, rareza, ataque, defensa, ps);
                    return nuevaCarta;
                }
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    public static void setNombreArchivo(String nombreArchivo) {
        Catalogo.nombreArchivo = nombreArchivo;
    }

    public static Juego[] getJuegosdisponibles() {
        return juegosdisponibles;
    }

    public static void setJuegosdisponibles(Juego[] juegosdisponibles) {
        Catalogo.juegosdisponibles = juegosdisponibles;
    }

    public static int getContadorJuegos() {
        return contadorJuegos;
    }

    public static void setContadorJuegos(int contadorJuegos) {
        Catalogo.contadorJuegos = contadorJuegos;
    }
}
