package game.monstruo;

import java.util.Scanner;

/**
 *
 * @author Yesua
 */
public class WyverBestia extends Monster {

    private final String debilidad = "Espada Larga";

    public String getDebilidad() {
        return debilidad;
    }

    @Override
    protected void menu(Scanner sc, int cazadores) {
        super.setDebilidad(this.debilidad);
        System.out.println("Monstruos");
        System.out.println("1. Zinogre");
        System.out.println("2. Magnamalo");
        System.out.println("3. Odogaron");
        int monst = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                monst = sc.nextInt();
                if (monst < 1 || monst > 3) {
                    System.out.println("Opcion no valida\n");
                    System.out.println("Monstruos");
                    System.out.println("1. Zinogre");
                    System.out.println("2. Magnamalo");
                    System.out.println("3. Odogaron");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida\n");
                System.out.println("Monstruos");
                System.out.println("1. Zinogre");
                System.out.println("2. Magnamalo");
                System.out.println("3. Odogaron");

                sc.nextLine();
            }
            switch (monst) {
                case 1:
                    creacionZin(cazadores);
                    break;
                case 2:
                    creacionMag(cazadores);
                    break;
                default:
                    creacionOdo(cazadores);
                    break;
            }
        }
    }

    private void creacionZin(int cazadores) {
        setNombre("Zinogre");
        setVida(100 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(30);
    }

    private void creacionMag(int cazadores) {
        setNombre("Magnamalo");
        setVida(110 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(50);

    }

    private void creacionOdo(int cazadores) {
        setNombre("Odogaron");
        setVida(80 * cazadores);
        setCarnivoro(true);
        setHervivoro(true);
        setDañoRAW(100);
    }
}
