package estructuras;
import clases.*;

/*Clase con la creación de una lista y sus respectivos métodos*/

public class ListaCarrito {
    private NodoCarrito raiz;
    private NodoCarrito actual;

    public ListaCarrito(){
        this.raiz = null;
    }

    public void insertar(NodoCarrito nuevoNodo){
        if(raiz == null){
            raiz = nuevoNodo;
        }else{
            actual = raiz;
            while(actual.getSig() != null){
                actual = actual.getSig();
            }
            actual.getSig().setSig(nuevoNodo);
        }
    }

    public void eliminar(String item){
        actual = raiz;

        if(actual.getItem().getJuego().getNombre() == item){
            raiz = actual.getSig();
        }

        /* Se buscará en la lista a través de los apuntadores donde se encuentra el juego */
        while(actual.getSig() != null) {

            if (actual.getSig().getItem().getJuego().getNombre() == item) {
                actual = actual.getSig();
            }

            //Si no lo encuentra seguirá asignando el apuntador siguiente para buscar
            actual = actual.getSig();
        }
    }

    public boolean estaVacia(){
        if(raiz == null){
            return true;
        }
        return false;
    }

    /*Inicia buscando si el juego a comprar ya ha sido comprado con anterioridad
    en caso de que sí, solamente actualiza la cantidad.
     */

    public void agregarJuego(Juego juego, int cantidad){
        actual = raiz;

        while(actual != null){
            if(actual.getItem().getJuego() == juego){
                int nuevaCantidad = actual.getItem().getCantidadjuegos() + cantidad;
                actual.getItem().setCantidadjuegos(nuevaCantidad);

                actual.getItem().getJuego().setStock(actual.getItem().getJuego().getStock() - cantidad);
                return;
            }

            actual = actual.getSig();
        }

        //Si no existe, crea el item y lo introduce a la lista del carrito

        ItemCarrito item = new ItemCarrito(juego, cantidad);
        NodoCarrito nuevoNodo = new NodoCarrito(item);
        item.getJuego().setStock(item.getJuego().getStock() - cantidad);
        insertar(nuevoNodo);
    }

    public NodoCarrito getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoCarrito raiz) {
        this.raiz = raiz;
    }

    public NodoCarrito getActual() {
        return actual;
    }

    public void setActual(NodoCarrito actual) {
        this.actual = actual;
    }
}
