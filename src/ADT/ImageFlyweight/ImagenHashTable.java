package ADT.ImageFlyweight;


import ADT.State;

import java.awt.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class ImagenHashTable {
    protected static int FINAL_ID = 0;
    private int id;
    private String nombre;

    public Hashtable<Integer, Hashtable<State, Image>> imagenes;  // Lvl - Estado - Imagen

    public ImagenHashTable(){
        this.id = ++FINAL_ID;
        this.imagenes = new Hashtable<>();
    }
    public ImagenHashTable(String pNombre){
        this.id = ++FINAL_ID;
        this.imagenes = new Hashtable<>();
        this.nombre = pNombre;
    }

    public void agregarNivel(int lvl) {
        imagenes.putIfAbsent(lvl, new Hashtable<>());
    }

    public void agregarEstado(State state) {
        Enumeration<Integer> keys = imagenes.keys();
        while (keys.hasMoreElements()) {
            int key = keys.nextElement();
            imagenes.get(key).putIfAbsent(state, null);
        }
    }

    //se cae si no existe nivel o estado
    public void agregarImagen(int lvl, State state, Image image) {
        imagenes.get(lvl).put(state, image);
    }

    public String getNombre(){
        return this.nombre;
    }


}