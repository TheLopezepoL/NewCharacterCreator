package ADT.Weapon;

import ADT.Characters.Character;
import ADT.IPrototype;

import java.awt.Image;

public abstract class aWeapon implements IPrototype<aWeapon> {
        protected String nombre;
        protected double alcance;
        protected double danho;
        protected double radioExplosion;
        protected double velocidadDeAtaque;
        protected int nivel;
        protected boolean activo;
        protected Image imagen;

        public aWeapon(String nombre, double alcance, double danho, double radioExplosion, double velocidadDeAtaque,int nivel) {
            this.nombre = nombre;
            this.alcance = alcance;
            this.danho = danho;
            this.radioExplosion = radioExplosion;
            this.nivel = nivel;
            this.velocidadDeAtaque = velocidadDeAtaque;
            //this.imagen = imagen;
            this.activo = true;
        }

        public aWeapon() {
        }

        @Override
        public abstract aWeapon clone();
        @Override
        public abstract aWeapon deepClone();
        public abstract double utilizar();

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getAlcance() {
            return alcance;
        }

        public void setAlcance(double alcance) {
            this.alcance = alcance;
        }

        public void setDanho(double danho) {
            this.danho = danho;
        }

        public double getRadioExplosion() {
            return radioExplosion;
        }

        public void setRadioExplosion(double radioExplosion) {
            this.radioExplosion = radioExplosion;
        }

        public double getVelocidadDeAtaque() {
            return velocidadDeAtaque;
        }

        public void setVelocidadDeAtaque(double velocidadDeAtaque) {
            this.velocidadDeAtaque = velocidadDeAtaque;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public void subirNivel() {
            this.nivel++;
        }

        public boolean isActivo() {
            return activo;
        }

        public void setActivo(boolean activo) {
            this.activo = activo;
        }
    }