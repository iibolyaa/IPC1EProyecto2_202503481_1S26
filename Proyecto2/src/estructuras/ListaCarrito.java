package estructuras;
import clases.Juego;

public class ListaCarrito {
    private NodoCarrito raiz;
    private NodoCarrito actual;

    public ListaCarrito(){
        this.raiz = null;
    }

    public void insertar(Juego juego){
        NodoCarrito nuevoNodo = new NodoCarrito(juego);

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

    public void eliminar(Juego juego){
        actual = raiz;

        if(actual.getJuego() == juego){
            raiz = actual.getSig();
        }

        /* Se buscará en la lista a través de los apuntadores donde se encuentra el juego */
        while(actual.getSig() != null) {

            if (actual.getSig().getJuego() == juego) {
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
}
