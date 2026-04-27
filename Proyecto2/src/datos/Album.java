package datos;

import estructuras.*;
import clases.*;
import reportes.GenerarReporte;

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


    public static void cargarDatosReporte(){
        String estilos = "<style>" +
                "body { font-family: Arial, sans-serif; padding: 40px; background-color: #f4f7f6; }" +
                "h1 { font-family: Arial, sans-serif; }" +
                "table { width: 100%; border-collapse: collapse; background-color: white; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }" +
                "th { background-color: #19546B; color: white; padding: 15px; font-size: 14px; text-align: center; }" +
                "td { padding: 12px 15px; border-bottom: 1px solid #ddd; color: #555; text-align: center; }" +
                ".fila-legendaria { background-color: #D4AF37; color: white; }" + ".fila-vacia { background-color: #d9d9d9; color: #aaa; }" +
                "</style>";

        String html = "<html><head><title>Reporte</title>" + estilos + "</head><body>";
        html += "<h1>Álbum</h1>";
        html += "<table>";
        html += "<tr><th>Código</th><th>Nombre</th><th>Tipo</th>" +
                "<th>Rareza</th><th>Ataque</th><th>Defensa</th><th>PS</th></tr>";

        NodoMatriz actualfila = album.getRaiz();

        while(actualfila != null){
            NodoMatriz actualcolumna = actualfila;
            while(actualcolumna != null){
                Carta carta = actualcolumna.getCarta();

                if(carta != null){
                    if(carta.getRareza().equals("Legendario")){
                        html += "<tr class=\"fila-legendaria\">";
                    } else {
                        html += "<tr>";
                    }
                    html += "<td>" + carta.getCodigo() + "</td>" +
                            "<td>" + carta.getNombre() + "</td>" +
                            "<td>" + carta.getTipo() + "</td>" +
                            "<td>" + carta.getRareza() + "</td>" +
                            "<td>" + carta.getAtaque() + "</td>" +
                            "<td>" + carta.getDefensa() + "</td>" +
                            "<td>" + carta.getPs() + "</td></tr>";
                }else {
                html += "<tr class=\"fila-vacia\">" +
                        "<td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td><td>-</td>" +
                        "</tr>";
            }
                actualcolumna = actualcolumna.getEste();
            }
            actualfila = actualfila.getSur();
        }

        html += "</table></body></html>";
        new GenerarReporte("Album").generarReporte(html);
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
