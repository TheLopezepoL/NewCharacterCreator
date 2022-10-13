package ADT.Weapon;

import ADT.Characters.Character;
import ADT.Controller.controllerSingleton;
import ADT.IPrototype;
import ADT.State;

import java.awt.Image;

public abstract class aWeapon implements IPrototype<aWeapon> {
        public String nombre;
        public double alcance;
        public double danho;
        public double radioExplosion;
        public double velocidadDeAtaque;
        public int nivel;
        public String tipo;
        public boolean activo;
        public Image imagen;

        public aWeapon(String nombre, double alcance, double danho, double radioExplosion,
                       double velocidadDeAtaque,int nivel,String tipo) {
            this.nombre = nombre;
            this.alcance = alcance;
            this.danho = danho;
            this.radioExplosion = radioExplosion;
            this.nivel = nivel;
            this.velocidadDeAtaque = velocidadDeAtaque;
            this.activo = true;
            this.tipo = tipo;
            this.imagen = this.getImagen();
        }

        //Para cuando hagamos clone, pasarle la imagen directamente
        public aWeapon(String nombre, double alcance, double danho, double radioExplosion,
                       double velocidadDeAtaque,int nivel,String tipo,Image imagen) {
        this.nombre = nombre;
        this.alcance = alcance;
        this.danho = danho;
        this.radioExplosion = radioExplosion;
        this.nivel = nivel;
        this.velocidadDeAtaque = velocidadDeAtaque;
        this.activo = true;
        this.tipo = tipo;
        this.imagen = imagen;
        }

        public Image getImagen(){
            String url = controllerSingleton.getController().datosArma(this.nombre,this.nivel);
            return controllerSingleton.getController().getImage(url);

        }

        public void updateImagen(){
            String url = controllerSingleton.getController().datosArma(this.nombre,this.nivel);
            this.imagen = controllerSingleton.getController().getImage(url);
        }

        public aWeapon() {
        }

    public String getNombre() {
        return nombre;
    }

    @Override
        public abstract aWeapon clone();
        @Override
        public abstract aWeapon deepClone();
        public abstract double utilizar();

    }