package ADT.Characters;

import ADT.Enums.EnumCharacters;

public class TypesFactory {
    //FACTORY METHOD
    public aTipo createCharacter (EnumCharacters tipo, String nombre, double vida, int nivel, int campos, int nivelAparicion, int costo){
        switch (tipo){
            case TERRESTRE:
               return new tipoTerrestre();
            default:
                throw new IllegalArgumentException("Tipo de personaje no existe");
        }
    }
}
