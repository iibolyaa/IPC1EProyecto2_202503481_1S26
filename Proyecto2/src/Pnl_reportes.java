import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import reportes.*;
import datos.*;

public class Pnl_reportes {
    private JPanel Pnl_vista_reportes;
    private JButton Btn_RInventario;
    private JButton Btn_RVentas;
    private JButton Btn_RAlbum;
    private JButton Btn_RTorneos;

    public Pnl_reportes() {
        Btn_RInventario.addActionListener(e -> {
            ReporteInventario();
        });

        Btn_RVentas.addActionListener(e -> {
           ReporteVentas();
        });
    }

    private void ReporteVentas(){
        try {
            Historial.cargarDatosReporte();

            File archivo = new File("Ventas.html");
            if (archivo.exists()) {
                Desktop.getDesktop().browse(archivo.toURI());
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no fue encontrado.");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el reporte: " + ex.getMessage());
        }
    }

    private void ReporteInventario(){
        try {
            Catalogo.cargarDatosReporte();

            File archivo = new File("Inventario.html");
            if (archivo.exists()) {
                Desktop.getDesktop().browse(archivo.toURI());
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no fue encontrado.");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el reporte: " + ex.getMessage());
        }
    }

    public JPanel getPnl_vista_reportes() {
        return Pnl_vista_reportes;
    }
}
