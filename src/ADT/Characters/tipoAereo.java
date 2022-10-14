package ADT.Characters;

import ADT.State;
import ADT.Weapon.aWeapon;

public class tipoAereo extends aTipo{

    public tipoAereo (){

    }
    @Override
    public  int atacar(Character infoCharacter, Character enemigo){
        double vidaAnterior = enemigo.vida;
        System.out.println("Ataca a "+enemigo.nombre +" Vida Anterior: " +vidaAnterior);
        System.out.println("Es tipo aereo ");

        int danho = 0;
        double distancia =  Math.sqrt((infoCharacter.posY - enemigo.posY) * (infoCharacter.posY - enemigo.posY) + (enemigo.posX - infoCharacter.posX) * (enemigo.posX - infoCharacter.posX));
        int aux = (int)distancia;
        System.out.println(aux);

        for (aWeapon arma : infoCharacter.getArmas()){
            if (arma.activo){
                if (arma.alcance >= aux){
                    danho+=arma.danho*2;
                    System.out.println("\tArma: "+arma.nombre +"\tDaño causado: "+ arma.danho*2);
                }
                else{
                    System.out.println("\tArma: "+arma.nombre +"\tFuera de Alcance");
                }

            }

        }
        enemigo.setVida(danho);
        if (enemigo.vida <= 0){
            enemigo.setEstado(State.DEAD);
            enemigo.updateImagen();
        }
        System.out.println("Daño total: "+danho+" Nueva vida: "+enemigo.vida);
        return 0;
    }

    @Override
    public  Boolean moverse(Character infoCharacter, int x, int y){
        infoCharacter.posX =  x;
        infoCharacter.posY =  y;
        System.out.println("Moverse");
        System.out.println(x+" "+y);
        return true;
    }
}
