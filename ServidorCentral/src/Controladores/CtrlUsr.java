/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuentas.Admin;
import Clases.Cuentas.Cliente;
import Clases.Cuentas.Notificacion;
import Clases.Cuentas.Usuario;
import Clases.Imagen;
import Clases.Pack;
import dataType.DataAdmin;
import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataCliente;
import dataType.DataFavorito;
import dataType.DataImagen;
import dataType.DataNotificacion;
import dataType.DataPack;
import dataType.DataUsuario;
import interfaz.IUsr;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class CtrlUsr implements IUsr{
    Map<String,Usuario> usuarios; //String = nick 

    private CtrlUsr() {
        usuarios = new HashMap();
    }
    private static CtrlUsr instance =null;
    public static CtrlUsr getInstance(){
        if(instance==null){
            instance = new CtrlUsr();
        }
        return instance;
    }

    
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
    
    public Collection<DataFavorito> getDataFavorito(String nick) throws Error{
        Usuario usr = usuarios.get(nick);
        if(usr == null || !(usr instanceof Cliente)){
            throw new Error("No existe el cliente: "+nick);
        }else{
            Cliente cli = (Cliente) usr;
            return cli.getDataFavorito();
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

    
    public void addPack(String nick, String propietario,String nombre, Collection<String> pathIm) {
        Usuario usr = usuarios.get(nick);
        Usuario usu = usuarios.get(propietario);
        CtrlAnime ctrlAnime = CtrlAnime.getInstance();
        if(usu != null && usu instanceof Cliente){
            if(usr != null && usr instanceof Cliente){
                Cliente cli = (Cliente) usr;
                Map<Integer,Imagen> topack = new HashMap();
                for(String im : pathIm){
                    String[] param = im.split("/");
                    int ident = Integer.parseInt(param[2]);
                    Imagen imagen= ctrlAnime.getImagenPointer(param[0], param[1],ident);
                    topack.put(ident, imagen);
                }
                Pack pk = new Pack(topack,nombre,usu);
                cli.add(pk);
                CtrlAnime.getInstance().addPack(pk);
            }else{
                throw new Error("No existe el cliente: "+nick);
            }
        }else{
                throw new Error("No existe el cliente: "+propietario);            
        }
    }

    
    public void addFav(String nick, DataFavorito fav) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            if(fav instanceof DataPack){
                DataPack DPack = (DataPack) fav;
                Pack pack = CtrlAnime.getInstance().getPack(DPack.getNombre(), DPack.getPropietario());
                cli.add(pack);
            }else if(fav instanceof DataAnime){
                cli.add(CtrlAnime.getInstance().getAnime(((DataAnime) fav).getNombre()));
            }else if(fav instanceof DataCalidad){
                cli.add(CtrlAnime.getInstance().getAnime(
                        ((DataCalidad) fav).getAnime()
                ).getCalidad(((DataCalidad) fav).getCalidad())
                );                
            }
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
    }

    
    public void removeFav(String nick, DataFavorito fav) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            if(fav instanceof DataPack){
                DataPack DPack = (DataPack) fav;
                Pack pack = CtrlAnime.getInstance().getPack(DPack.getNombre(), DPack.getPropietario());
                cli.remove(pack);
            }else if(fav instanceof DataAnime){
                cli.remove(CtrlAnime.getInstance().getAnime(((DataAnime) fav).getNombre()));
            }else if(fav instanceof DataCalidad){
                cli.remove(CtrlAnime.getInstance().getAnime(
                        ((DataCalidad) fav).getAnime()
                ).getCalidad(((DataCalidad) fav).getCalidad())
                );                
            }
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
    }

    
    public void addNotificacion(String nick, DataNotificacion notif) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.add(new Notificacion(notif.getMensaje(),notif.getLink()));
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
    }

    
    public void movNotificacion(String nick, DataNotificacion notif) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            boolean error=true;
            for(Notificacion noti: cli.getNoVistas()){
                if(noti.getLink().equals(notif.getLink()) && noti.getMensaje().equals(notif.getMensaje())){
                    cli.remove(noti);
                    cli.addVisto(noti);
                    error=false;
                    break;
                }
            }
            if(error){
                throw new Error("La notificacion no existe");
            }
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
        
    }

    
    public String credenciales(String correo, String pass) {//se loguea por correo por seguridad
        for(Usuario usr : usuarios.values()){
            if(usr.getCorreo().equals(correo)){
                if(usr.getPass().equals(pass)){
                    return usr.getNickname();
                }
                break;
            }
        }
        return null;
    }

    public void removePendiente(String nick, String anime) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.removeAnime(anime);
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
        
    }

    public void removePack(String nick, String nombre) {
        Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.remove(nombre);
        }else{
            throw new Error("No existe el cliente: "+nick);
        }
    }
    
}
