/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class Genero {
    Map<String,Anime> animes;
    String nombre;
    String descripcion;

    public Genero(Map<String, Anime> animes, String nombre, String descripcion) {
        this.animes = animes;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Genero(Map<String, Anime> animes, String nombre) {
        this.animes = animes;
        this.nombre = nombre;
    }

    public Map<String, Anime> getAnimes() {
        return animes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void add(Anime anim){
        animes.put(anim.getNombre(), anim);
    }
    public void remove(String nombreAnime){
        animes.remove(nombreAnime);
    }
   public Anime getAnime(String nombre){
       return animes.get(nombre);
   }
}
