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

    //FACTORY----------------------------------
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
        //FACTORY
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

    //get Weapons Factory
    public  WeaponFactory getFactoryWeapons(){
        return factoryWeapons;
    }
    public  ArrayList <aWeapon>  getBaseWeapons(){
        return base_weapons;
    }
    //print Armas
    public void printArmas(){
        for (int i=0;i<base_weapons.size();i++){
            aWeapon arma = base_weapons.get(i);
            System.out.println(" Nombre: "+arma.getNombre()
                    + " Alcance: "+ arma.getAlcance()
                    + " Dano: "+ arma.getDanho()
                    + " Radio: "+arma.getRadioExplosion()
                    + " Velocidad: "+arma.getVelocidadDeAtaque()
                    + " Nivel: "+arma.getNivel()
                    + " Tipo: "+arma.getTipo()) ;
        }
    }


    //CREAR ARMAS---------------------------------------
    public aWeapon createBaseWeapon(String nombre, double alcance, double danho,double radioExplosion,
                                    double velocidadAtaque, int nivel, EnumWeapons tipoArma)
    {
        return factoryWeapons.FabricarWeapon(nombre,alcance,danho,velocidadAtaque,radioExplosion,
                                         nivel,tipoArma);
    }
}
