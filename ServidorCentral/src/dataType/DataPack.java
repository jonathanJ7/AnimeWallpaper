/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

import dataBase.operaciones;
import java.util.Collection;
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
    private Collection<Integer> imgsIdent;
    private String nombre;
    private String propietario;

    public Collection<Integer> getImgsIdent() {
        return imgsIdent;
    }

    
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

    public DataPack(Collection<Integer> imgsIdent, String nombre, String propietario) {
        this.imgsIdent = imgsIdent;
        this.nombre = nombre;
        this.propietario = propietario;
    }
    public void cargarImagenes(boolean mini){
        colIm = operaciones.getDataImagenesMap(imgsIdent,mini);
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
