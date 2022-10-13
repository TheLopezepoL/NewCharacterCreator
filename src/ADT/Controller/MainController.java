package ADT.Controller;

import ADT.Characters.Character;
import ADT.Characters.InfoCharacter;
import ADT.State;
import ADT.Weapon.WeaponFactory;

public class MainController {
    public static controllerSingleton controlador;
    public static void main(String[] args) {

        //CONTROLADOR PRINCIPAL
        controlador = controllerSingleton.getController();

        //ADD 2 PJ
        Character nuevoCharacter = new Character.BuilderCharacter().setName("Sniper")
                .setVida(100)
                .setNivel(1)
                .setCosto(1)
                .setCampos(1)
                .setNivelAparicion(1)
                .setEstado(State.DEFAULT)
                .setImagen()
                .build();

        controlador.getTablero()[0][0]=nuevoCharacter;
        controlador.getTablero()[2][3]=nuevoCharacter;

        //ABRO MENU PRINCIPAL
        //Menu menu = new Menu(null);
        Tablero tableroForm = new Tablero(null);

        //CREAR ARMA
        //1- FACTORY WEAPONS
        WeaponFactory factoryWeapons = new WeaponFactory();


    }
}
