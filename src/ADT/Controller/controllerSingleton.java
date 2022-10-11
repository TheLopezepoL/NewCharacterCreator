package ADT.Controller;

import java.awt.*;
import java.util.ArrayList;

import ADT.Characters.Character;
import ADT.Characters.TypesFactory;
import ADT.Enums.EnumWeapons;
import ADT.Weapon.WeaponFactory;
import ADT.Weapon.aWeapon;

public class controllerSingleton {
    //static reference to the single object
    private static controllerSingleton myController;

    //instancias Factory
    private WeaponFactory factoryWeapons;
    private TypesFactory factoryTypes;
    private ArrayList <Character> generated_characters;
    private ArrayList <Character> base_characters;
    private ArrayList <aWeapon> base_weapons;

    //constructor privado
    private controllerSingleton (){
        generated_characters = new ArrayList <Character> ();
        base_characters = new ArrayList <Character> ();
        base_weapons = new ArrayList <aWeapon> ();
        factoryWeapons = new WeaponFactory();
        factoryTypes = new TypesFactory();
    }

    //getInstance
    public static controllerSingleton getController(){
        if (myController == null){
            myController = new controllerSingleton ();
        }
        return myController;
    }



    //CREAR ARMAS---------------------------------------
    public boolean createBaseWeapon(String nombre, double alcance, double danho,
                                    double velocidadAtaque, double radioExplosion,
                                    double velocidadDeAtaque, int nivel, EnumWeapons tipoArma)
    {
        factoryWeapons.FabricarWeapon(nombre,alcance,danho,velocidadAtaque,radioExplosion,
                                        velocidadDeAtaque, nivel,tipoArma);
        return true;
    }
}
