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
        public State estado;

        public aWeapon(String nombre, double alcance, double danho, double radioExplosion,
                       double velocidadDeAtaque,int nivel,String tipo,State estado) {
            this.nombre = nombre;
            this.alcance = alcance;
            this.danho = danho;
            this.radioExplosion = radioExplosion;
            this.nivel = nivel;
            this.velocidadDeAtaque = velocidadDeAtaque;
            this.activo = true;
            this.tipo = tipo;
            this.estado = estado;
            //this.imagen = this.getImagen();
        }
        /*
        public Image getImagen(){
            String url = controllerSingleton.getController().getFlyweightJson().datos(this.nombre,this.nivel,this.estado);
            return controllerSingleton.getController().getFlyweightJson().getImage(url);
        }*/

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