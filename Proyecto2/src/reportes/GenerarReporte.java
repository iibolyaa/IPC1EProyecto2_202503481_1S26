package reportes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarReporte {
    private String nombreArchivo;

    public GenerarReporte(String nombre){
        nombreArchivo = nombre + ".html";
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

    public void generarReporte(String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al escribir el reporte: " + e.getMessage());
        }
    }
}
