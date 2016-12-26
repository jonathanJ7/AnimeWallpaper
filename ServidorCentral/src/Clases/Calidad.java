/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import dataType.DataCalidad;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class Calidad extends Favorito{
    private Map<Integer,Imagen> imgs;
    private String calidad;//ej: 720x480

    public DataCalidad toData(){
        return null;
    } 
    
    public Map<Integer, Imagen> getImgs() {
        return imgs;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setImgs(Map<Integer, Imagen> imgs) {
        this.imgs = imgs;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public Calidad(Map<Integer, Imagen> imgs, String calidad) {
        this.imgs = imgs;
        this.calidad = calidad;
    }
     public void add(Imagen img){
        imgs.put(img.getIdentificador(), img);
    }
    public void remove(String nomGen){
        imgs.remove(nomGen);
    }
   public Imagen getGenero(String nombre){
       return imgs.get(nombre);
   }
}
