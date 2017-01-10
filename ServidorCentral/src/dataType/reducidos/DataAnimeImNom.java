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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataAnimeImNom {
    String nombre;
    DataImagen img;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImg(DataImagen img) {
        this.img = img;
    }

    public DataAnimeImNom() {
    }

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
