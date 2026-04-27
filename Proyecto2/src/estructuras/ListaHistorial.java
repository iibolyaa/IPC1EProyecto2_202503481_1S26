package estructuras;
import datos.*;
import clases.*;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListaHistorial {
    private NodoHistorial raiz;
    private NodoHistorial actual;

    public ListaHistorial() {
        this.raiz = null;
    }

    public void InsertarAlInicio(NodoHistorial nuevoNodo) {
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            nuevoNodo.setSig(raiz);
            raiz = nuevoNodo;
        }
    }

    public boolean procesarCompra(ListaCarrito Carrito){
        if(Carrito.estaVacio()){
            return false;
        }

        NodoCarrito ItemActual = Carrito.getRaiz();
        String descripcion = "";
        double total = 0.0;

        while(ItemActual != null){

/*           String codigoJuego = ItemActual.getItem().getJuego().getCodigou();//
                for(int i = 0; i < Catalogo.getJuegosdisponibles().length; i++){
                if(codigoJuego == Catalogo.getJuegosdisponibles()[i].getCodigou()){

                    Juego juegocarrito = Catalogo.getJuegosdisponibles()[i];

                    total += ItemActual.getItem().getSubtotal(juegocarrito, cantidad);
                    descripcion += Catalogo.getJuegosdisponibles()[i].getNombre() + "x" + cantidad + ", ";
                    break;
                }
            } */

            int cantidad = ItemActual.getItem().getCantidadjuegos();

            Juego juegocarrito =  ItemActual.getItem().getJuego();
            total += ItemActual.getItem().getSubtotal(juegocarrito, cantidad);
            descripcion += juegocarrito.getNombre() + "x" + cantidad + ", ";

            ItemActual = ItemActual.getSig();
        }

        //Actualizar en el archivo del catálogo
        Catalogo.modificarStock();

        //Crear nodo con los respectivos datos
        Date hoy = new Date();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a");

        String fecha = formatoFecha.format(hoy);
        String hora = formatoHora.format(hoy);

        String registro = fecha + "|" + hora + "|" + descripcion + "|" + total;
        NodoHistorial historial = new NodoHistorial(registro);

        //Insertarlo a la lista y guardar en archivo de historial
        Historial.getHistorial().InsertarAlInicio(historial);
        Historial.registroCompra(registro);
        // UsuarioActual.otorgarXP(50);

        Carrito.limpiarCarrito();
        return true;
    }

    public NodoHistorial getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoHistorial raiz) {
        this.raiz = raiz;
    }

    public NodoHistorial getActual() {
        return actual;
    }

    public void setActual(NodoHistorial actual) {
        this.actual = actual;
    }
}
