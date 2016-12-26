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
public class DataPackReducido {
    private DataImagen imMuesra;
    private String nombre;
    private String propietario;

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
