import datos.Album;
import datos.Catalogo;
import clases.*;
import datos.Usuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel Pnl_login;
    private JTextField Campo_usuario;
    private JTextField Campo_password;
    private JButton Btn_iniciar;
    private JButton Btn_registrarse;
    private JPanel Pnl_campos;

    public Login() {
        inicializarForma();
        setLocationRelativeTo(null);
        Btn_iniciar.addActionListener(e -> {
            validar();
        });
    }

    private void inicializarForma(){
        setContentPane(Pnl_login);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
    }

    private void validar(){
        String usuario = this.Campo_usuario.getText();
        String password = this.Campo_password.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }else if(Usuarios.validar(usuario, password)){
            new main().setVisible(true);
            Usuarios.getUsuarioActual().otorgarXP(10);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    public static void main(String args[]) {
        Catalogo.CargarDatos();
        Album.CargarDatos();
        new Login().setVisible(true);
    }

}
