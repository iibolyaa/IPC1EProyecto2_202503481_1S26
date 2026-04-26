import datos.Catalogo;
import clases.*;
import estructuras.MatrizAlbum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarCarta extends JDialog{
    private JTextField Campo_Carta;
    private JPanel Pnl_AgregarCarta;
    private JButton Btn_Agregar;
    private JButton Btn_Regresar;
    private main mainFrame;
    MatrizAlbum matrizAlbum = new MatrizAlbum();

    //private JPanel celdaDestino;

    public AgregarCarta(main mainFrame){
        super(mainFrame, "Agregar Carta", true);
        //this.celdaDestino = celdaDestino;
        InicializarForma();
        this.mainFrame = mainFrame;

        Btn_Agregar.addActionListener(e -> NuevaCarta());
        Btn_Regresar.addActionListener(e -> setBtn_Regresar());
    }

    private void InicializarForma(){
        setContentPane(Pnl_AgregarCarta);
        setSize(300,200);
        setLocationRelativeTo(null);
    }

    public void NuevaCarta(){
        String codigoCarta = Campo_Carta.getText();

        if(codigoCarta.isEmpty()){
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "Ingrese un código"
            );
        }else{
            Carta nuevaCarta = Catalogo.buscarCarta(codigoCarta);
            if(nuevaCarta != null){
                matrizAlbum.insertarCarta(nuevaCarta);

                PanelCarta panelCarta = new PanelCarta(nuevaCarta);

               /* celdaDestino.setLayout(new BorderLayout());
                celdaDestino.removeAll();
                celdaDestino.add(panelCarta, BorderLayout.CENTER);
                celdaDestino.revalidate();
                celdaDestino.repaint();

                dispose();*/

            }else{
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(this),
                        "No existe en inventario una carta con el código ingresado"
                );
            }
        }
    }

    private void setBtn_Regresar(){
        mainFrame.setVisible(true);
        mainFrame.vista.show(mainFrame.getPnl_panel_principal(), "album");
        this.dispose();
    }
}
