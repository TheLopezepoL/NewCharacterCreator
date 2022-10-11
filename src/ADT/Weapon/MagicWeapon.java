package ADT.Weapon;

import java.awt.*;

public class MagicWeapon extends aWeapon {


    public MagicWeapon(String nombre, double alcance, double danho, double radioExplosion, double velocidadDeAtaque, int nivel) {
        super(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel);
    }

    public MagicWeapon(MagicWeapon magia){
        super(magia.nombre, magia.alcance, magia.danho, magia.radioExplosion, magia.velocidadDeAtaque, magia.nivel);
    }

    public MagicWeapon() {
    }

    @Override
    public aWeapon clone() {
        return new MagicWeapon(this);
    }
    @Override
    public aWeapon deepClone() {
        return new MagicWeapon(this);
    }

    @Override
    public double utilizar() {
        return -danho;
    }


}
