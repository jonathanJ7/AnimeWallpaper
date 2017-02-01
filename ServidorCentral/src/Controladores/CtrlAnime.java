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
import dataBase.operaciones;
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
import servidor.ServidorCentral;

/**
 *
 * @author Jonathan
 */
public class CtrlAnime implements IAnime{
    
    private Integer identImg;

    private CtrlAnime() {
        identImg = 0;
    }
    public Integer getIdentImg(){
        return identImg++;
    }
    private static CtrlAnime instance = null;
    public static CtrlAnime getInstance(){
        if(instance == null){
            instance = new CtrlAnime();
        }
        return instance;
    }
    public Pack getPack(String nombre, String propietario){
        return operaciones.getPack(nombre, propietario);
    }
    public void removePack(String nombre, String propietario){
        //packs.remove(nombre+separador+propietario);
    }
    public Collection<DataAnimeImNom> listarAnimes() {
        return operaciones.listarAnimes();
    }

    public DataAnime detalleAnime(String anime) throws Error{
        return operaciones.detalleAnime(anime);
    }

    
    public Collection<String> listarGeneros() {
        return operaciones.listarGeneros();
    }

    
    public DataGeneroReducido detalleGenero(String gen) throws Error{
        return operaciones.detalleGenero(gen);
    }
    
    public void addAnime(DataAnime dtanime)  throws Error{
        Map<String,Calidad> mapaCali = new HashMap();
        for(DataCalidad dtc: dtanime.getCalidades().values()){
            Map<Integer,Imagen> ims = new HashMap();
            for(DataImagen dim: dtc.getImgs().values()){
                ims.put(dim.getIdentificador(), new Imagen(dim.getIdentificador(),dim.getImag(),dim.getDescripcion()));
            }
            Calidad cal = new Calidad(ims,dtc.getCalidad(),dtc.getAnime());
            mapaCali.put(dtc.getCalidad(), cal);
        }
        Anime anime = new Anime(dtanime.getGeneros(),dtanime.getNombre(),dtanime.getDescripcion(),dtanime.getLink(),dtanime.getCapitulos(),mapaCali,dtanime.getImagen().getIdentificador());
        Collection<String> error = new HashSet();
        /*for(String gen: dtanime.getGeneros()){
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
        }*/
        anime.persistir();
    }

    
    public void modAnime(DataAnime dtanime, String nombre) {
        /*Anime anim = animes.get(nombre);
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
                anim.setImagen(dtim.getIdentificador());
            }
            if(dtanime.getLink() != null){
                anim.setLink(dtanime.getLink());
            }
            if(dtanime.getNombre() != null){
                anim.setNombre(dtanime.getNombre());
            } 
        }else{
            throw new Error("No existe el anime: "+nombre);
        }*/
    }

    
    public void addGenero(DataGenero dtgen){
        Genero definitivo = new Genero(new HashMap(),dtgen.getNombre(),dtgen.getDescripcion());
        definitivo.persistir();
    }

    
    public void modGenero(String nombre,String nuevoNom,String desc) {
        /*Genero gen = generos.get(nombre);
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
        }*/
        
        
    }

    
    public Collection<DataPackReducido> listarPacks() {
        Collection<DataPackReducido>  ret = new HashSet();
        for(Pack pack : operaciones.listarPacks()){
            DataImagen muestra = operaciones.getDataImagen(pack.getMuestra(), true);
            ret.add(new DataPackReducido(muestra,pack.getNombre(),pack.getPropietario().getNickname()));
        }
        return ret;
    }

    
    public DataPack detallePack(String nombre, String propietario) {
        return getPack(nombre,propietario).toDataMiniatura();
    }

    public byte[] getImagen(int identificador) {
        return operaciones.getDataImagen(identificador,false).getImag();
    }
    
}
