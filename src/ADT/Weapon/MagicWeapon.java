package ADT.Weapon;

import java.awt.*;

public class MagicWeapon extends aWeapon {


    public MagicWeapon(String nombre, double alcance, double danho, double radioExplosion, double velocidadDeAtaque, int nivel, Image imagen) {
        super(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
    }

    public MagicWeapon(MagicWeapon magia){
        super(magia.nombre, magia.alcance, magia.danho, magia.radioExplosion, magia.velocidadDeAtaque, magia.nivel, magia.imagen);
    }

    public MagicWeapon() {
    }

    @Override
    public aWeapon clone() {
        return new MagicWeapon(this);
    }

    @Override
    public double utilizar() {
        return -danho;
    }


}
