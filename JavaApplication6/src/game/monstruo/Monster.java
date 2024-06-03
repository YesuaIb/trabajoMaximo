package game.monstruo;

import java.util.Scanner;

public abstract class Monster {

    private String nombre;
    private int vida = 100;
    private boolean carnivoro;
    private boolean hervivoro;
    private int dañoRAW;
    private String debilidad;

    //metodos
    //name
    public String getNombre() {
        return nombre;
    }

    //atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //vida
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    //carnivoro
    public boolean isCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }

    //hervivoro
    public boolean isHervivoro() {
        return hervivoro;
    }

    public void setHervivoro(boolean hervivoro) {
        this.hervivoro = hervivoro;
    }

    //dañoRAW
    public int getDañoRAW() {
        return dañoRAW;
    }

    public void setDañoRAW(int dañoRAW) {
        this.dañoRAW = dañoRAW;
    }

    protected abstract void menu(Scanner sc, int cazadores);

    public void callmenu(Scanner sc, int cazadores) {
        menu(sc, cazadores);
    }

    protected void setDebilidad(String debilidad){
        this.debilidad = debilidad;
    }

    public String getDebilidad(){
        return this.debilidad;
    }
}
