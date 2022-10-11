package ADT.Weapon;

import java.awt.*;

public class MeleeWeapon extends aWeapon{

    public MeleeWeapon(String nombre, double danho, double radioExplosion, double velocidadDeAtaque, int nivel, Image imagen) {
        super(nombre, 1, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
    }

    public MeleeWeapon(MeleeWeapon armaBlanca){
        super(armaBlanca.nombre, armaBlanca.alcance, armaBlanca.danho, armaBlanca.radioExplosion, armaBlanca.velocidadDeAtaque, armaBlanca.nivel, armaBlanca.imagen);
    }
    public MeleeWeapon() {
    }

    @Override
    public aWeapon clone() {
        return new MeleeWeapon(this);
    }

    @Override
    public double utilizar() {
        return danho;
    }

}
