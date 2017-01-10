/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

import java.util.Map;

/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCalidad extends DataFavorito{
    private Map<Integer,DataImagen> imgs;
    private String calidad,anime;//ej: 720x480

    public void setImgs(Map<Integer, DataImagen> imgs) {
        this.imgs = imgs;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public DataCalidad() {
    }

    public DataCalidad(Map<Integer, DataImagen> imgs, String calidad, String anime) {
        this.imgs = imgs;
        this.calidad = calidad;
        this.anime = anime;
    }

    public Map<Integer, DataImagen> getImgs() {
        return imgs;
    }

    public String getCalidad() {
        return calidad;
    }

    public String getAnime() {
        return anime;
    }
    
    
    
}
