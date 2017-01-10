/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;


import java.util.Map;

/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataMap {
    Map mapa;

    public DataMap() {
    }

    public DataMap(Map mapa) {
        this.mapa = mapa;
    }

    public Map getMapa() {
        return mapa;
    }

    public void setMapa(Map mapa) {
        this.mapa = mapa;
    }
    
}
