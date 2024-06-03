package game.main;

import game.monstruo.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.cazadores.*;
import game.datos.Base;

public class Pelea {

    public static void Combate(Jugador[] jugadores, Monster monstruo, Scanner sc) {
        
        boolean rage = false;

        while (monstruo.getVida() > 0){

            // Turno del monstruo

            System.out.println("Turno de: "+monstruo.getNombre());
            int acc = (int) (Math.random() * 3 + 1);
            int rec = (int) (Math.random() * jugadores.length);
            switch (acc) {
                case 1:

                    System.out.println(monstruo.getNombre()+" ataca a "+jugadores[rec].getName());
                    
                    // Leemos la vida del jugador al que va a atacar
                    int vidaActual = jugadores[rec].getVida();

                    // Si el jugador al que ataca está esquivando se libra del daño
                    if(!jugadores[rec].getEsquivar()){
                        if (monstruo instanceof WyverPajaro) {
                            if (rage) {
                                vidaActual = vidaActual - ((WyverPajaro) monstruo).getDañoElem() * 2;
                                System.out.println("Hace "+(((WyverPajaro) monstruo).getDañoElem() * 2)+" de Daño Elemental");
                            } else {
                                vidaActual = vidaActual - ((WyverPajaro) monstruo).getDañoElem();
                                System.out.println("Hace "+(((WyverPajaro) monstruo).getDañoElem())+" de Daño Elemental");
                            }
                        }
                        if (monstruo instanceof WyverVolador) {
                            if (rage) {
                                vidaActual = vidaActual - ((WyverVolador) monstruo).getDañoElem() * 2;
                                System.out.println("Hace "+(((WyverVolador) monstruo).getDañoElem() * 2)+" de Daño Elemental");
        
                            } else {
                                vidaActual = vidaActual - ((WyverVolador) monstruo).getDañoElem();
                                System.out.println("Hace "+(((WyverVolador) monstruo).getDañoElem())+" de Daño Elemental");
        
                            }
                        }
                        if (rage) {
                            vidaActual = vidaActual - (monstruo.getDañoRAW()*2);
                            System.out.println("Hace "+(monstruo.getDañoRAW()*2)+" de Daño RAW");
        
                        } else {
                            vidaActual = vidaActual - monstruo.getDañoRAW();
                            System.out.println("Hace "+monstruo.getDañoRAW()+" de Daño RAW");
        
                        }

                        // Le quitamos la vida al jugador que le haya tocado
                        jugadores[rec].setVida(vidaActual);

                    } else {
                            System.out.println("El cazador " + jugadores[rec].getName() + " ha esquivado el ataque");
                    }

                    // Enseñamos la vida de todos los jugadores
                    System.out.println("");
                    for (Jugador jugador:jugadores){
                        System.out.println("El cazador " + jugador.getName() + " tiene " + jugador.getVida() + " puntos de vida");
                    }
                    for (Jugador jugador:jugadores){
                        if (jugador.getEsquivar()){
                            jugador.setEsquivar();
                        }
                    }
                    break;

                case 2:
                    if (rage){
                        System.out.println("Parece que "+monstruo.getNombre()+" se ha calmado.");
                    } else {
                        System.out.println("¡"+monstruo.getNombre()+" ha entrado en RAGE cuidado!");
                    }
                    
                    rage = !rage;
                    break;
                case 3:
                    System.out.println("Parece que "+monstruo.getNombre()+" espera una oportunidad para atacar.");
                    break;
            }

            // Comprobar si ha muerto alguien
            for (Jugador jugador:jugadores){
                if (jugador.getVida() <= 0){
                    System.out.println("El cazador "+jugador.getName()+" ha muerto.");
                    System.out.println("GAME OVER");
                    System.exit(0);
                }
            }
            
            // Turno de los jugadores
            System.out.println("");

            for (Jugador jugador:jugadores){
                System.out.println("Es el turno de "+jugador.getName());
                System.out.println("Elige una acción:");
                System.out.println("1. Atacar.");
                System.out.println("2. Esquivar.");
                System.out.println("3. Curarte. (Quedan "+jugador.getPociones()+" pociones)");

                boolean entradaValida = false;
                int accion = 0;

                while (!entradaValida) {
                    try {
                        accion = sc.nextInt();
                        if (accion < 1 || accion > 3) {
                            System.out.println("No es un valor valido.\n");
                            System.out.println("Elige una acción:");
                            System.out.println("1. Atacar.");
                            System.out.println("2. Esquivar.");
                            System.out.println("3. Curarte.");
                            sc.nextLine();
                        } else {
                            entradaValida = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("No es un valor valido.\n");
                        System.out.println("Elige una acción:");
                        System.out.println("1. Atacar.");
                        System.out.println("2. Esquivar.");
                        System.out.println("3. Curarte.");
                        sc.nextLine();
                    }
                }

                switch (accion) {
                    case 1:
                        int daño = (10+jugador.getNivel());

                        if (jugador.getArma().equals(monstruo.getDebilidad())){
                            daño = daño*2;
                            System.out.println("¡Tu arma parece ser muy efectiva!");
                        }

                        System.out.println(jugador.getName()+" ha hecho "+daño+" puntos de daño.");
                        
                        monstruo.setVida(monstruo.getVida()-daño);
                        if (monstruo.getVida() < 0){
                            monstruo.setVida(0);
                        }
                        System.out.println("A "+monstruo.getNombre()+" le quedan "+monstruo.getVida()+" puntos de vida.");
                        break;

                    case 2:
                        jugador.setEsquivar();
                        System.out.println(jugador.getName() + " se está centrando en no recibir daño.");
                        break;

                    default:
                        if (jugador.getPociones() > 0){
                            jugador.setVida(jugador.getVida()+80);
                            if (jugador.getVida() > 150) {
                                jugador.setVida(150);
                            }

                            jugador.setPociones(jugador.getPociones()-1);
                            System.out.println("Ahora tienes "+jugador.getVida()+" puntos de vida.");
                            System.out.println("A "+ jugador.getName()+ " le quedan "+ jugador.getPociones()+" pociones.");
                        } else {
                            System.out.println("¡No tienes pociones!");
                        }
                        break;
                }
                System.out.println("");
            }

        }
        
        for (Jugador jugador:jugadores){
            double random = Math.random();
            if (random>=0.7){
                jugador.setPociones(jugador.getPociones()+1);
                System.out.println("El jugador "+jugador.getName()+" ha encontrado 1 poción.");
                System.out.println("Ahora tiene "+jugador.getPociones()+" pociones.");
            } else if (random<=0.05){
                jugador.setPociones(jugador.getPociones()+2);
                System.out.println("¡Que suerte!");
                System.out.println("¡El jugador "+jugador.getName()+" ha encontrado 2 pociones!");
                System.out.println("Ahora tiene "+jugador.getPociones()+" pociones.");
            }

            jugador.setNivel(jugador.getNivel()+1);
            System.out.println("El jugador "+jugador.getName()+" ha subido al nivel "+jugador.getNivel());
        }

        // Termina el combate y vamos al menú de guardado o continuar
        Base.MenuFinal(jugadores, sc);
    }

}
