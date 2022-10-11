package ADT.Weapon;

import java.awt.*;

import ADT.Enums.EnumWeapons;

public class WeaponFactory {

    public  aWeapon FabricarWeapon(String nombre, double alcance, double danho
            , double velocidadAtaque, double radioExplosion, double velocidadDeAtaque, int nivel, EnumWeapons tipoArma){

        switch (tipoArma){
            case FUEGO:
                return new GunWeapon(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel);
            case BLANCA:
                return new MeleeWeapon(nombre,danho, radioExplosion, velocidadDeAtaque, nivel);
            case MAGIA:
                return new MagicWeapon(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel);
            default:
                throw new IllegalArgumentException("Tipo de arma no existente");
        }

    }
}
