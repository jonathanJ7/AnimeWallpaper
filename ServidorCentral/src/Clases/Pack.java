/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import Clases.Cuentas.Usuario;
import dataType.DataImagen;
import dataType.DataPack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import servidor.ServidorCentral;

/**
 *
 * @author Jonathan
 */
public class Pack extends Favorito{
    private Map<Integer,Imagen> colIm;
    private String nombre;
    private Usuario propietario;
    
    
    public DataPack toData(){
        
        Map<Integer,DataImagen> colecIm = new HashMap();
        for(Imagen im : colIm.values()){
            colecIm.put(im.getIdentificador(),im.toData());
        }
        return new DataPack(colecIm,nombre,propietario.getNickname());
    } 
    public DataPack toDataMiniatura(){
        
        Map<Integer,DataImagen> colecIm = new HashMap();
        for(Imagen im : colIm.values()){ 
            colecIm.put(im.getIdentificador(),ServidorCentral.redimencion(im).toData());
        }
        return new DataPack(colecIm,nombre,propietario.getNickname());
    }
    
    public Imagen getMuestra(){
        Iterator iter = colIm.values().iterator();
        return (Imagen) iter.next();
    }
    public DataPack toDataFav(){
        return new DataPack(null,nombre,propietario.getNickname());
    }
    public Pack(Map<Integer,Imagen> colIm, String nombre, Usuario propietario) {
        this.nombre = nombre;
        this.propietario = propietario;
        if(colIm == null){
            this.colIm = new HashMap();
        }else{            
            this.colIm = colIm;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public Map<Integer,Imagen> getColIm() {
        return colIm;
    }
    public void add(Imagen imag){
        colIm.put(imag.getIdentificador(),imag);
    }
    public void remove(Integer id){        
        colIm.remove(id);
    }
    
}
