import javax.swing.*;
import java.awt.*;
import java.io.File;

import estructuras.*;
import datos.*;
import clases.*;

public class PanelCarta extends JPanel {

    public PanelCarta(Carta carta) {
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
            add(new JButton(new ImageIcon(img)), BorderLayout.CENTER);
    }

        JLabel nombre = new JLabel(carta.getNombre(), SwingConstants.CENTER);
        nombre.setFont(new Font("Arial", Font.BOLD, 10));
        add(nombre, BorderLayout.SOUTH);
    }
}
