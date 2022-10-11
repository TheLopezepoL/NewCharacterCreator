package ADT.Weapon;

import java.awt.*;

import ADT.Enums.EnumWeapons;

public class WeaponFactory {

    public static aWeapon FabricarWeapon(String nombre, double alcance, double danho
            , double velocidadAtaque, double radioExplosion, double velocidadDeAtaque, int nivel, Image imagen, EnumWeapons tipoArma){

        switch (tipoArma){
            case FUEGO:
                return new GunWeapon(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
            case BLANCA:
                return new MeleeWeapon(nombre, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
            case MAGIA:
                return new MagicWeapon(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
            default:
                throw new IllegalArgumentException("Tipo de arma no existente");
        }

    }
}
