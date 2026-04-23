package estructuras;

public class NodoHistorial {
    NodoHistorial sig;
    String registro;

    public NodoHistorial(String registro){
        this.registro = registro;
        this.sig = null;
    }

    public NodoHistorial getSig() {
        return sig;
    }

    public void setSig(NodoHistorial sig) {
        this.sig = sig;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
