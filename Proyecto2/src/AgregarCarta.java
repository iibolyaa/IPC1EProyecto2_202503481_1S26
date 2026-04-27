import datos.*;
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
    MatrizAlbum album = new MatrizAlbum();

    public AgregarCarta(main mainFrame, JPanel panel){
        super(mainFrame, "Agregar Carta", true);
        InicializarForma();
        this.mainFrame = mainFrame;

        Btn_Agregar.addActionListener(e -> NuevaCarta(panel));
        Btn_Regresar.addActionListener(e -> setBtn_Regresar());
    }

    private void InicializarForma(){
        setContentPane(Pnl_AgregarCarta);
        setSize(300,200);
        setLocationRelativeTo(null);
    }

    public void NuevaCarta(JPanel Pnl_vista_cartas){
        String codigoCarta = Campo_Carta.getText();

        if(codigoCarta.isEmpty()){
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "Ingrese un código"
            );
        }else{
            Carta nuevaCarta = Catalogo.buscarCarta(codigoCarta);
            if(nuevaCarta != null){
                int posicion = album.insertarCarta(nuevaCarta);

                if (posicion != -1) {
                    Pnl_vista_cartas.remove(posicion);
                    Pnl_vista_cartas.add(new PanelCarta(nuevaCarta), posicion);
                    Pnl_vista_cartas.revalidate();
                    Pnl_vista_cartas.repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "El álbum está lleno");
                }

                dispose();
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
