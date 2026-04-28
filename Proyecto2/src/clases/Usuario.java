package clases;

public class Usuario {
    private String id;
    private String password;
    private int xp;
    private int nivel;

    public Usuario(String id, String password, int xp, int nivel) {
        this.id = id;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}






