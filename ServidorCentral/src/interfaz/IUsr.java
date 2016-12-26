/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dataType.DataCliente;
import dataType.DataFavorito;
import dataType.DataNotificacion;
import dataType.DataPack;
import dataType.DataUsuario;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public abstract class IUsr {
    abstract Map<String,DataUsuario> listarUsuarios();
    abstract DataCliente detalleCliente(String correo);
    
    abstract void addUsr(DataUsuario dtusr);
    abstract void addPendiente(String correo, String anime);
    abstract void addPack(String correo, DataPack pack);
    abstract void addFav(String correo,DataFavorito fav);
    abstract void removeFav(String correo,DataFavorito fav);//si es anime solo necesita el nombre, si es calidad necesita calidad y nombre del anime, y si es pack necesita propietario y nombre
    abstract void addNotificacion(String correo, DataNotificacion notif);
    abstract void movNotificacion(String correo, DataNotificacion notif);
    
    abstract boolean credenciales(String correo,String pass);
    
}
