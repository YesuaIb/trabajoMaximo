package game.monstruo;

import java.util.Scanner;

public class WyverPajaro extends Monster {

    private String size;  // Se usa para algo???
    private int dañoElem;
    private final String debilidad = "Gran Espada";

    public String getDebilidad() {
        return debilidad;
    }

    public String getSize() {
        return size;
    }

    public int getDañoElem() {
        return dañoElem;
    }

    public void setDañoElem(int dañoElem) {
        this.dañoElem = dañoElem;
    }

    @Override
    protected void menu(Scanner sc, int cazadores) {
        super.setDebilidad(this.debilidad);
        System.out.println("Monstruos");
        System.out.println("1. Kulu-yaku");
        System.out.println("2. Velocidrome");
        System.out.println("3. Yian kut kut");
        int monst = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                monst = sc.nextInt();
                if (monst < 1 || monst > 3) {
                    System.out.println("Opcion no valida\n");
                    System.out.println("Monstruos");
                    System.out.println("1. Kulu-yaku");
                    System.out.println("2. Velocidrome");
                    System.out.println("3. Yian kut kut");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida\n");
                System.out.println("Monstruos");
                System.out.println("1. Kulu-yaku");
                System.out.println("2. Velocidrome");
                System.out.println("3. Yian kut kut");
                sc.nextLine();
            }
        }
        switch (monst) {
            case 1:
                creacionkulu(cazadores);
                break;
            case 2:
                creacionVelo(cazadores);
                break;
            default:
                creacionYian(cazadores);
                break;
        }
    }

    private void creacionkulu(int cazadores) {
           setNombre("Kulu-yaku");
           setVida(60 * cazadores);
           setCarnivoro(true);
           setHervivoro(false);
           setDañoRAW(30);
           this.size = "Pequeño";
           this.dañoElem = 0;
    }
    
    private void creacionVelo(int cazadores) {
        setNombre("Velocidrome");
        setVida(40 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(30);
        this.size = "Pequeño";
        this.dañoElem = 0;
    }

    private void creacionYian(int cazadores) {
        setNombre("Yian kut kut");
        setVida(50 * cazadores);
        setCarnivoro(true);
        setHervivoro(true);
        setDañoRAW(50);
        this.size = "Grande";
        this.dañoElem = 10;
    }
}
