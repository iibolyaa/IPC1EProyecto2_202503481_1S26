package estructuras;
import clases.*;

public class NodoCarrito {
    private ItemCarrito item;
    private NodoCarrito sig;

    public NodoCarrito(ItemCarrito item) {
        this.item =  item;
        this.sig = null;
    }

    public ItemCarrito getItem() {
        return item;
    }

    public void setItem(ItemCarrito item) {
        this.item = item;
    }

    public NodoCarrito getSig() {
        return sig;
    }

    public void setSig(NodoCarrito sig) {
        this.sig = sig;
    }
}
