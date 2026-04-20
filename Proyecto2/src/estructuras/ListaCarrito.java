package estructuras;
import clases.Juego;

public class ListaCarrito {
    private NodoCarrito raiz;
    private NodoCarrito aux;

    public ListaCarrito(){
        this.raiz = null;
    }

    public void insertar(Juego juego){
        NodoCarrito nuevoNodo = new NodoCarrito(juego);

        if(this.raiz == null){
            this.raiz = nuevoNodo;
        }else{
            aux = raiz;
            while(aux.getSig() != null){
                aux = aux.getSig();
            }
            aux.getSig().setSig(nuevoNodo);
        }
    }

    public void eliminar(Juego juego){
        NodoCarrito aux = raiz;

        if(aux.getJuego() == juego){
          
        }
    }
}
