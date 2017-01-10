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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCliente extends DataUsuario{
    private Collection<String> pendientes;
    private Map<String,DataPack> packs;
    private Collection<DataFavorito> fav;
    private Collection<DataNotificacion> noVistas;
    private Collection<DataNotificacion> visto;

    public void setPendientes(Collection<String> pendientes) {
        this.pendientes = pendientes;
    }

    public void setPacks(Map<String, DataPack> packs) {
        this.packs = packs;
    }

    public void setFav(Collection<DataFavorito> fav) {
        this.fav = fav;
    }

    public void setNoVistas(Collection<DataNotificacion> noVistas) {
        this.noVistas = noVistas;
    }

    public void setVisto(Collection<DataNotificacion> visto) {
        this.visto = visto;
    }

    public DataCliente() {
    }

    public DataCliente(Collection<String> pendientes, Map<String, DataPack> packs, Collection<DataFavorito> fav, Collection<DataNotificacion> noVistas, Collection<DataNotificacion> visto, String nickname, String correo) {
        super(nickname, correo);
        this.pendientes = pendientes;
        this.packs = packs;
        this.fav = fav;
        this.noVistas = noVistas;
        this.visto = visto;
    }

    public Collection<String> getPendientes() {
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
