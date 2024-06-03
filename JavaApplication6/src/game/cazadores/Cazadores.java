
package game.cazadores;


public class Cazadores {
  
    private int vida = 150;
    private int defensa = 100;
    private int nivel = 1;
    private int pociones=5;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setPociones(int pociones){
        this.pociones = pociones;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida() {
        return this.vida;
    }
    
    public int nivelUp(){
        this.nivel++;
        return this.nivel;
    }
    
    public int getPociones(){
        return this.pociones;
    }
}
