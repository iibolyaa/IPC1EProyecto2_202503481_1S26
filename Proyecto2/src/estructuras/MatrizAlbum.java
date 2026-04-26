package estructuras;
import clases.*;

//Clase para almacenar las cartas de la sesión actual

public class MatrizAlbum {
    private NodoMatriz[][] matriz;
    private int filas = 6;
    private int columnas = 4;
    private NodoMatriz raiz;

    public MatrizAlbum(){
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new NodoMatriz[filas][columnas];
        construir();
        this.raiz = matriz[0][0];
    }

    /*Método que crea los nodos y los enlaza según el tamaño que se prestableció
    con anterioridad*/
    private void construir(){
        // Crear la cuadricula
        for(int f = 0; f < filas; f++){
            for(int c = 0; c < columnas; c++){
                matriz[f][c] = new NodoMatriz(null, f, c);
            }
        }

        //Enlazar los nodos
        for(int f = 0; f < filas; f++){
            for(int c = 0; c < columnas; c++){
                if(f>0) matriz[f][c].setNorte(matriz[f-1][c]);
                if(f<filas-1) matriz[f][c].setSur(matriz[f+1][c]);
                if(c < columnas - 1) matriz[f][c].setEste(matriz[f][c+1]);
                if(c>0) matriz[f][c].setOeste(matriz[f][c-1]);
            }
        }
    }


    public boolean insertarCarta(Carta carta){
        NodoMatriz actualfila = raiz;

        while(actualfila != null){
            NodoMatriz actualcolumna = actualfila;
        while(actualcolumna != null){
            if(actualcolumna.getCarta() == null){
                actualcolumna.setCarta(carta);
                return true;
            }
            actualcolumna = actualcolumna.getEste();
        }
        actualfila =  actualfila.getSur();
        }
        return false;
    }

    public NodoMatriz getNodoMatriz(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) return null;
        return matriz[fila][columna];
    }

    public NodoMatriz[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(NodoMatriz[][] matriz) {
        this.matriz = matriz;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
