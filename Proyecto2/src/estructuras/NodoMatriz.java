package estructuras;
import clases.*;

public class NodoMatriz {
    private Carta carta;
    private NodoMatriz este;
    private NodoMatriz oeste;
    private NodoMatriz norte;
    private NodoMatriz sur;
    private int col;
    private int fila;

    public NodoMatriz(Carta carta, int col, int fila){
        this.carta = carta;
        this.norte = null;
        this.sur = null;
        this.este = null;
        this.oeste = null;
        this.fila = fila;
        this.col = col;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public NodoMatriz getEste() {
        return este;
    }

    public void setEste(NodoMatriz este) {
        this.este = este;
    }

    public NodoMatriz getOeste() {
        return oeste;
    }

    public void setOeste(NodoMatriz oeste) {
        this.oeste = oeste;
    }

    public NodoMatriz getNorte() {
        return norte;
    }

    public void setNorte(NodoMatriz norte) {
        this.norte = norte;
    }

    public NodoMatriz getSur() {
        return sur;
    }

    public void setSur(NodoMatriz sur) {
        this.sur = sur;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

}
