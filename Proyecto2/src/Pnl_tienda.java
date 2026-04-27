import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import clases.*;
import datos.*;
import estructuras.*;

import java.awt.*;

public class Pnl_tienda extends Component {
    private JPanel Pnl_vista_tienda;
    private JPanel Pnl_vista_juegos;
    private JPanel Pnl_vista_carrito;
    private JComboBox comboBox_Plataforma;
    private JComboBox comboBox_Genero;
    private JTabbedPane tabbedPane1;
    private JPanel Pnl_carrito;
    private JPanel Pnl_historial;
    private JButton Btn_sv;
    private JLabel RPG;
    private JButton Btn_hk;
    private JButton Btn_mk;
    private JButton Btn_ch;
    private JButton Btn_hl;
    private JButton Btn_oc;
    private JTextField busqueda;
    private JTable tablaCarrito;
    private JTable tablaHistorial;
    private JButton Btn_eliminarItem;
    private JButton Btn_confirmarCompra;
    private JButton Btn_ac;
    private JButton Btn_limpiarCarrito;
    private JScrollPane scrollhistorial;
    private JButton Btn_Buscar;
    private JPanel StardewValley;
    private JPanel HollowKnight;
    private JPanel MarioKart;
    private JPanel AnimalCrossing;
    private JPanel Cuphead;
    private JPanel HogwartsLegacy;
    private JPanel Overcooked;
    private DefaultTableModel tablaModeloCarrito;
    private DefaultTableModel tablaModeloHistorial;

    ListaCarrito carrito = new ListaCarrito();
    ListaHistorial insertarhistorial = new ListaHistorial();

