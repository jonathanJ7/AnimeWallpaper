/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuentas.Admin;
import Clases.Cuentas.Cliente;
import Clases.Cuentas.Usuario;
import Clases.Imagen;
import Clases.Pack;
import dataType.DataAdmin;
import dataType.DataCliente;
import dataType.DataFavorito;
import dataType.DataImagen;
import dataType.DataNotificacion;
import dataType.DataPack;
import dataType.DataUsuario;
import interfaz.IUsr;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class CtrlUsr implements IUsr{
    Map<String,Usuario> usuarios; //String = nick 

    
    public Map<String, DataUsuario> listarUsuarios() { //String nick
        Map<String, DataUsuario> ret = new HashMap();
        for(Usuario usr: usuarios.values()){
            ret.put(usr.getNickname(), usr.toData());
        }
        return ret;
    }

    
    public DataCliente detalleCliente(String nick) throws Error{
        Usuario usr = usuarios.get(nick);
        if(usr == null || !(usr instanceof Cliente)){
            throw new Error("No existe el cliente: "+nick);
        }else{
            Cliente cli = (Cliente) usr;
            return (DataCliente) cli.toData();
        }
    }

    
    public void addUsr(DataUsuario dtusr,String pass) {
        boolean error = false;
        for(Usuario usu: usuarios.values()){
            if(usu.getCorreo().equals(dtusr.getCorreo()) || usu.getNickname().equals(dtusr.getNickname())){
                error = true;
                break;
            }
        }
        if(error){
            throw new Error("Usuario no disponible");
        }else{
            if(dtusr instanceof DataCliente){
                Cliente cli = new Cliente(dtusr.getNickname(),dtusr.getCorreo(),pass);
                usuarios.put(cli.getNickname(),cli);
            }else if(dtusr instanceof DataAdmin){
                Admin adm = new Admin(dtusr.getNickname(),dtusr.getCorreo(),pass);
                usuarios.put(adm.getNickname(),adm);
            }
        }
    }

    
    public void addPendiente(String nick, String anime) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.add(anime);
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
    }

    
    public void addPack(String nick, DataPack pack) {
        Usuario usr = usuarios.get(nick);
        Usuario usu = usuarios.get(pack.getPropietario());
        if(usu != null && usu instanceof Cliente){
            if(usr != null && usr instanceof Cliente){
                Cliente cli = (Cliente) usr;
                Map<Integer,Imagen> topack = new HashMap();
                for(DataImagen dim : pack.getColIm().values()){
                    topack.put(dim.getIdentificador(), new Imagen(dim.getIdentificador(),dim.getImag()));
                }
                Pack pk = new Pack(topack,pack.getNombre(),usu);
                cli.add(pk);
            }else{
                throw new Error("No existe el cliente: "+nick);
            }
        }else{
                throw new Error("No existe el cliente: "+pack.getPropietario());            
        }
    }

    
    public void addFav(String nick, DataFavorito fav) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            //ACA FALTA HACER LO IMPORTANTE 
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
    }

    
    public void removeFav(String nick, DataFavorito fav) {
        
    }

    
    public void addNotificacion(String nick, DataNotificacion notif) {
        
    }

    
    public void movNotificacion(String nick, DataNotificacion notif) {
        
    }

    
    public boolean credenciales(String nick, String pass) {
        return true;
    }

    public void removePendiente(String nick, String anime) {

    }

    public void removePack(String nick, String nombre) {
    
    }
    
}
