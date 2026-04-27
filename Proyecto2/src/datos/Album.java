package datos;

import estructuras.*;
import clases.*;

import java.io.*;

public class Album {
    private static String nombreArchivo = "album.txt";
    private static MatrizAlbum album = new MatrizAlbum();

    public Album(){
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

    public static void registroCarta(Carta carta){
        PrintWriter escritor = null;
        try{
            escritor = new PrintWriter(new FileWriter(nombreArchivo, true));

            String registro = carta.getCodigo() + "|" + carta.getNombre() + "|" + carta.getTipo() + "|"
                    + carta.getRareza() + "|" + carta.getAtaque() + "|" + carta.getDefensa() +
                    "|" + carta.getPs();

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
                String[] partes = linea.split("\\|");

                String codigo = partes[0];
                String nombre = partes[1];
                String tipo = partes[2];
                String rareza = partes[3];
                int ataque = Integer.parseInt(partes[4]);
                int defensa = Integer.parseInt(partes[5]);
                int ps = Integer.parseInt(partes[6]);

                Carta nuevaCarta = new Carta(codigo, nombre, tipo, rareza, ataque, defensa, ps);

                album.insertarCarta(nuevaCarta);

            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MatrizAlbum getAlbum() {
        return album;
    }

    public static void setAlbum(MatrizAlbum album) {
        Album.album = album;
    }

    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    public static void setNombreArchivo(String nombreArchivo) {
        Album.nombreArchivo = nombreArchivo;
    }
}
