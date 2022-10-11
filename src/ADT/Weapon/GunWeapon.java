package ADT.Weapon;

import java.awt.*;

public class GunWeapon extends aWeapon{

    private int cargador; // Balas dentro del arma
    private  int municion; // Balas totoales


    public GunWeapon(String nombre, double alcance, double danho, double radioExplosion, double velocidadDeAtaque, int nivel, Image imagen) {
        super(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
    }

    public GunWeapon(GunWeapon armaDeFuego){
        super(armaDeFuego.nombre, armaDeFuego.alcance, armaDeFuego.danho, armaDeFuego.radioExplosion, armaDeFuego.velocidadDeAtaque , armaDeFuego.nivel, armaDeFuego.imagen);
    }

    public GunWeapon() {
    }


    @Override
    public aWeapon clone() {
        return new GunWeapon(this);
    }

    @Override
    public double utilizar() {
        return danho;
    }


}
