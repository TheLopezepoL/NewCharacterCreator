package ADT.Characters;

import ADT.Enums.EnumCharacters;

public class CharacterFactory  {

    //FACTORY METHOD
    public aPersonaje createCharacter (EnumCharacters tipo,String nombre, double vida, int nivel, int campos, int nivelAparicion, int costo){
        switch (tipo){
            case TERRESTRE:
                return new PersonajeTerrestre(nombre, vida, nivel, campos, nivelAparicion, costo);
            default:
                throw new IllegalArgumentException("Tipo de personaje no existe");
        }
    }
}
