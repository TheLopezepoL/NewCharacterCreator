package ADT.Characters;

import ADT.Mapa.Mapa;

import java.util.ArrayList;

public class PersonajeTerrestre extends aPersonaje{

    public PersonajeTerrestre(String nombre, double vida, int nivel, int campos, int nivelAparicion, int costo) {
        super(nombre, vida, nivel, campos, nivelAparicion, costo);
    }

    @Override
    public aPersonaje clone() {
        PersonajeTerrestre copia = new PersonajeTerrestre(this.nombre,this.vida,this.nivel,this.campos,
                                                            this.nivelAparicion,this.costo);
        // falta lo de armas!
        return copia;
    }

    @Override
    public aPersonaje deepClone() {
        /*
        setearlo con lo de armas y ya
         */
        return null;
    }


    @Override
    public int atacar() {
        return 0;
    }

    @Override
    public boolean canMove(ArrayList<Integer> newPosition, Mapa mapa) {
        return false;
    }
}
