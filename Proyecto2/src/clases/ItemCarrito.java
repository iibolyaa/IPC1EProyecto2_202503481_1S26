package clases;

public class ItemCarrito {
    private Juego juego;
    private int cantidadjuegos;

    public ItemCarrito(Juego juego, int cantidadjuegos){
        this.juego = juego;
        this.cantidadjuegos = cantidadjuegos;
    }

    public double getSubtotal(Juego juego, double cantidadjuegos){
        double subtotal = juego.getPrecio()*cantidadjuegos;
        return subtotal;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public int getCantidadjuegos() {
        return cantidadjuegos;
    }

    public void setCantidadjuegos(int cantidadjuegos) {
        this.cantidadjuegos = cantidadjuegos;
    }
}
