package clases;

public class Juego {
    //Atributos
    private String codigou;
    private String nombre;
    private String genero;
    private double precio;
    private String plataforma;
    private int stock;
    private String descripcion;

    //Constructor
    public Juego(String codigou, String nombre, String genero, double precio, String plataforma, int stock, String descripcion){
        this.codigou = codigou;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
        this.plataforma = plataforma;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public String getCodigou() {
        return codigou;
    }

    public void setCodigou(String codigou) {
        this.codigou = codigou;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(){
        this.descripcion = descripcion;
    }

    public void reducirStock(int cantidad){
        stock = stock - cantidad;
    }

}
