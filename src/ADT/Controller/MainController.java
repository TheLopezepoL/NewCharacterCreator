package ADT.Controller;

import ADT.Weapon.WeaponFactory;

public class MainController {
    public static void main(String[] args) {
        System.out.println("Hello World");

        //CONTROLADOR PRINCIPAL
        controllerSingleton controlador = controllerSingleton.getController();

        //ABRO MENU PRINCIPAL
        Menu menu = new Menu(null);

        //CREAR ARMA
        //1- FACTORY WEAPONS
        WeaponFactory factoryWeapons = new WeaponFactory();


    }
}
