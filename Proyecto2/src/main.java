import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.*;

public class main extends JFrame{
    private JPanel panel1;
    private JButton btn_salir;
    private JToggleButton btn_tienda;
    private JToggleButton btn_album;
    private JToggleButton btn_torneo;
    private JToggleButton btn_recompensas;
    private JToggleButton btn_reportes;
    private JToggleButton btn_datos;
    private JPanel Pnl_panel_principal;

    Pnl_tienda Pnl_tienda = new Pnl_tienda();
    Pnl_album Pnl_album = new Pnl_album();
    Pnl_torneo Pnl_torneo = new Pnl_torneo();
    Pnl_recompensas Pnl_recompensas = new Pnl_recompensas();
    Pnl_reportes Pnl_reportes = new Pnl_reportes();

    CardLayout vista;


    public main() {
        InicializarForma();
        setExtendedState(MAXIMIZED_BOTH);
        vista = (CardLayout) Pnl_panel_principal.getLayout();

        btn_tienda.addActionListener(e -> setBtn_tienda());
        btn_album.addActionListener(e -> setBtn_album());
        btn_torneo.addActionListener(e -> setBtn_torneo());
        btn_recompensas.addActionListener(e -> setBtn_recompensas());
        btn_reportes.addActionListener(e -> setBtn_reportes());
    }

    public void InicializarForma(){
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        new main().setVisible(true);
        Catalogo.CargarDatos();
    }


    public void setBtn_tienda(){
        Pnl_panel_principal.add(Pnl_tienda.getPnl_vista_tienda(), "tienda");
        vista.show(Pnl_panel_principal,"tienda");

        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void setBtn_album(){
        Pnl_panel_principal.add(Pnl_album.getPnl_vista_album(), "album");
        vista.show(Pnl_panel_principal,"album");

        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void setBtn_torneo(){
        Pnl_panel_principal.add(Pnl_torneo.getPnl_vista_torneo(), "torneo");
        vista.show(Pnl_panel_principal,"torneo");

        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void setBtn_recompensas(){
        Pnl_panel_principal.add(Pnl_recompensas.getPnl_vista_recompensas(), "recompensas");
        vista.show(Pnl_panel_principal,"recompensas");

        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }

    public void setBtn_reportes(){
        Pnl_panel_principal.add(Pnl_reportes.getPnl_vista_reportes(), "reportes");
        vista.show(Pnl_panel_principal,"reportes");

        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }
}
