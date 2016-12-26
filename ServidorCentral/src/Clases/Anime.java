/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataGenero;
import dataType.DataImagen;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class Anime extends Favorito{
    private Map<String,Genero> generos;
    private String nombre,descripcion,link;
    private Integer capitulos;
    private Map<String,Calidad> calidades;
    private Imagen imagen;
    
    
    
    public DataAnime toData(){
        Map<String, DataGenero> gnro = new HashMap();
        for(Genero gen : generos.values()){
            gnro.put(gen.getNombre(),gen.toData());
        }
         Map<String, DataCalidad> cali = new HashMap();
        return new DataAnime(gnro,  nombre,  descripcion,  link,  capitulos,cali, imagen.toData());
    }

    public Anime(Map<String, Genero> generos, String nombre, String descripcion, String link, Integer capitulos, Imagen imagen) {
        this.generos = generos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.capitulos = capitulos;
        this.imagen = imagen;
    }
    public void add(Genero gen){
        generos.put(gen.getNombre(), gen);
    }
    public void remove(String nomGen){
        generos.remove(nomGen);
    }
   public Genero getGenero(String nombre){
       return generos.get(nombre);
   }

    public void setGeneros(Map<String, Genero> generos) {
        this.generos = generos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCapitulos(Integer capitulos) {
        this.capitulos = capitulos;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }

    public Integer getCapitulos() {
        return capitulos;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public Map<String, Genero> getGeneros() {
        return generos;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
