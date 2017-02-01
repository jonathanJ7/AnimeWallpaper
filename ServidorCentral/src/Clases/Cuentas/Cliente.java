/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Cuentas;

import Clases.Anime;
import Clases.Pack;
import dataBase.operaciones;
import dataType.DataCliente;
import dataType.DataFavorito;
import dataType.DataNotificacion;
import dataType.DataPack;
import dataType.DataUsuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class Cliente extends Usuario{
    private Collection<String> pendientes;//nombre anime
    private Map<String,Pack> packs;
    private Collection<Favorito> fav;
    private Collection<Notificacion> noVistas;
    private Collection<Notificacion> visto;
    
    
    
    public void persistir(){
        operaciones.insertarUsuario(this.getNickname(), this.getCorreo(), this.getPass(), true);
    }
    
    public DataUsuario toData(){
        Collection<String> pend = new HashSet();
        for(String an : pendientes){
            pend.add(an);
        }
        Map<String, DataPack> pa = new HashMap();
        for(Pack an : packs.values()){
            pa.put(an.getNombre(), an.toData());
        }
        Collection<DataFavorito> fa = new HashSet();
        for(Favorito an : fav){
            fa.add(an.toDataFav());
        }
        Collection<DataNotificacion> nv = new HashSet();
        for(Notificacion an : noVistas){
            nv.add(an.toData());
        }
        Collection<DataNotificacion> vsto = new HashSet();
        for(Notificacion an : visto){
            vsto.add(an.toData());
        }
        return new DataCliente(pend, pa, fa,nv,vsto,  this.getNickname(), this.getCorreo());
    }
    
    public Collection<DataFavorito> getDataFavorito(){
        Collection<DataFavorito> fa = new HashSet();
        for(Favorito an : fav){
            fa.add(an.toDataFav());
        }
        return fa;
    }

 
    public Cliente(String nickname, String correo,String pass) {
        super(nickname, correo,pass);
        this.pendientes = new HashSet();
        this.packs = new HashMap();;
        this.fav = new HashSet();
        this.noVistas = new HashSet();
        this.visto = new HashSet();
    }
    public Collection<String> getPendientes() {
        return pendientes;
    }

    public Map<String, Pack> getPacks() {
        return packs;
    }
    public void cargarPacks(){
        packs = operaciones.getPacks(this.getNickname());
    }
    public Collection<Favorito> getFav() {
        return fav;
    }

    public Collection<Notificacion> getNoVistas() {
        return noVistas;
    }

    public Collection<Notificacion> getVisto() {
        return visto;
    }
    public void add(Pack pack){
        operaciones.insertarPackCliente(this.getNickname(), pack.getPropietario().getNickname(), pack.getNombre());
    }
    public void remove(String nomPack){
        packs.remove(nomPack);
    }
   public Pack getGenero(String nombre){
       return packs.get(nombre);
   }
   
   
   public void add(String anim){
        pendientes.add(anim);
    }
    public void removeAnime(String anim){
        pendientes.remove(anim);
    }
   
   
   public void add(Notificacion not){
        noVistas.add(not);
    }
    public void remove(Notificacion not){
        noVistas.remove(not);
    }
   
   
   public void add(Favorito favorito){
        fav.add(favorito);
    }
    public void remove(Favorito favorito){
        fav.remove(favorito);
    }
   
   public void addVisto(Notificacion not){
        visto.add(not);
    }
    public void removeVisto(Notificacion not){
        visto.remove(not);
    }
   
}
