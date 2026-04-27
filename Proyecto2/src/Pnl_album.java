import datos.Album;
import clases.*;
import datos.Catalogo;
import estructuras.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Pnl_album extends Component {
    private JPanel Pnl_vista_album;
    private JButton Btn_Intercambiar;
    private JButton Btn_Agregar;
    private JTextField BusquedaCarta;
    private JComboBox comboBox_rareza;
    private JComboBox comboBox_tipo;
    private JButton Btn_buscar;
    private JPanel Pnl_vista_carta;
    private JPanel Pnl_vista_cartas;

    public Pnl_album() {
        Pnl_vista_cartas.setLayout(new GridLayout(4, 6, 5, 5));
        inicializarMatriz();

        Btn_Agregar.addActionListener(e -> setBtn_Agregar());
        Btn_buscar.addActionListener(e -> busqueda());

        BusquedaCarta.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { busquedaTexto(); }
            public void removeUpdate(DocumentEvent e) { busquedaTexto(); }
            public void changedUpdate(DocumentEvent e) { busquedaTexto(); }
        });
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

    private void busquedaTexto(){
        String texto = BusquedaCarta.getText().toLowerCase().trim();

        Pnl_vista_cartas.removeAll();
        NodoMatriz actualfila = Album.getAlbum().getRaiz();

        while(actualfila != null) {
            NodoMatriz actualcolumna = actualfila;
            while (actualcolumna != null) {
                Carta carta = actualcolumna.getCarta();
                PanelCarta panel = new PanelCarta(carta, Pnl_vista_carta);

                if (!texto.isEmpty() && carta != null && carta.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                    panel.resaltar();
                } else {
                    panel.quitarResaltado();
                }
                Pnl_vista_cartas.add(panel);
                actualcolumna = actualcolumna.getEste();
            }
            actualfila = actualfila.getSur();
        }
        Pnl_vista_cartas.revalidate();
        Pnl_vista_cartas.repaint();
    }

    private void busqueda(){
        String tipo = comboBox_tipo.getSelectedItem().toString();
        String rareza = comboBox_rareza.getSelectedItem().toString();

        Pnl_vista_cartas.removeAll();
        NodoMatriz actualfila = Album.getAlbum().getRaiz();

        if(!tipo.equals("Tipo") || !rareza.equals("Rareza")) {

            while(actualfila != null) {
                NodoMatriz actualcolumna = actualfila;
                while (actualcolumna != null) {
                    Carta carta = actualcolumna.getCarta();
                    PanelCarta panel = new PanelCarta(carta, Pnl_vista_carta);

                    if (carta != null && (carta.getTipo().equals(tipo) || carta.getRareza().equals(rareza))) {
                        panel.resaltar();
                    } else {
                        panel.quitarResaltado();
                    }
                    Pnl_vista_cartas.add(panel);
                    actualcolumna = actualcolumna.getEste();
                }
                actualfila = actualfila.getSur();
            }
            Pnl_vista_cartas.revalidate();
            Pnl_vista_cartas.repaint();

        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "Seleccione al menos un campo"
            );
        }
    }

    public JPanel getPnl_vista_carta(){
        return Pnl_vista_carta;
    }

    public JPanel getPnl_vista_album() {
        return Pnl_vista_album;
    }
}
