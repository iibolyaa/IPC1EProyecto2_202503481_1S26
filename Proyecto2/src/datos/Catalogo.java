package datos;
import clases.*;
import estructuras.NodoMatriz;
import reportes.GenerarReporte;

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

    public static void cargarDatosReporte(){
        String html = "<html><head><title>Reporte</title></head><body>";
        html += "<h1>Inventario</h1>";
        html += "<table>";
        html += "<th>" + "Código" + "</th><th>" + "Juego" + "</th><th>" + "Género" +
                "</th><th>" + "Precio" + "</th><th>" + "Plataforma" + "</th><th>" + "Stock";
        html += "<style> body { font-family: 'Arial', sans-serif; padding: 40px; background-color: #f4f7f6;}" +
                "h1{font-family: 'Arial', sans-serif;} " +
                "table{font-family: 'Arial', sans-serif; width:100%; border-collapse:collapse; background-color: white; box-shadow: 0 4px 8px rgba(0,0,0,0.1);} " +
                "th {background-color: #19546B; color: white; padding: 15px; font-size: 14px, text-align: center;}"+
                "td {padding: 12px 15px; border-bottom: 1px solid #ddd; color: #555, text-align: center;} </style>";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(linea.contains("JG")) {
                    String[] partes = linea.split("\\|");

                    String codigou = partes[0];
                    String nombre = partes[1];
                    String genero = partes[2];
                    String precio = partes[3];
                    String plataforma = partes[4];
                    String stock = partes[5];

                    html += "<tr><td>" + codigou + "</td><td>" + nombre + "</td><td>" + genero + "</td><td>"
                            + precio + "</td><td>" + plataforma + "</td><td>" + stock + "</td><tr>";
                }
            }
            lector.close();

            html += "</table></body></html>";
            new GenerarReporte("Inventario").generarReporte(html);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
