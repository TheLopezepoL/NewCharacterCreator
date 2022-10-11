//package ADT.Weapon;
//
//import ADT.IBuilder;
//
//import java.awt.*;
//
//public class BuilderWeapon implements IBuilder<aWeapon> {
//
//    protected String nombre;
//    protected double alcance;
//    protected double danho;
//    protected double radioExplosion;
//    protected double velocidadDeAtaque;
//    protected int nivel;
//    protected Image imagen;
//    protected boolean activo;
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public void setAlcance(double alcance) {
//        this.alcance = alcance;
//    }
//
//    public void setDanho(double danho) {
//        this.danho = danho;
//    }
//
//    public void setRadioExplosion(double radioExplosion) {
//        this.radioExplosion = radioExplosion;
//    }
//
//
//    public void setVelocidadDeAtaque(double velocidadDeAtaque) {
//        this.velocidadDeAtaque = velocidadDeAtaque;
//    }
//
//    public void setNivel(int nivel) {
//        this.nivel = nivel;
//    }
//
//    public void subirNivel() {
//        this.nivel++;
//    }
//
//    public void setActivo(boolean activo) {
//        this.activo = activo;
//    }
//
//    public void setImagen(Image imagen){
//        this.imagen = imagen;
//    }
//
//    @Override
//    public aWeapon build(){
//        return new aWeapon(nombre, alcance, danho, radioExplosion, velocidadDeAtaque, nivel, imagen);
//    }
//}
