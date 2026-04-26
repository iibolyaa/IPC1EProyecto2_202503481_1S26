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
            actual.setSig(nuevoNodo);
        }
    }

    public void eliminar(String item){

        if(raiz == null){
            return;
        }

        if(raiz.getItem().getJuego().getNombre().equals(item)){
            raiz = raiz.getSig();
            return;
        }

        NodoCarrito anterior = raiz;
        NodoCarrito actual = raiz.getSig();

        /* Se buscará en la lista a través de los apuntadores donde se encuentra el juego */
        while(actual != null) {

            if (actual.getItem().getJuego().getNombre().equals(item)){
                anterior.setSig(actual.getSig());
            }

            //Si no lo encuentra seguirá asignando el apuntador siguiente para buscar
            anterior = actual;
            actual = actual.getSig();
        }
    }

    public boolean estaVacio(){
        if(raiz == null){
            return true;
        }
        return false;
    }

    /*Inicia buscando si el juego a agregar ya ha sido agregado con anterioridad
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

    public void limpiarCarrito(){
        raiz = null;
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
