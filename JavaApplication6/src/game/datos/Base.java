package game.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import game.cazadores.Jugador;
import game.main.Main;
import game.main.Pelea;
import game.monstruo.Monster;
import game.monstruo.WyverBestia;
import game.monstruo.WyverColosal;
import game.monstruo.WyverPajaro;
import game.monstruo.WyverVolador;

public class Base {

    final static String rutaArchivo = "JavaApplication6/src/game/datos/partida.txt";


    public static void CargarPartida(){     
        // Ruta relativa al archivo dentro del mismo directorio

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             Scanner sc = new Scanner(System.in)) {

            int cazadores = 0;
            String linea;

            while ((linea = br.readLine()) != null) {
                // Separar la línea por ';'
                String[] partes = linea.split(";");
                if (partes.length >= 5) {
                    String nombre = partes[0];
                    String arma = partes[1];
                    String puntosDeVida = partes[2];
                    String nivel = partes[3];
                    String pociones = partes[4];

                    System.out.println("El cazador número " + (cazadores + 1) + " es " + nombre +
                                        ", usa el arma " + arma + 
                                        " y le quedan " + puntosDeVida + " puntos de vida.\n" +
                                        "Es nivel " + nivel + " y le quedan " + pociones + " pociones.\n");

                    cazadores++;
                }
            }

            System.out.println("¿Deseas cargar esta partida?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int respuesta = sc.nextInt();

            while (respuesta != 1 && respuesta != 2) {
                System.out.println("\n¡Introduzca una respuesta válida!");
                System.out.println("¿Deseas cargar esta partida?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                respuesta = sc.nextInt();
            }
            System.out.println("\n");

            switch (respuesta) {
                case 1:
                    Jugador[] jugadores = new Jugador[cazadores];
                    // Reinicializamos el BufferedReader para leer desde el principio nuevamente
                    try (BufferedReader br2 = new BufferedReader(new FileReader(rutaArchivo))) {
                        creacionPartida(br2, jugadores, sc);
                    }
                    break;
                default:
                    Main.main(null);
                    break;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }

    private static void creacionPartida(BufferedReader br, Jugador[] jugadores, Scanner sc) throws IOException {
        String linea;
        int total = 0;

        while ((linea = br.readLine()) != null) {
            // Separar la línea por ';'
            String[] partes = linea.split(";");
            if (partes.length >= 5) {
                String nombre = partes[0];
                String arma = partes[1];
                int puntosDeVida = Integer.parseInt(partes[2]);
                int nivel = Integer.parseInt(partes[3]);
                int pociones = Integer.parseInt(partes[4]);

                jugadores[total] = new Jugador(nombre);
                jugadores[total].setArma(arma);
                jugadores[total].setNivel(nivel);
                jugadores[total].setPociones(pociones);
                jugadores[total].setVida(puntosDeVida);

                total++;
            }
        }

        Monster monstruo = menuTipo(sc, jugadores); 
        Pelea.Combate(jugadores, monstruo, sc);
    }

    private static Monster menuTipo(Scanner sc, Jugador[] jugadores) {
        Monster monstruo = null; // Iniciamos globalmente un Monstruo (sin saber el tipo que es)
        //depende del tipo se accedera a un menu en concreto
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
        switch (tipo) {
            case 1:
                monstruo = new WyverBestia();
                monstruo.callmenu(sc, jugadores.length);
                System.out.println("Nombre " + monstruo.getNombre());
                break;
            case 2:
                monstruo = new WyverColosal();
                monstruo.callmenu(sc, jugadores.length);
                System.out.println("Nombre " + monstruo.getNombre());
                break;
            case 3:
                monstruo = new WyverPajaro();
                monstruo.callmenu(sc, jugadores.length);
                System.out.println("Nombre " + monstruo.getNombre());
                
                break;
            case 4:
                monstruo = new WyverVolador();
                monstruo.callmenu(sc, jugadores.length);
                System.out.println("Nombre " + monstruo.getNombre());
                
                break;
            default:
                System.out.println("Opcion no valida");
        }
        return monstruo;
    }

    public static void MenuFinal(Jugador[] jugadores, Scanner sc) {
        System.out.println("Enhorabuena, ¡has derrotado al monstruo!");
        System.out.println("¿Qué quieres hacer ahora?");
        System.out.println("1. Guardar partida.");
        System.out.println("2. Siguiente caza.");
        System.out.println("3. Salir sin guardar.");

        boolean entradaValida = false;
        int respuesta = 0;

        while (!entradaValida) {
            try {
                respuesta = sc.nextInt();
                if (respuesta < 1 || respuesta >= 4) {
                    System.out.println("No es un valor valido.\n");
                    System.out.println("Enhorabuena, ¡has derrotado al monstruo!");
                    System.out.println("¿Qué quieres hacer ahora?");
                    System.out.println("1. Guardar partida.");
                    System.out.println("2. Siguiente caza.");
                    System.out.println("3. Salir sin guardar.");
                    sc.nextLine();
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("No es un valor valido.\n");
                System.out.println("Enhorabuena, ¡has derrotado al monstruo!");
                System.out.println("¿Qué quieres hacer ahora?");
                System.out.println("1. Guardar partida.");
                System.out.println("2. Siguiente caza.");
                System.out.println("3. Salir sin guardar.");
                sc.nextLine();
            }
        }

        switch (respuesta) {
            case 1:
                GuardarPartida(jugadores);
                break;
            
            case 2:
                menuTipo(sc, jugadores);
                break;

            default:
                System.exit(0);
                break;
        }
    }

    private static void GuardarPartida(Jugador[] jugadores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Jugador jugador : jugadores) {
                bw.write(jugador.getName() + ";" +
                         jugador.getArma() + ";" +
                         jugador.getVida() + ";" +
                         jugador.getNivel() + ";" +
                         jugador.getPociones() + ";\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
