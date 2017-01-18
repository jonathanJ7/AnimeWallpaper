/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import dataType.DataCalidad;
import dataType.DataImagen;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import servidor.ServidorCentral;


/**
 *
 * @author Jonathan
 */
public class Calidad extends Favorito{
    private Map<Integer,Imagen> imgs;
    private Map<Integer,Imagen> miniaturas;
    private String calidad,anime;//ej: 720x480

    public Calidad(Map<Integer, Imagen> imgs, String calidad, String anime) {
        this.imgs = imgs;
        this.calidad = calidad;
        this.anime = anime;
        this.miniaturas = new HashMap();
        for (Imagen im : imgs.values()){
            Imagen imMini = ServidorCentral.redimencion(im);
            miniaturas.put(im.getIdentificador(), imMini);
        }
    }
    public DataCalidad toDataFav(){
        return new DataCalidad(null,calidad,anime);
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getAnime() {
        return anime;
    }

    public DataCalidad toData(){
        Map<Integer,DataImagen> imagenes = new HashMap();
        for(Imagen im : imgs.values()){
            imagenes.put(im.getIdentificador(), im.toData());
        }
        return new DataCalidad(imagenes,calidad,anime);
    } 
    public DataCalidad toDataMiniatura(){
        Map<Integer,DataImagen> imagenes = new HashMap();
        for(Imagen im : miniaturas.values()){
            imagenes.put(im.getIdentificador(), im.toData());
        }
        return new DataCalidad(imagenes,calidad,anime);
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

     public void add(Imagen img){
        imgs.put(img.getIdentificador(), img);
        Imagen imMini = ServidorCentral.redimencion(img);
        miniaturas.put(img.getIdentificador(), imMini);
    }
    public void remove(int identificador){
        imgs.remove(identificador);
        miniaturas.remove(identificador);
    }
   public Imagen getImagen (int identificador){
       return imgs.get(identificador);
   }
}
