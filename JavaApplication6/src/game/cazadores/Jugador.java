package game.cazadores;

import java.util.Scanner;

/**
 *
 * @author Yesua
 */
public class Jugador extends Cazadores {

    //atributos
    private String name;
    private String arma;
    private boolean esquivar = false;

    public Jugador(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArma() {
        return this.arma;
    }

    public boolean getEsquivar(){
        return this.esquivar;
    }

    public void setEsquivar() {
        this.esquivar = !this.esquivar;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void setNivel(int nivel) {
        super.setNivel(nivel);
    }

    public void setVida(int vida) {
        super.setVida(vida);
    }

    public void setPociones(int pociones) {
        super.setPociones(pociones);
    }

    public int getNivel() {
        return super.getNivel();
    }

    public int getVida() {
        return super.getVida();
    }

    public int getPociones() {
        return super.getPociones();
    }
    
    public void menu(Scanner sc) {
        System.out.println("Armas");
        System.out.println("1. Espada Larga");
        System.out.println("2. Martillo");
        System.out.println("3. Gran Espada");
        System.out.println("4. Arco");
        int arm = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                arm = sc.nextInt();
                if (arm < 1 || arm > 4) {
                    System.out.println("\nOpcion no valida");
                    System.out.println("Armas");
                    System.out.println("1. Espada Larga");
                    System.out.println("2. Martillo");
                    System.out.println("3. Gran Espada");
                    System.out.println("4. Arco");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("\nOpcion no valida");
                System.out.println("Armas");
                System.out.println("1. Espada Larga");
                System.out.println("2. Martillo");
                System.out.println("3. Gran Espada");
                System.out.println("4. Arco");
                sc.nextLine();
            }
            
        }
        switch (arm) {
                case 1:
                    setArma("Espada Larga");
                    break;
                case 2:
                    setArma("Martillo");
                    break;
                case 3:
                    setArma("Gran Espada");
                    break;
                default:
                    setArma("Arco");
                    break;
            }
            
            System.out.println("el cazador " + getName() + " utilizara el arma " + getArma() );
    }
}

    