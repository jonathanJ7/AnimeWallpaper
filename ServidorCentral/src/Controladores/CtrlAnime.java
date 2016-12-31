/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Anime;
import Clases.Genero;
import Clases.Imagen;
import dataType.DataAnime;
import dataType.DataGenero;
import dataType.DataPack;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import dataType.reducidos.DataPackReducido;
import interfaz.IAnime;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class CtrlAnime implements IAnime{
    Map<String,Genero> generos;
    Map<String,Anime> animes;

    private CtrlAnime() {
        generos = new HashMap();
        animes = new HashMap();
    }
    private static CtrlAnime instance = null;
    public CtrlAnime getInstance(){
        if(instance == null){
            instance = new CtrlAnime();
        }
        return instance;
    }
    

    public Collection<DataAnimeImNom> listarAnimes() {
        Collection<DataAnimeImNom> ret = new HashSet();
        for(Anime anim: animes.values()){
            ret.add(anim.toDataReducido());
        }
        return ret;
    }

    public DataAnime detalleAnime(String anime) throws Error{
        Anime anim = animes.get(anime);
        if (anim == null){
            return anim.toData();
        }else{
            throw new Error("No existe el anime: " +anime);
        }
    }

    
    public Collection<String> listarGeneros() {
        return generos.keySet();
    }

    
    public DataGeneroReducido detalleGenero(String gen) throws Error{
        Genero genero = generos.get(gen);
        if (genero == null){
            return genero.toDataReducido();
        }else{
            throw new Error("No existe el genero: " +gen);
        }
    }

    
    public void addAnime(DataAnime dtanime) {
        Imagen imag = new Imagen(dtanime.getImagen().getIdentificador(),dtanime.getImagen().getImag(),dtanime.getImagen().getDescripcion());
        animes.put(dtanime.getNombre(),new Anime(dtanime.getGeneros(),dtanime.getNombre(),dtanime.getDescripcion(),dtanime.getLink(),dtanime.getCapitulos(),imag));
    }

    
    public void modAnime(DataAnime dtanime, String nombre) {
        
    }

    
    public void addGenero(DataGenero dtgen) {
        
    }

    
    public void modGenero(DataGenero dtgen, String nombre) {
        
    }

    
    public Collection<DataPackReducido> listarPacks() {
        return null;
    }

    
    public DataPack detallePack(String nombre, String propietario) {
        return null;
    }
    
}