    public Pnl_tienda(){
        StardewValley.setName("StardewValley");
        HollowKnight.setName("HollowKnight");
        MarioKart.setName("MarioKart");
        AnimalCrossing.setName("AnimalCrossing");
        Cuphead.setName("Cuphead");
        HogwartsLegacy.setName("HogwartsLegacy");
        Overcooked.setName("Overcooked");

        Historial.CargarDatos();
        listarHistorial();

        Btn_sv.addActionListener(e -> agregar_sv());
        Btn_hk.addActionListener(e -> agregar_hk());
        Btn_mk.addActionListener(e -> agregar_mk());
        Btn_ac.addActionListener(e -> agregar_ac());
        Btn_ch.addActionListener(e -> agregar_ch());
        Btn_hl.addActionListener(e -> agregar_hl());
        Btn_oc.addActionListener(e -> agregar_oc());
        Btn_eliminarItem.addActionListener(e -> eliminarItem());
        Btn_limpiarCarrito.addActionListener(e -> limpiarCarrito());
        Btn_confirmarCompra.addActionListener(e -> confirmarCompra());
        Btn_Buscar.addActionListener(e -> busqueda());

        busqueda.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { busquedaTexto(); }
            public void removeUpdate(DocumentEvent e) { busquedaTexto(); }
            public void changedUpdate(DocumentEvent e) { busquedaTexto(); }
        });
    }

    private void agregar_sv(){
        String nombreJuego = "Stardew Valley";
        Juego sv = Catalogo.buscarjuego(nombreJuego);

        if(sv.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(sv, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void agregar_hk(){
        String nombreJuego = "Hollow Knight";
        Juego hk = Catalogo.buscarjuego(nombreJuego);

        if(hk.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(hk, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void agregar_mk(){
        String nombreJuego = "Mario Kart";
        Juego mk = Catalogo.buscarjuego(nombreJuego);

        if(mk.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(mk, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void agregar_ac(){
        String nombreJuego = "Animal Crossing";
        Juego ac = Catalogo.buscarjuego(nombreJuego);

        if(ac.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(ac, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void agregar_ch(){
        String nombreJuego = "Cuphead";
        Juego ch = Catalogo.buscarjuego(nombreJuego);

        if(ch.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(ch, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void agregar_hl(){
        String nombreJuego = "Hogwarts Legacy";
        Juego hl = Catalogo.buscarjuego(nombreJuego);

        if(hl.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(hl, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void agregar_oc(){
        String nombreJuego = "Overcooked";
        Juego oc = Catalogo.buscarjuego(nombreJuego);

        if(oc.getStock() > 0){
            int cantidad = 1;

            carrito.agregarJuego(oc, cantidad);
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay más stock disponible"
            );
        }
    }

    private void listarCarrito(){
        this.tablaModeloCarrito.setRowCount(0);

        carrito.setActual(carrito.getRaiz());

        while(carrito.getActual() != null){
            ItemCarrito item = carrito.getActual().getItem();

            Object[] renglonCarrito = {
                    item.getJuego().getCodigou(),
                    item.getJuego().getNombre(),
                    item.getJuego().getPrecio(),
                    item.getCantidadjuegos()
            };
            this.tablaModeloCarrito.addRow(renglonCarrito);
            carrito.setActual(carrito.getActual().getSig());
        }
    }

    private void eliminarItem(){
        if(!carrito.estaVacio()) {
            var renglon = tablaCarrito.getSelectedRow();
            if (renglon != -1) {
                var item = tablaCarrito.getModel().getValueAt(renglon, 1).toString();
                carrito.eliminar(item);

                listarCarrito();
            }
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay productos en el carrito");
        }
    }

    private void limpiarCarrito(){
        if(!carrito.estaVacio()) {
            carrito.limpiarCarrito();
            listarCarrito();
        }else{
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay productos en el carrito");
        }
    }

    private void confirmarCompra(){
        if(!carrito.estaVacio()){
            if(insertarhistorial.procesarCompra(carrito)){
                listarCarrito();
                listarHistorial();
            }
        }else {
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "No hay productos en el carrito"
            );
        }
    }

    public void listarHistorial(){
        this.tablaModeloHistorial.setRowCount(0);

        Historial.getHistorial().setActual(Historial.getHistorial().getRaiz());

        while(Historial.getHistorial().getActual() != null){
            NodoHistorial linea = Historial.getHistorial().getActual();

            Object[] renglonHistorial = {
                    linea.getRegistro()
            };
            this.tablaModeloHistorial.addRow(renglonHistorial);
            Historial.getHistorial().setActual(Historial.getHistorial().getActual().getSig());
        }
    }

    private void busqueda(){
        String plataforma = comboBox_Plataforma.getSelectedItem().toString();
        String genero = comboBox_Genero.getSelectedItem().toString();


        for(int i = 0; i < Catalogo.getContadorJuegos(); i++) {
            Juego j = Catalogo.getJuegosdisponibles()[i];

            boolean coincidePlataforma = plataforma.equals("Todas") || j.getPlataforma().equals(plataforma);
            boolean coincideGenero = genero.equals("Todos") || j.getGenero().equals(genero);

            String nombrePanel = j.getNombre().replace(" ", "");
            Component comp = buscarComponente(Pnl_vista_juegos, nombrePanel);

            if (comp != null) {
                comp.setVisible(coincidePlataforma || coincideGenero);
            }else{
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(this),
                        "No se encontraron coincidencias"
                );
            }
        }

        Pnl_vista_juegos.revalidate();
        Pnl_vista_juegos.repaint();
    }

    private void busquedaTexto(){
        String texto = busqueda.getText().toLowerCase().trim();

        for(int i = 0; i < Catalogo.getContadorJuegos(); i++){
            Juego j = Catalogo.getJuegosdisponibles()[i];
            boolean coincideTexto = texto.isEmpty() || j.getNombre().toLowerCase().contains(texto) || j.getCodigou().toLowerCase().contains(texto);

            String nombrePanel = j.getNombre().replace(" ", "");
            Component comp = buscarComponente(Pnl_vista_juegos, nombrePanel);

            if(comp != null){
                comp.setVisible(coincideTexto);
            }
        }

        Pnl_vista_juegos.revalidate();
        Pnl_vista_juegos.repaint();
    }

    private Component buscarComponente(Container contenedor, String nombre){
        for(Component comp : contenedor.getComponents()){
            if(nombre.equals(comp.getName())){
                return comp;
            }
        }
        return null;
    }

    public JPanel getPnl_vista_tienda() {
        return Pnl_vista_tienda;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.tablaModeloCarrito = new DefaultTableModel(0,4);
        String[] cabeceros = {"Código", "Nombre", "Precio", "Cantidad"};
        this.tablaModeloCarrito.setColumnIdentifiers(cabeceros);
        this.tablaCarrito = new JTable(tablaModeloCarrito);

        this.tablaModeloHistorial = new DefaultTableModel(0,1);
        String[] cabeceros1 = {"Descripción"};
        this.tablaModeloHistorial.setColumnIdentifiers(cabeceros1);
        this.tablaHistorial = new JTable(tablaModeloHistorial);
    }
}