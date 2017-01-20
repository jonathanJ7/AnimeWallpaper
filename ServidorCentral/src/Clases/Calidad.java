/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import dataBase.operaciones;
import dataType.DataCalidad;
import java.io.ByteArrayInputStream;
import java.util.Map;
import servidor.ServidorCentral;


/**
 *
 * @author Jonathan
 */
public class Calidad extends Favorito{
    private Map<Integer,Imagen> imgs;
    private String calidad,anime;//ej: 720x480

    public Calidad(Map<Integer,Imagen> imgs, String calidad, String anime) {
        this.imgs = imgs;
        this.calidad = calidad;
        this.anime = anime;
    }
    
    public void persistir(){
        for(Imagen img: imgs.values()){
            Imagen mini = ServidorCentral.redimencion(img);
            
            ByteArrayInputStream bis = new ByteArrayInputStream(img.getImag());
            operaciones.insertarImagen(img.getIdentificador(), img.getDescripcion(), bis, false);
            
            bis = new ByteArrayInputStream(mini.getImag());            
            operaciones.insertarImagen(img.getIdentificador(), img.getDescripcion(), bis, true);
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
        return new DataCalidad(imgs.keySet(),calidad,anime);
    } 
    
    public String getCalidad() {
        return calidad;
    }

    public Map<Integer, Imagen> getImgs() {
        return imgs;
    }

    public void setImgs(Map<Integer, Imagen> imgs) {
        this.imgs = imgs;
    }
    

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

     public void add(Imagen img){
        imgs.put(img.getIdentificador(), img);
    }
    public void remove(int identificador){
        imgs.remove(identificador);
    }
   public Imagen getImagen (int identificador){
       return imgs.get(identificador);
   }
}
