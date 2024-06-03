
package game.monstruo;

import java.util.Scanner;

/**
 *
 * @author Yesua
 */
public class WyverVolador extends Monster {

    private final int dañoReduc = 2; // Se usará para algo???
    private int dañoElem;
    private final String debilidad = "Arco";

    public String getDebilidad() {
        return debilidad;
    }

    public int getDañoReduc() {
        return dañoReduc;
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
        System.out.println("1. Rathalos");
        System.out.println("2. Valstrax");
        System.out.println("3. Legiana");
        int monst = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                monst = sc.nextInt();
                if (monst < 1 || monst > 3) {
                    System.out.println("Opcion no valida\n");
                    System.out.println("Monstruos");
                    System.out.println("1. Rathalos");
                    System.out.println("2. Valstrax");
                    System.out.println("3. Legiana");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida\n");
                System.out.println("Monstruos");
                System.out.println("1. Rathalos");
                System.out.println("2. Valstrax");
                System.out.println("3. Legiana");
                sc.nextLine();
            }
            switch (monst) {
                case 1:
                    creacionRath(cazadores);
                    break;
                case 2:
                    creacionVals(cazadores);
                    break;
                default:
                    creacionLeg(cazadores);
                    break;
            }
        }
    }
    
    private void creacionRath(int cazadores) {
        setNombre("Rathalos");
        setVida(100 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(50);
        this.dañoElem = 10;
    }

    private void creacionVals(int cazadores) {
        setNombre("Valstrax");
        setVida(80 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(50);
        this.dañoElem = 50;
    }

    private void creacionLeg(int cazadores) {
        setNombre("Legiana");
        setVida(100 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(10);
        this.dañoElem = 50;
    }
}
