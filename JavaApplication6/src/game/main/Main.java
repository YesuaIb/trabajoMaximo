package game.main;

import game.monstruo.*;
import game.cazadores.Jugador;
import game.datos.Base;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Yesua
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Iniciar partida
        System.out.println("¿Iniciar partida o crear una nueva?");
        System.out.println("1. Cargar");
        System.out.println("2. Nueva Partida");
        System.out.println("3. Salir");
        int opcionIni = sc.nextInt();
        switch(opcionIni){
            case 1:
                Base.CargarPartida();
                break;
            case 2:
               nuevapartida();
               break; 
            default:
                sc.close();
                System.out.println("Adios");
                System.exit(0);
        }
    }

        // menus tanto de cazadores como de tipos
    private static void nuevapartida(){
        Scanner sc = new Scanner(System.in);
        int cantidad = cantidad(sc);
        int tipo = menuTipo(sc);
        Jugador[] jugadores = new Jugador[cantidad]; 
        Monster monstruo = null; // Iniciamos globalmente un Monstruo (sin saber el tipo que es)
        //depende del tipo se accedera a un menu en concreto
        switch (tipo) {
            case 1:
                monstruo = new WyverBestia();
                monstruo.callmenu(sc, cantidad);
                System.out.println("Nombre " + monstruo.getNombre());
                break;
            case 2:
                monstruo = new WyverColosal();
                monstruo.callmenu(sc, cantidad);
                System.out.println("Nombre " + monstruo.getNombre());
                break;
            case 3:
                monstruo = new WyverPajaro();
                monstruo.callmenu(sc, cantidad);
                System.out.println("Nombre " + monstruo.getNombre());
                
                break;
            case 4:
                monstruo = new WyverVolador();
                monstruo.callmenu(sc, cantidad);
                System.out.println("Nombre " + monstruo.getNombre());
                
                break;
            default:
                System.out.println("Opcion no valida");
        }
        Jugadores(sc,cantidad,jugadores);

        Pelea.Combate(jugadores, monstruo, sc);
    }

    private static int cantidad(Scanner sc) {
        System.out.println("Cantidasd de cazadores (1-4)");
        boolean entradaValida = false;
        int cazadores = 0;
        while (!entradaValida) {
            try {
                cazadores = sc.nextInt();
                if (cazadores < 1 || cazadores >= 5) {
                    System.out.println("No es posible cazar");
                    System.out.println("\nCantidasd de cazadores (1-4)");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("No es posible cazar");
                System.out.println("\nCantidasd de cazadores (1-4)");
                sc.nextLine();
            }
        }
        return cazadores;
    }

    private static int menuTipo(Scanner sc) {
        System.out.println("Menu tipo de bicho");
        System.out.println("1. Bestia");
        System.out.println("2. Colosal");
        System.out.println("3. Pajaro");
        System.out.println("4. Volador");

        boolean entradaValida = false;
        int tipo = 0;

        while (!entradaValida) {
            try {
                tipo = sc.nextInt();
                if (tipo < 1 || tipo >= 5) {
                    System.out.println("No es un valor valido.\n");
                    System.out.println("Menu tipo de bicho");
                    System.out.println("1. Bestia");
                    System.out.println("2. Colosal");
                    System.out.println("3. Pajaro");
                    System.out.println("4. Volador");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("No es un valor valido.\n");
                System.out.println("Menu tipo de bicho");
                System.out.println("1. Bestia");
                System.out.println("2. Colosal");
                System.out.println("3. Pajaro");
                System.out.println("4. Volador");
                sc.nextLine();
            }
        }
        return tipo;
    }

    private static void Jugadores(Scanner sc, int cantidad,Jugador[] jugadores ){
        for(int i = 0; i < cantidad; i++){
            System.out.println("Introduce tu nombre:");
            sc.nextLine();
            String nombre = sc.nextLine();
            while (nombre.length()<1){
                System.out.println("Debe rellenar el campo del nombre.");
                System.out.println("Introduce tu nombre:");
                sc.nextLine();
                nombre = sc.nextLine();
            }
            jugadores[i]= new Jugador(nombre);
            jugadores[i].menu(sc);
        }
    }
}
