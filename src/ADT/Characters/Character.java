package ADT.Characters;

import ADT.IBuilder;
import ADT.IPrototype;
import ADT.Weapon.aWeapon;

import java.awt.*;
import java.util.ArrayList;

public class Character implements IPrototype<Character> {
    protected String nombre;
    protected double vida;
    protected int nivel;
    protected int campos;
    protected int nivelAparicion;
    protected int costo;

    protected ArrayList<aWeapon> armas;
    protected Image imagen;
    protected int posX;
    protected int posY;

    protected aTipo tipo;

    public Character() {

    }
    public Character (String nombre, double vida, int nivel, int campos, int nivelAparicion, int costo, ArrayList<aWeapon> weapons) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
        this.costo = costo;
        this.armas = weapons;
        this.posX = 0;
        this.posY = 0;
        //this.imagen = Controlador.getImagen(this.nombre,this.nivel,estado);

    }

    @Override
    public Character clone(){
        return new Character(this.nombre,this.vida, this.nivel,this.campos,this.nivelAparicion,this.costo,this.armas);
    }

    @Override
    public Character deepClone(){
        ArrayList<aWeapon> armasClone = new ArrayList<aWeapon>();
        for (int i=0; i<=this.armas.size(); i++){
            armasClone.add(this.armas.get(i).clone());
        }
        return new Character(this.nombre,this.vida, this.nivel,this.campos,this.nivelAparicion,this.costo,armasClone);
    }

    public static class BuilderCharacter implements IBuilder<Character> {
        private String nombre;
        private double vida;
        private int nivel;
        private int campos;
        private int nivelAparicion;
        private int costo;

        protected ArrayList<aWeapon> armas;
        private Image imagen;
        private int posX;
        private int posY;

        private aTipo tipo;

        public BuilderCharacter (){}

        public BuilderCharacter setName(String name){
            this.nombre = name;
            return this;
        }

        public BuilderCharacter addWeapon (aWeapon arma){
            //clone arma
            this.armas.add(arma);
            return this;
        }



        @Override
        public Character build(){
            return new Character(nombre, vida, nivel, campos, nivelAparicion, costo, armas);
        }


    }
}
