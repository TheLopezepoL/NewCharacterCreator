package ADT.Characters;

public class tipoAereo extends aTipo{

    public tipoAereo (){

    }
    @Override
    public  int atacar(Character infoCharacter, Character enemigo){
        return 0;
    }

    @Override
    public  Boolean moverse(Character infoCharacter, int x, int y){
        return true;
    }
}
