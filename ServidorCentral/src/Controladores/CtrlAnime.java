/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Anime;
import Clases.Calidad;
import Clases.Genero;
import Clases.Imagen;
import Clases.Pack;
import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataGenero;
import dataType.DataImagen;
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
    private Map<String,Genero> generos;
    private Map<String,Anime> animes;
    private Map<String,Pack> packs; //String = "nombre&propietario"
    
    private static final String separador= "&";

    private CtrlAnime() {
        generos = new HashMap();
        animes = new HashMap();
        packs = new HashMap();
    }
    private static CtrlAnime instance = null;
    public CtrlAnime getInstance(){
        if(instance == null){
            instance = new CtrlAnime();
        }
        return instance;
    }
    private Pack getPack(String nombre, String propietario){
        return packs.get(nombre+separador+propietario);
    }
    private void removePack(String nombre, String propietario){
        packs.remove(nombre+separador+propietario);
    }
    private void addPack(Pack pack){
        packs.put(pack.getNombre()+separador+pack.getPropietario(), pack);
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

    
    public void addAnime(DataAnime dtanime)  throws Error{
        Imagen imag = new Imagen(dtanime.getImagen().getIdentificador(),dtanime.getImagen().getImag(),dtanime.getImagen().getDescripcion());
        Map<String,Calidad> mapaCali = new HashMap();
        for(DataCalidad dtc: dtanime.getCalidades().values()){
            Map<Integer,Imagen> ims = new HashMap();
            for(DataImagen dim: dtc.getImgs().values()){
                ims.put(dim.getIdentificador(), new Imagen(dim.getIdentificador(),dim.getImag(),dim.getDescripcion()));
            }
            mapaCali.put(dtc.getCalidad(), new Calidad(ims,dtc.getCalidad(),dtc.getAnime()));
        }
        Anime anime = new Anime(dtanime.getGeneros(),dtanime.getNombre(),dtanime.getDescripcion(),dtanime.getLink(),dtanime.getCapitulos(),mapaCali,imag);
        animes.put(dtanime.getNombre(),anime);
        Collection<String> error = new HashSet();
        for(String gen: dtanime.getGeneros()){
            Genero gener = generos.get(gen);
            if (gener == null){
                error.add(gen);
            }else{
                gener.add(anime);
            }
        }
        if(!error.isEmpty()){
            String paraError = "";
            for(String err: error){
                paraError += err+", ";
            }
            throw new Error("No se pudo añadir el anime a los siguientes generos: "+paraError);
        }
    }

    
    public void modAnime(DataAnime dtanime, String nombre) {
        Anime anim = animes.get(nombre);
        if(anim!=null){
            if(dtanime.getCalidades() != null){
                Map<String,Calidad> mapaCali = new HashMap();
                for(DataCalidad dtc: dtanime.getCalidades().values()){
                    Map<Integer,Imagen> ims = new HashMap();
                    for(DataImagen dim: dtc.getImgs().values()){
                        ims.put(dim.getIdentificador(), new Imagen(dim.getIdentificador(),dim.getImag(),dim.getDescripcion()));
                    }
                    mapaCali.put(dtc.getCalidad(), new Calidad(ims,dtc.getCalidad(),dtc.getAnime()));
                }
                anim.setCalidades(mapaCali);
            }
            if(dtanime.getGeneros() != null){
                Collection<String> grs = dtanime.getGeneros();
                anim.setGeneros(grs);
                for(Genero gen: generos.values()){
                    if(!grs.contains(gen.getNombre())){
                        gen.remove(nombre);
                    }else if(gen.getAnime(nombre)==null){
                        gen.add(anim);
                    }
                }
            }
            if (dtanime.getCapitulos() != null){
                anim.setCapitulos(dtanime.getCapitulos());
            }
            if(dtanime.getDescripcion() != null){
                anim.setDescripcion(dtanime.getDescripcion());
            }
            if(dtanime.getImagen() !=null){
                DataImagen dtim = dtanime.getImagen();
                anim.setImagen(new Imagen(dtim.getIdentificador(),dtim.getImag(),dtim.getDescripcion()));
            }
            if(dtanime.getLink() != null){
                anim.setLink(dtanime.getLink());
            }
            if(dtanime.getNombre() != null){
                anim.setNombre(dtanime.getNombre());
            } 
        }else{
            throw new Error("No existe el anime: "+nombre);
        }
    }

    
    public void addGenero(DataGenero dtgen)  throws Error{
        Genero definitivo = new Genero(new HashMap(),dtgen.getNombre(),dtgen.getDescripcion());
        generos.put(dtgen.getNombre(), definitivo);
        for(DataAnime dtanime: dtgen.getAnimes().values()){
            addAnime(dtanime);
        }
    }

    
    public void modGenero(String nombre,String nuevoNom,String desc) {
        Genero gen = generos.get(nombre);
        if(gen==null){
            throw new Error("No existe el genero: "+nombre);
        }else{
            if(desc != null){
                gen.setDescripcion(desc);
            }
            if(nuevoNom != null){
                gen.setNombre(nuevoNom);
                generos.remove(nombre);
                generos.put(nuevoNom,gen);
            }
        }
        
        
    }

    
    public Collection<DataPackReducido> listarPacks() {
        Collection<DataPackReducido>  ret = new HashSet();
        for(Pack pack : packs.values()){
            ret.add(new DataPackReducido(pack.getMuestra().toData(),pack.getNombre(),pack.getPropietario().getCorreo()));
        }
        return ret;
    }

    
    public DataPack detallePack(String nombre, String propietario) {
        return getPack(nombre,propietario).toData();
    }
    
}
