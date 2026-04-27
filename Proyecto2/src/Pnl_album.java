import datos.Album;
import clases.*;
import estructuras.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pnl_album {
    private JPanel Pnl_vista_album;
    private JButton Btn_Intercambiar;
    private JButton Btn_Agregar;
    private JTextField textField1;
    private JComboBox comboBox_rareza;
    private JComboBox comboBox_tipo;
    private JButton Btn_buscar;
    private JPanel Pnl_vista_carta;
    private JPanel Pnl_vista_cartas;

    public Pnl_album() {
        Pnl_vista_cartas.setLayout(new GridLayout(4, 6, 5, 5));
        inicializarMatriz();

        Btn_Agregar.addActionListener(e -> setBtn_Agregar());
    }

    private void setBtn_Agregar(){
        main mainFrame = (main) SwingUtilities.getWindowAncestor(Pnl_album.this.getPnl_vista_album());
        AgregarCarta agregarCarta = new AgregarCarta(mainFrame, Pnl_vista_cartas, Pnl_vista_carta);
        mainFrame.setVisible(true);
        agregarCarta.setVisible(true);
    }

    private void inicializarMatriz(){
        Pnl_vista_cartas.removeAll();

        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++){
                int posicion = i * 4 + j;
                NodoMatriz nodo = Album.getAlbum().getNodoMatriz(i, j);
                Carta carta = nodo.getCarta();

                Pnl_vista_cartas.add(new PanelCarta(carta, Pnl_vista_carta));
            }
        }
        Pnl_vista_cartas.revalidate();
        Pnl_vista_cartas.repaint();
    }

    public JPanel getPnl_vista_carta(){
        return Pnl_vista_carta;
    }

    public JPanel getPnl_vista_album() {
        return Pnl_vista_album;
    }
}
