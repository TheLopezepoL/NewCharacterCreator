package ADT.Characters;

public class tipoTerrestre extends aTipo{

    public tipoTerrestre (){

    }
    @Override
    public  int atacar(Character infoCharacter){
        System.out.println("Ataca a "+infoCharacter.nombre);
        return 0;
    }

    @Override
    public Boolean moverse(Character infoCharacter, int x, int y){
        infoCharacter.posX =  x;
        infoCharacter.posY =  y;
        System.out.println("Moverse");
        System.out.println(x+" "+y);
        return true;
    }
}
