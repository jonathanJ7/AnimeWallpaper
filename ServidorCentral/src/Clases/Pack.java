/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import Clases.Cuentas.Usuario;
import dataBase.operaciones;
import dataType.DataImagen;
import dataType.DataPack;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import servidor.ServidorCentral;

/**
 *
 * @author Jonathan
 */
public class Pack extends Favorito{
    private Collection<Integer> imgs;
    private String nombre;
    private Usuario propietario;
    
    
    public void persistir(){
        operaciones.insertarPack(imgs, nombre, propietario.getNickname());
    }
    
    public DataPack toData(){
        
        DataPack dp =  new DataPack(imgs,nombre,propietario.getNickname());
        dp.cargarImagenes(false);
        return dp;
    } 
    public DataPack toDataMiniatura(){
        
        DataPack dp =  new DataPack(imgs,nombre,propietario.getNickname());
        dp.cargarImagenes(true);
        return dp;
    }
    
    public Integer getMuestra(){
        Iterator iter = imgs.iterator();
        return (Integer) iter.next();
    }
    public DataPack toDataFav(){
        return new DataPack(null,nombre,propietario.getNickname());
    }
    public Pack(Collection<Integer> imgs, String nombre, Usuario propietario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.imgs = imgs;
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

    public Collection<Integer> getImgs() {
        return imgs;
    }

    public void setImgs(Collection<Integer> imgs) {
        this.imgs = imgs;
    }

    
}
