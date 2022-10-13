package ADT.ImageFlyweight;
import ADT.State;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.annotation.processing.Filer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlyweightJSON {
    /*
    Esta clase la usamos para reciclar el JSONParser y los FileReader, de lo contrario tendriamos que
    hacer un new a cada uno de esos cada vez que quisieramos obtener una imagen
     */
    private static JSONParser parser;

    private static JSONParser parserArmas;
    private static FileReader reader;
    private static FileReader weaponsReader;



    public FlyweightJSON() throws FileNotFoundException {
        parser = new JSONParser();
        parserArmas = new JSONParser();
        reader = new FileReader(".\\src\\ImagenesPersonaje.json");
        weaponsReader = new FileReader(".\\src\\ImagenesArma.json");

    }


    public static String datos(String pNombre, int pNivel, State pEstado)  {

        JSONParser jsonParser = new JSONParser();
        FileReader lector = null;
        try {
            lector = new FileReader(".\\src\\ImagenesPersonaje.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JSONObject lista = null;
        try {
            lista = (JSONObject) jsonParser.parse(lector);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject personaje =  (JSONObject) lista.get(pNombre);
        JSONObject nivel =  (JSONObject) personaje.get(Integer.toString(pNivel));
        String url = nivel.get(pEstado.name()).toString();
        return url;
    }

    public static String datosArma(String pNombre, int pNivel)  {

        JSONParser jsonParser = new JSONParser();
        FileReader lector = null;
        try {
            lector = new FileReader(".\\src\\ImagenesArma.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JSONObject lista = null;
        try {

            lista = (JSONObject) jsonParser.parse(lector);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject arma =  (JSONObject) lista.get(pNombre);
        String url = arma.get(Integer.toString(pNivel)).toString();
        return url;
    }

    public static Image getImage(String url){
        BufferedImage imagen =null;
        try{
            //Image es clase abstracta de java, podemos retornar bufferedImage
            //y ponerlo en atributo Image de personaje / arma
            imagen = ImageIO.read(new File(url));
            System.out.println(Integer.toString(imagen.getHeight()));
            System.out.println(imagen.toString());

        }catch (IOException e){
            System.out.println("Imagen no encontrada, revisar formato");

        }
        return imagen;
    }

}
