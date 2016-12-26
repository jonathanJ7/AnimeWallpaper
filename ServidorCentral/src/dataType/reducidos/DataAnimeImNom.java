/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType.reducidos;

/**
 *
 * @author Jonathan
 */
public class DataAnimeImNom {
    String nombre;
    Byte[] img;

    public DataAnimeImNom(String nombre, Byte[] img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public Byte[] getImg() {
        return img;
    }
    
}
