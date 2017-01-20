/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author Jonathan
 */
import dataBase.operaciones;
import dataType.DataAnime;
import dataType.DataCliente;
import dataType.DataFavorito;
import dataType.DataGenero;
import dataType.DataImagen;
import dataType.DataNotificacion;
import dataType.DataPack;
import dataType.DataUsuario;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import dataType.reducidos.DataPackReducido;
import interfaz.IAnime;
import interfaz.IUsr;
import interfaz.fabrica;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;




@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
        try {
            //configuracion conf = configuracion.getInstance();
           
            String host = "localhost";//conf.getPropiedad("ipPublicarServicio");
            String puerto = "9128";//conf.getPropiedad("puertoPublicarServicio");
            endpoint = Endpoint.publish("http://"+host+":"+puerto+"/publicador", this);
        } catch (Error ex) {
        }
    }
    
    private static IUsr interUsr = fabrica.getInstance().getIUsr();
    private static IAnime interAnime = fabrica.getInstance().getIAnime();

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    @WebMethod
    public void publicdtt(DataPackReducido dpr,DataAnimeImNom dain){       
    }
    /*********INTERFAZ DE USUARIO *******/
    @WebMethod
    public DataMap /*Map<String,DataUsuario>*/ listarUsuarios(){
        return new DataMap(interUsr.listarUsuarios());
    }
    @WebMethod
    public DataCliente detalleCliente(String nick){
        return interUsr.detalleCliente(nick);
    }
    @WebMethod
    public void addUsr(DataUsuario dtusr,String pass){
        interUsr.addUsr(dtusr, pass);
    }
    @WebMethod
    public void addPendiente(String nick, String anime){
        interUsr.addPendiente(nick, anime);
    }
    @WebMethod
    public void removePendiente(String nick, String anime){
        interUsr.removePendiente(nick, anime);
    }
    @WebMethod
    public void addPack(String nick, String propietario,String nombre, /*Collection<String> */ DataCollection pathIm){
        interUsr.addPack(nick, propietario, nombre,pathIm.getCol());
    }
    @WebMethod
    public void removePack(String nick, String nombre){
        interUsr.removePack(nick, nombre);
    }
    @WebMethod
    public void addFav(String nick,DataFavorito fav){
        interUsr.addFav(nick, fav);
    }
    @WebMethod
    public void removeFav(String nick,DataFavorito fav){//si es anime solo necesita el nombre, si es calidad necesita calidad y nombre del anime, y si es pack necesita propietario y nombre
        interUsr.removeFav(nick, fav);
    }
    @WebMethod
    public void addNotificacion(String nick, DataNotificacion notif){
        interUsr.addNotificacion(nick, notif);
    }
    @WebMethod
    public void movNotificacion(String nick, DataNotificacion notif){
        interUsr.movNotificacion(nick, notif);
    }
    
    @WebMethod
    public String credenciales(String correo ,String pass){//se loguea por correo por seguridad
        String ret= interUsr.credenciales(correo, pass);
        if(ret==null){
            ret ="";
        }
        return ret;
    }
    
    @WebMethod
    public DataCollection/*Collection<DataFavorito> */getDataFavorito(String nick){
       return new DataCollection(interUsr.getDataFavorito(nick));
    }
    /********** INTERFAZ DE ANIME *****************/
    
    @WebMethod
    public DataCollection /*Collection<DataAnimeImNom>*/ listarAnimes(){
        return new DataCollection(interAnime.listarAnimes());
    }
    @WebMethod
    public byte[] getImagen(int identificador){
        return interAnime.getImagen(identificador);
    }
    @WebMethod
    public DataAnime detalleAnime(String anime){
        return interAnime.detalleAnime(anime);
    }
    
    @WebMethod
    public DataCollection /*Collection<String>*/ listarGeneros(){
        return new DataCollection(interAnime.listarGeneros());
    }
    @WebMethod
    public DataGeneroReducido detalleGenero(String gen){
        return interAnime.detalleGenero(gen);
    }
    
    @WebMethod
    public void addAnime(DataAnime dtanime){
        interAnime.addAnime(dtanime);
    }
    @WebMethod
    public void modAnime(DataAnime dtanime,String nombre){
        interAnime.modAnime(dtanime, nombre);
    }
    
    @WebMethod
    public void addGenero(DataGenero dtgen){
        interAnime.addGenero(dtgen);
    }
    @WebMethod
    public void modGenero(String nombre,String nuevoNom,String desc){
        interAnime.modGenero(nombre, nuevoNom, desc);
    }
    
    @WebMethod
    public DataCollection /*Collection<DataPackReducido>*/listarPacks(){
        return new DataCollection(interAnime.listarPacks());
    }
    @WebMethod
    public DataPack detallePack(String nombre,String propietario){
        return interAnime.detallePack(nombre, propietario);
    }
}