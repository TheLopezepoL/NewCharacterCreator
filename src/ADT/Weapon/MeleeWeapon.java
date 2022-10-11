package ADT.Weapon;

import java.awt.*;

public class MeleeWeapon extends aWeapon{

    public MeleeWeapon(String nombre, double danho, double radioExplosion, double velocidadDeAtaque, int nivel) {
        super(nombre, 1, danho, radioExplosion, velocidadDeAtaque, nivel);
    }

    public MeleeWeapon(MeleeWeapon armaBlanca){
        super(armaBlanca.nombre, armaBlanca.alcance, armaBlanca.danho, armaBlanca.radioExplosion, armaBlanca.velocidadDeAtaque, armaBlanca.nivel);
    }
    public MeleeWeapon() {
    }

    @Override
    public aWeapon clone() {
        return new MeleeWeapon(this);
    }
    @Override
    public aWeapon deepClone() {
        return new MeleeWeapon(this);
    }

    @Override
    public double utilizar() {
        return danho;
    }

}
