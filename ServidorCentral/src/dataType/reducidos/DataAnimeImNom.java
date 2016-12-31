/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType.reducidos;

import dataType.DataImagen;

/**
 *
 * @author Jonathan
 */
public class DataAnimeImNom {
    String nombre;
    DataImagen img;

    public DataAnimeImNom(String nombre, DataImagen img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public DataImagen getImg() {
        return img;
    }
    
}
