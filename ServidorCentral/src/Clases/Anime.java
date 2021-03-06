/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import dataBase.operaciones;
import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataImagen;
import dataType.reducidos.DataAnimeImNom;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class Anime extends Favorito{
    private Collection<String> generos;
    private String nombre,descripcion,link;
    private Integer capitulos;
    private Map<String,Calidad> calidades;
    private Integer imagen;

    public void setCalidades(Map<String, Calidad> calidades) {
        this.calidades = calidades;
    }
    public void persistir(){
        operaciones.insertarAnime(generos, nombre, descripcion, link, capitulos, imagen);
        for(Calidad cali: calidades.values()){
            cali.persistir();
        }
        
    }
    
    public Anime(Collection<String> generos, String nombre, String descripcion, String link, Integer capitulos, Map<String, Calidad> calidades, Integer imagen) {
        this.generos = generos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.capitulos = capitulos;
        this.calidades = calidades;
        this.imagen = imagen;
    }
    public DataAnime toDataFav(){
        return new DataAnime(null,nombre,null,null,null,null,null);
    }
    public DataAnime toData(){
        Collection<String> gnro = new HashSet();
        for(String gen : generos){
            gnro.add(gen);
        }
         Map<String, DataCalidad> cali = new HashMap();
        for(Calidad gen : calidades.values()){
            cali.put(gen.getCalidad(),gen.toData());
        }
        DataImagen imAnime = operaciones.getDataImagen(imagen, true);
        return new DataAnime(gnro,  nombre,  descripcion,  link,  capitulos,cali,imAnime);
    }
    public DataAnime toDataMiniatura(){
        Collection<String> gnro = new HashSet();
        for(String gen : generos){
            gnro.add(gen);
        }
         Map<String, DataCalidad> cali = new HashMap();
        for(Calidad gen : calidades.values()){
            DataCalidad dcal = gen.toData();
            dcal.cargarImagenes(true);
            cali.put(gen.getCalidad(),dcal);
        }
        DataImagen imAnime = operaciones.getDataImagen(imagen, true);
        return new DataAnime(gnro,  nombre,  descripcion,  link,  capitulos,cali, imAnime);
    }
    public DataAnimeImNom toDataReducido(){     
        DataImagen imAnime = operaciones.getDataImagen(imagen, true);
        return new DataAnimeImNom(nombre,imAnime);
    }
    public Calidad getCalidad(String cali){
        return calidades.get(cali);
    }
    public void add(String gen){
        generos.add(gen);
    }
    public void remove(String nomGen){
        generos.remove(nomGen);
    }

    public void setGeneros(Collection<String> generos) {
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


    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }

    public Integer getCapitulos() {
        return capitulos;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getImagen() {
        return imagen;
    }

    public Collection<String> getGeneros() {
        return generos;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
