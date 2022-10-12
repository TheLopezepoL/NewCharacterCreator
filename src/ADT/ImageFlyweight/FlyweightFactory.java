package ADT.ImageFlyweight;

import java.util.ArrayList;

public class FlyweightFactory {
    private static ArrayList<ImagenHashTable> cache;

    public FlyweightFactory(){
        cache = new ArrayList<>();
    }

    public static ImagenHashTable getFlyweight(ImagenHashTable imagenHashTable){
        if (!cache.contains(imagenHashTable))   // for por id
            cache.add(imagenHashTable);
        return cache.get(cache.indexOf(imagenHashTable));
    }

    public static ImagenHashTable getFlyweight(String pNombre){
        for(ImagenHashTable ht : cache){
            if(ht.getNombre().equals(pNombre)) {
                return ht;
            }
        }
        ImagenHashTable nueva = new ImagenHashTable(pNombre);
        cache.add(nueva);
        return nueva;
    }
    public void printCache(){
        for(ImagenHashTable ht:cache){
            System.out.println(ht.getNombre());
        }
    }
}