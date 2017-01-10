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
public class DataPack extends DataFavorito{
    
    private Map<Integer,DataImagen> colIm;
    private String nombre;
    private String propietario;

    public void setColIm(Map<Integer, DataImagen> colIm) {
        this.colIm = colIm;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public DataPack() {
    }

    public DataPack(Map<Integer, DataImagen> colIm, String nombre, String propietario) {
        this.colIm = colIm;
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public Map<Integer, DataImagen> getColIm() {
        return colIm;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPropietario() {
        return propietario;
    }
    
}
