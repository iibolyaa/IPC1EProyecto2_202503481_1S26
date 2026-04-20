package estructuras;
import clases.Juego;

public class NodoCarrito {
    private Juego juego;
    private NodoCarrito sig;

    public NodoCarrito(Juego juego) {
        this.juego =  juego;
        this.sig = null;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public NodoCarrito getSig() {
        return sig;
    }

    public void setSig(NodoCarrito sig) {
        this.sig = sig;
    }
}
