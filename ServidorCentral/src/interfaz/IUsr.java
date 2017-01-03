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
public interface IUsr {
    Map<String,DataUsuario> listarUsuarios();
    DataCliente detalleCliente(String nick);
    
    void addUsr(DataUsuario dtusr,String pass);
    void addPendiente(String nick, String anime);
    void removePendiente(String nick, String anime);
    void addPack(String nick, DataPack pack);
    void removePack(String nick, String nombre);
    void addFav(String nick,DataFavorito fav);
    void removeFav(String nick,DataFavorito fav);//si es anime solo necesita el nombre, si es calidad necesita calidad y nombre del anime, y si es pack necesita propietario y nombre
    void addNotificacion(String nick, DataNotificacion notif);
    void movNotificacion(String nick, DataNotificacion notif);
    
    boolean credenciales(String nick,String pass);
    
}
