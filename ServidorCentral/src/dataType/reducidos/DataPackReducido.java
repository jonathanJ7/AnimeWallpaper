/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType.reducidos;

import dataType.DataImagen;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPackReducido {
    private DataImagen imMuesra;
    private String nombre;
    private String propietario;

    public DataPackReducido() {
    }

    public void setImMuesra(DataImagen imMuesra) {
        this.imMuesra = imMuesra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public DataImagen getImMuesra() {
        return imMuesra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public DataPackReducido(DataImagen imMuesra, String nombre, String propietario) {
        this.imMuesra = imMuesra;
        this.nombre = nombre;
        this.propietario = propietario;
    }
    
    
}
