import javax.swing.*;
import java.awt.*;
import java.io.File;

import estructuras.*;
import datos.*;
import clases.*;

public class PanelCarta extends JPanel {

    public PanelCarta(Carta carta, JPanel panelDetalle) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 140));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (carta == null) {
            // Celda vacía
            setBackground(new Color(200, 200, 200));
            add(new JLabel("Vacía", SwingConstants.CENTER), BorderLayout.CENTER);
            return;
        }

        File archivo = new File(carta.getImagen());
        if (archivo.exists()) {
            Image img = new ImageIcon(carta.getImagen())
                    .getImage()
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JButton btnImagen = new JButton(new ImageIcon(img));

            btnImagen.addActionListener(e -> mostrarDetalle(carta, panelDetalle));

            add(btnImagen, BorderLayout.CENTER);
    }

        JLabel nombre = new JLabel(carta.getNombre(), SwingConstants.CENTER);
        nombre.setFont(new Font("Arial", Font.BOLD, 10));
        add(nombre, BorderLayout.SOUTH);
    }

    private void mostrarDetalle(Carta carta, JPanel panelDetalle) {
        panelDetalle.removeAll();

        // Imagen grande
        File archivo = new File(carta.getImagen());
        if (archivo.exists()) {
            Image img = new ImageIcon(carta.getImagen())
                    .getImage()
                    .getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            panelDetalle.add(new JLabel(new ImageIcon(img)), BorderLayout.NORTH);
        }

        JTextArea stats = new JTextArea();
        stats.setEditable(false);
        stats.setText(
                "Nombre: " + carta.getNombre() + "\n" +
                        "Tipo: " + carta.getTipo() + "\n" +
                        "Rareza: " + carta.getRareza() + "\n" +
                        "Ataque: " + carta.getAtaque() + "\n" +
                        "Defensa: " + carta.getDefensa() + "\n" +
                        "PS: " + carta.getPs()
        );
        panelDetalle.add(stats, BorderLayout.CENTER);

        panelDetalle.revalidate();
        panelDetalle.repaint();
    }

    public void resaltar() {
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        revalidate();
        repaint();
    }

    public void quitarResaltado() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        revalidate();
        repaint();
    }
}
