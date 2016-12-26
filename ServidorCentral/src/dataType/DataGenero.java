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
public class DataGenero {
    
    private Map<String,DataAnime> animes;
    private String nombre;
    private String descripcion;

    public DataGenero(Map<String, DataAnime> animes, String nombre, String descripcion) {
        this.animes = animes;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Map<String, DataAnime> getAnimes() {
        return animes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
