package game.monstruo;

import java.util.Scanner;

public class WyverColosal extends Monster {

    private final String debilidad = "Martillo";

    public String getDebilidad() {
        return debilidad;
    }

    @Override
    protected void menu(Scanner sc, int cazadores) {
        super.setDebilidad(this.debilidad);
        System.out.println("Monstruos");
        System.out.println("1. Banbaro");
        System.out.println("2. Brachydios");
        System.out.println("3. Deviljho");
        int monst = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                monst = sc.nextInt();
                if (monst < 1 || monst > 3) {
                    System.out.println("Opcion no valida\n");
                    System.out.println("Monstruos");
                    System.out.println("1. Banbaro");
                    System.out.println("2. Brachydios");
                    System.out.println("3. Deviljho");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida\n");
                System.out.println("Monstruos");
                System.out.println("1. Banbaro");
                System.out.println("2. Brachydios");
                System.out.println("3. Deviljho");
                sc.nextLine();
            }
            switch (monst) {
                case 1:
                    creacionBan(cazadores);
                    break;
                case 2:
                    creacionBra(cazadores);
                    break;
                default:
                    creacionDevi(cazadores);
                    break;
            }
        }
    }
    
    private void creacionBan(int cazadores) {
        setNombre("Banbaro");
        setVida(150 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(15);
    }

    private void creacionBra(int cazadores) {
        setNombre("Brachydios");
        setVida(120 * cazadores);
        setCarnivoro(true);
        setHervivoro(true);
        setDañoRAW(50);
       
    }

    private void creacionDevi(int cazadores) {
        setNombre("Deviljho");
        setVida(150 * cazadores);
        setCarnivoro(true);
        setHervivoro(false);
        setDañoRAW(100);
    }
}
