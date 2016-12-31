/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import dataType.DataAnime;
import dataType.DataGenero;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Jonathan
 */
public class Genero {
    private Map<String,Anime> animes;
    private String nombre;
    private String descripcion;

    public DataGenero toData(){
        Map<String, DataAnime> ani = new HashMap();
        for(Anime anim: animes.values()){
            ani.put(anim.getNombre(), anim.toData());
        }
        return new DataGenero(ani,  nombre,  descripcion);
    }
    public DataGeneroReducido toDataReducido(){
        Map<String,DataAnimeImNom> mapToRet = new HashMap();
        for (Entry ent : animes.entrySet() ){
            mapToRet.put((String)ent.getKey(), ( (Anime)ent.getValue() ).toDataReducido()  );
        }
        return new DataGeneroReducido(mapToRet,nombre,descripcion);
    }
    
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
