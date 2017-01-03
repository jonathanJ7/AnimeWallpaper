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
    DataCliente detalleCliente(String correo);
    
    void addUsr(DataUsuario dtusr);
    void addPendiente(String correo, String anime);
    void addPack(String correo, DataPack pack);
    void addFav(String correo,DataFavorito fav);
    void removeFav(String correo,DataFavorito fav);//si es anime solo necesita el nombre, si es calidad necesita calidad y nombre del anime, y si es pack necesita propietario y nombre
    void addNotificacion(String correo, DataNotificacion notif);
    void movNotificacion(String correo, DataNotificacion notif);
    
    boolean credenciales(String correo,String pass);
    
}
