/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

import java.util.Collection;
import java.util.Map;



/**
 *
 * @author Jonathan
 */
public class DataCliente extends DataUsuario{
    private Collection<DataAnime> pendientes;
    private Map<String,DataPack> packs;
    private Collection<DataFavorito> fav;
    private Collection<DataNotificacion> noVistas;
    private Collection<DataNotificacion> visto;

    public DataCliente(Collection<DataAnime> pendientes, Map<String, DataPack> packs, Collection<DataFavorito> fav, Collection<DataNotificacion> noVistas, Collection<DataNotificacion> visto, String nickname, String correo) {
        super(nickname, correo);
        this.pendientes = pendientes;
        this.packs = packs;
        this.fav = fav;
        this.noVistas = noVistas;
        this.visto = visto;
    }

    public Collection<DataAnime> getPendientes() {
        return pendientes;
    }

    public Map<String, DataPack> getPacks() {
        return packs;
    }

    public Collection<DataFavorito> getFav() {
        return fav;
    }

    public Collection<DataNotificacion> getNoVistas() {
        return noVistas;
    }

    public Collection<DataNotificacion> getVisto() {
        return visto;
    }
    
    
}
