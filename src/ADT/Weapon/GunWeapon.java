package ADT.Weapon;

import java.awt.*;

public class GunWeapon extends aWeapon{



    public GunWeapon(String nombre, double alcance, double danho, double radioExplosion, double velocidadDeAtaque, int nivel) {
        super(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel, "FUEGO");
    }

    public GunWeapon(GunWeapon armaDeFuego){
        super(armaDeFuego.nombre, armaDeFuego.alcance, armaDeFuego.danho, armaDeFuego.radioExplosion, armaDeFuego.velocidadDeAtaque , armaDeFuego.nivel, "FUEGO");
    }

    public GunWeapon() {
    }

    @Override
    public aWeapon clone(){
        return new GunWeapon(this);
    };

    @Override
    public aWeapon deepClone(){
        return clone();
    };

    @Override
    public double utilizar() {
        return danho;
    }


}
