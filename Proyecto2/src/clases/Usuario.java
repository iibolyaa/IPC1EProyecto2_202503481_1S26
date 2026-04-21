package clases;

public class Usuario {
    private String id;
    private int xp;
    private int nivel;

    public Usuario(String id, int xp, int nivel) {
        this.id = id;
        this.xp = xp;
        this.nivel = nivel;
    }

    public void otorgarXP(int cantidad){
        xp = xp + cantidad;
    }

    public void subirNivel(){
        nivel = nivel + 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}






