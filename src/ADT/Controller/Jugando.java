package ADT.Controller;

import ADT.Characters.Character;

import javax.swing.*;
import java.util.ArrayList;

public class Jugando extends Thread {
    public Jugando(){

    }
    @Override
    public void run(){
        MainController.jugando = true;
        ArrayList<Character> enemigos = MainController.controlador.getEnemigos();
        System.out.println("---------------INICIA EL JUEGO------------------------");
        while(MainController.jugando){
            //TRUNO DEL MAIN CHARACTEr
            if (MainController.controlador.getTurno()){
                MainController.turnoMain = true;
                System.out.println("\n------------------------------------------------");
                System.out.println("TURNO MAIN CARCATER!");
                JOptionPane.showMessageDialog(null, "Su turno");
                while(MainController.turnoMain){
                    //ESPERA A ATACAR O MOVERSE
                }
                if (gane()){
                    JOptionPane.showMessageDialog(null, "GANAAA :)");
                    TableroJuego.window.dispose();
                    return;
                }

                MainController.controlador.setTurno(!MainController.controlador.getTurno());
            }
            else{
                for (int i=0; i<enemigos.size(); i++){
                    JOptionPane.showMessageDialog(null, "Turno Enemigo "+i);
                    System.out.println("\n--------------------------------------------------------");
                    System.out.println("Turno Enemigo "+i);
                    Character enemigo = enemigos.get(i);
                    if (enemigo.getVida() <= 0){
                        System.out.println("**ENEMIGO ESTA MUERTO**");
                    }
                    else{
                        //ATACA O SE MUEVE
                        int movimiento = (int)(Math.random()*10+1);
                        if (movimiento <= 5 && moverseAux(enemigo)){
                            System.out.println("**ENEMIGO SE MUEVE**");
                        }
                        else{
                            System.out.println("**ENEMIGO ATACA**");
                            enemigo.getTipo().atacar(enemigo,MainController.controlador.getMainCharacter());
                        }
                        TableroJuego.cargarTablero();
                        if (pierde()){
                            JOptionPane.showMessageDialog(null, "PERDIÓ :(");
                            TableroJuego.window.dispose();
                            return;
                        }
                    }

                }
                MainController.controlador.setTurno(!MainController.controlador.getTurno());
            }

        }

    }

    public Boolean moverseAux (Character personaje){
        Character[][] tablero = MainController.controlador.getTablero();
        //a la izquierda?
        if ((personaje.getPosY()+1) < tablero.length
                && (personaje.getPosY()+1) >= 0 &&  tablero[personaje.getPosX()][personaje.getPosY()+1]==null)
        {
            System.out.println("IZQUIERDA");
            personaje.setPos((personaje.getPosX()), personaje.getPosY()+1);
            MainController.controlador.refreshMatriz(personaje,personaje.getPosX(),personaje.getPosY()-1);
            return true;
        }

        //a la derecha?
        if ((personaje.getPosY()-1) < tablero.length
                && (personaje.getPosY()-1) >= 0 &&  tablero[personaje.getPosX()][personaje.getPosY()-1]==null)
        {
            System.out.println("derecha");
            personaje.setPos((personaje.getPosX()), personaje.getPosY()-1);
            MainController.controlador.refreshMatriz(personaje,personaje.getPosX(),personaje.getPosY()+1);
            return true;
        }

        //arriba?
        if ((personaje.getPosX()-1) < tablero[0].length
                && (personaje.getPosX()-1) >= 0   &&  tablero[personaje.getPosX()-1][personaje.getPosY()]==null)
        {
            System.out.println("Arriba");
            personaje.setPos((personaje.getPosX()-1), personaje.getPosY());
            MainController.controlador.refreshMatriz(personaje,personaje.getPosX()+1,personaje.getPosY());
            return true;
        }

        //abajo?
        if ((personaje.getPosX()+1) < tablero[0].length
                && (personaje.getPosX()+1) >= 0 &&  tablero[personaje.getPosX()+1][personaje.getPosY()]==null)
        {
            System.out.println("Abajo");
            personaje.setPos((personaje.getPosX()+1), personaje.getPosY());
            MainController.controlador.refreshMatriz(personaje,personaje.getPosX()-1,personaje.getPosY());
            return true;
        }

        return false;
    }

    public Boolean gane(){
        for (Character enemigo : MainController.controlador.getEnemigos()){
            if (enemigo.getVida() > 0){
                return false;
            }
        }
        return true;
    }

    public Boolean pierde(){
        if (MainController.controlador.getMainCharacter().getVida() <= 0){
            return true;
        }
        return false;
    }
}
