/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Cuentas;

import Clases.Anime;
import Clases.Pack;
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
            fa.add(an.toData());
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

    public Cliente(Collection<String> pendientes, Map<String, Pack> packs, Collection<Favorito> fav, Collection<Notificacion> noVistas, Collection<Notificacion> visto, String nickname, String correo, String pass) {
        super(nickname, correo, pass);
        this.pendientes = pendientes;
        this.packs = packs;
        this.fav = fav;
        this.noVistas = noVistas;
        this.visto = visto;
    }

    public Collection<String> getPendientes() {
        return pendientes;
    }

    public Map<String, Pack> getPacks() {
        return packs;
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
        packs.put(pack.getNombre(), pack);
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
    public void remove(Anime anim){
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
