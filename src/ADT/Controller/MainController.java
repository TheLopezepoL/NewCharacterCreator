package ADT.Controller;

import ADT.Characters.Character;
import ADT.Characters.InfoCharacter;
import ADT.Enums.EnumCharacters;
import ADT.State;
import ADT.Weapon.WeaponFactory;

import javax.swing.*;
import java.util.ArrayList;

public class MainController {
    public static controllerSingleton controlador;
    public static volatile Boolean turnoMain;
    public static volatile Boolean jugando;
    public static void main(String[] args) {
        //CONTROLADOR PRINCIPAL
        controlador = controllerSingleton.getController();

        //TURNOS
        turnoMain = true;
        controlador.setTurno(true);

        //ADD 2 PJ
        Character nuevoCharacter = new Character.BuilderCharacter().setName("caballero")
                .setVida(100)
                .setNivel(1)
                .setCosto(1)
                .setCampos(1)
                .setNivelAparicion(1)
                .setEstado(State.DEFAULT)
                .setImagen()
                .setTipo(EnumCharacters.TERRESTRE)
                .setPos(2,2)
                .build();

        Character enemigoCharacter = new Character.BuilderCharacter().setName("ghost")
                .setVida(100)
                .setNivel(1)
                .setCosto(1)
                .setCampos(1)
                .setNivelAparicion(1)
                .setEstado(State.DEFAULT)
                .setImagen()
                .setPos(3,3)
                .build();
        Character enemigoCharacter2 = new Character.BuilderCharacter().setName("ghost")
                .setVida(100)
                .setNivel(1)
                .setCosto(1)
                .setCampos(1)
                .setNivelAparicion(1)
                .setEstado(State.DEFAULT)
                .setImagen()
                .setPos(1,3)
                .build();

/*
        controlador.setMainCharacter(nuevoCharacter);
        controlador.addEnemy(enemigoCharacter);
        controlador.addEnemy(enemigoCharacter2);
        controlador.addToTablero(nuevoCharacter);
        controlador.addToTablero(enemigoCharacter);
        controlador.addToTablero(enemigoCharacter2);*/


        //ABRO MENU PRINCIPAL
        Menu menu = new Menu(null);
        System.out.println("PASE");
        //TableroJuego tableroForm = new TableroJuego();
       //jugar();
        //CREAR ARMA
        //1- FACTORY WEAPONS

    }

    public static void jugar(){
        System.out.println("Jugando");
        //Tablero tableroForm = new Tablero();

        jugando = true;
        ArrayList<Character> enemigos = controlador.getEnemigos();
        while(jugando){
            System.out.println("Jugando");
            if (controlador.getTurno()){
                turnoMain = true;
                JOptionPane.showMessageDialog(null, "Su turno");
                while(turnoMain){

                }
                controlador.setTurno(!controlador.getTurno());
            }
            else{
                for (int i=0; i<enemigos.size(); i++){
                    JOptionPane.showMessageDialog(null, "Turno Jugador "+i);
                }
                controlador.setTurno(!controlador.getTurno());
            }

        }
    }
}
