package ADT.Characters;

import ADT.Enums.EnumCharacters;

public class CharacterFactory  {

    //FACTORY METHOD
    public void createCharacter (EnumCharacters tipo){
        switch (tipo){
            case TERRESTRE:
                return; //new pj terrestre
            case AEREO:
                return; //new pj aerreo
            default:
                throw new IllegalArgumentException("Tipo de personaje no existe");
        }
    }
}
