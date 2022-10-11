package ADT.Controller;

import java.util.ArrayList;

import ADT.Weapon.aWeapon;

public class controllerSingleton {
    //static reference to the single object
    private static controllerSingleton myController;

    private ArrayList <aPersonaje> generated_characters;
    private ArrayList <aPersonaje> base_characters;
    private ArrayList <aWeapon> base_weapons;

    //constructor privado
    private controllerSingleton (){
        generated_characters = new ArrayList <aPersonaje> ();
        base_characters = new ArrayList <aPersonaje> ();
        base_weapons = new ArrayList <aWeapon> ();
    }

    //getInstance
    public static controllerSingleton getController(){
        if (myController == null){
            myController = new controllerSingleton ();
        }
        return myController;
    }
}
