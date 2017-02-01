/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cuentas.Admin;
import Clases.Cuentas.Cliente;
import Clases.Cuentas.Usuario;
import Clases.Pack;
import dataBase.operaciones;
import dataType.DataAdmin;
import dataType.DataCliente;
import dataType.DataFavorito;
import dataType.DataNotificacion;
import dataType.DataUsuario;
import interfaz.IUsr;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class CtrlUsr implements IUsr{

    private CtrlUsr() {
    }
    private static CtrlUsr instance =null;
    public static CtrlUsr getInstance(){
        if(instance==null){
            instance = new CtrlUsr();
        }
        return instance;
    }

    
    public Collection<String> listarUsuarios() { 
        return operaciones.listarUsuarios();
    }

    
    public DataCliente detalleCliente(String nick) throws Error{
        Usuario usr = operaciones.getUsuario(nick);
        if(usr == null || !(usr instanceof Cliente)){
            throw new Error("No existe el cliente: "+nick);
        }else{
            Cliente cli = (Cliente) usr;
            cli.cargarPacks();
            return (DataCliente) cli.toData();
        }
    }
    
    public Collection<DataFavorito> getDataFavorito(String nick) throws Error{
        /*Usuario usr = usuarios.get(nick);
        if(usr == null || !(usr instanceof Cliente)){
            throw new Error("No existe el cliente: "+nick);
        }else{
            Cliente cli = (Cliente) usr;
            return cli.getDataFavorito();
        }*/
        return new HashSet();//provisorio
    }
    
    

    
    public void addUsr(DataUsuario dtusr,String pass) {
        if(dtusr instanceof DataCliente){
            Cliente cli = new Cliente(dtusr.getNickname(),dtusr.getCorreo(),pass);
            cli.persistir();
        }else if(dtusr instanceof DataAdmin){
            Admin adm = new Admin(dtusr.getNickname(),dtusr.getCorreo(),pass);
            adm.persistir();
        }
    }

    
    public void addPendiente(String nick, String anime) {
        /*Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.add(anime);
        }else{
            throw new Error("No existe el cliente: "+nick);
        }*/
    }

    
    public void addPack(String nick, String propietario,String nombre, Collection<Integer> pathIm) {
        Usuario usr = operaciones.getUsuario(nick);
        Usuario usu = null;
        if(propietario.equals(nombre)){
            usu = usr;
        }else{
            usu = operaciones.getUsuario(propietario);
        }
        CtrlAnime ctrlAnime = CtrlAnime.getInstance();
        if(usu != null && usu instanceof Cliente){
            if(usr != null && usr instanceof Cliente){
                Cliente cli = (Cliente) usr;
                Pack pk = new Pack(pathIm,nombre,usu);
                if(propietario.equals(nick)){
                    pk.persistir();
                }
                cli.add(pk);
            }else{
                throw new Error("No existe el cliente: "+nick);
            }
        }else{
                throw new Error("No existe el cliente: "+propietario);            
        }
    }

    
    public void addFav(String nick, DataFavorito fav) {/*
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
        }*/
    }

    
    public void removeFav(String nick, DataFavorito fav) {/*
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
        }*/
    }

    
    public void addNotificacion(String nick, DataNotificacion notif) {
        /*Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.add(new Notificacion(notif.getMensaje(),notif.getLink()));
        }else{
            throw new Error("No existe el cliente: "+nick);
        }*/
    }

    
    public void movNotificacion(String nick, DataNotificacion notif) {
        /*Usuario usr = usuarios.get(nick);
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
        }*/
        
    }

    
    public String credenciales(String correo, String pass) {//se loguea por correo por seguridad
        Usuario usu = operaciones.getUsuario(correo);
        if (usu.getPass().equals(pass)){
            return usu.getNickname();
        }else{
            return null;
        }
    }

    public void removePendiente(String nick, String anime) {
        /*Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.removeAnime(anime);
        }else{
            throw new Error("No existe el cliente: "+nick);
        }*/
        
    }

    public void removePack(String nick, String nombre) {
        /*Usuario usr = usuarios.get(nick);
        if(usr != null && usr instanceof Cliente){
            Cliente cli = (Cliente) usr;
            cli.remove(nombre);
        }else{
            throw new Error("No existe el cliente: "+nick);
        }*/
    }
    
}
