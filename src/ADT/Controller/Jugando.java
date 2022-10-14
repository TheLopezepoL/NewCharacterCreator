package ADT.Controller;

import ADT.Characters.Character;

import javax.swing.*;
import java.util.ArrayList;

public class Jugando extends Thread {
    public Jugando(){

    }
    @Override
    public void run(){
        System.out.println("Jugando");
        //Tablero tableroForm = new Tablero();

        MainController.jugando = true;
        ArrayList<Character> enemigos = MainController.controlador.getEnemigos();
        while(MainController.jugando){
            System.out.println("Jugando");
            if (MainController.controlador.getTurno()){
                MainController.turnoMain = true;
                JOptionPane.showMessageDialog(null, "Su turno");
                while(MainController.turnoMain){

                }
                MainController.controlador.setTurno(!MainController.controlador.getTurno());
            }
            else{
                for (int i=0; i<enemigos.size(); i++){
                    JOptionPane.showMessageDialog(null, "Turno Jugador "+i);
                }
                MainController.controlador.setTurno(!MainController.controlador.getTurno());
            }

        }

    }
}
