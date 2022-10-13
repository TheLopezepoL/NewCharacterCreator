package ADT.Weapon;

import java.awt.*;

public class MagicWeapon extends aWeapon {


    public MagicWeapon(String nombre, double alcance, double danho, double radioExplosion, double velocidadDeAtaque, int nivel) {
        super(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel,"MAGIA");
    }

    public MagicWeapon(MagicWeapon magia){
        super(magia.nombre, magia.alcance, magia.danho, magia.radioExplosion,
                magia.velocidadDeAtaque, magia.nivel,"MAGIA", magia.imagen);
    }

    public MagicWeapon() {
    }

    @Override
    public double utilizar() {
        return -danho;
    }


    public aWeapon clone(){
        return new MagicWeapon(this.nombre, this.alcance, this.danho, this.radioExplosion, this.velocidadDeAtaque, this.nivel);
    };

    @Override
    public aWeapon deepClone(){
        return clone();
    };
}
