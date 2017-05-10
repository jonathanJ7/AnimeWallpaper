/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import Clases.Cuentas.Admin;
import Clases.Cuentas.Cliente;
import Clases.Cuentas.Usuario;
import Clases.Pack;
import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataFavorito;
import dataType.DataImagen;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import dataType.reducidos.DataPackReducido;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class operaciones {
    public static Connection con = conectar.getConnection();
    public static void  insertarGenero(String nombre,String descripcion){
        String sql = "INSERT INTO generos (nombre,descripcion) VALUES(?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre); 
            pst.setString(2, descripcion); 
            int n= pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en insercion en generos: " +ex.getMessage());
        }
    }
    public static void  insertarFavAnime(String nickname,String anime){
        String sql = "INSERT INTO clientefavanime (nickname,anime) VALUES(?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nickname); 
            pst.setString(2, anime); 
            int n= pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en insercion en anime favorito: " +ex.getMessage());
        }
    }
    public static void  removerFavAnime(String nickname,String anime){
        String sql = "DELETE FROM clientefavanime WHERE clientefavanime.anime='"+anime+"' and clientefavanime.nickname='"+nickname+"'";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de borrado anime favorito: " +ex.getMessage());
        }
    }
    public static void  insertarUsuario(String nickname, String correo, String pass,Boolean escliente){
        String sql = "INSERT INTO usuario (nickname,correo,pass,escliente) VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nickname); 
            pst.setString(2, correo); 
            pst.setString(3, pass); 
            pst.setBoolean(4, escliente);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en insercion en usuario: " +ex.getMessage());
        }
    }
    public static void  insertarPackCliente(String cliente, String propietario, String nombrepack){
        String sql = "INSERT INTO packcliente (cliente,propietario,nombrepack) VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente); 
            pst.setString(2, propietario); 
            pst.setString(3, nombrepack); 
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en insercion en packcliente: " +ex.getMessage());
        }
    }
    public static void insertarAnime(Collection<String> generos,String nombre,String descripcion,String link,Integer capitulos,Integer imagen){
        String sql = "INSERT INTO anime (nombre,descripcion,link,capitulos,imagen) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre); 
            pst.setString(2, descripcion); 
            pst.setString(3, link); 
            pst.setInt(4, capitulos);
            pst.setInt(5, imagen);
            int n= pst.executeUpdate();
            sql = "INSERT INTO generosanime (nombre,anime) VALUES(?,?)";
            for(String gen: generos){
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, gen); 
                    pst.setString(2, nombre); 
                    n= pst.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Error en insercion en generosanime: " +ex.getMessage());
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en insercion en anime: " +ex.getMessage());
        }
    }
    public static void insertarPack(Collection<Integer> imagenes,String nombre,String propietario){
        String sql = "INSERT INTO pack (nombre,propietario,imagen) VALUES(?,?,?)";
        for(Integer im: imagenes){
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, nombre);
                pst.setString(2, propietario);
                pst.setInt(3, im);
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error en insercion en pack: " +ex.getMessage());
            }
        }
    }
    
    public static void insertarCalidad(Collection<Integer> imgsIdent,String calidad,String anime){
        String sql = "INSERT INTO calidad (anime,calidad) VALUES(?,?)";
        int n;
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, anime); 
            pst.setString(2, calidad); 
            n= pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("Error en insercion en calidad: " +ex.getMessage());
        }
        sql = "INSERT INTO calidadimagen (anime,calidad,identificador) VALUES(?,?,?)";
            for(Integer identificador: imgsIdent){
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, anime); 
                    pst.setString(2, calidad); 
                    pst.setInt(3, identificador);
                    n= pst.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Error en insercion en calidadimagen: " +ex.getMessage());
                }
            }
    }
    public static void  insertarImagen(int identificador,String desc,ByteArrayInputStream  img,boolean miniatura){        
        String tabla = null;
        if(miniatura){
            tabla = "miniaturas";
        }else{
            tabla = "imagenes";
        }
        String sql = "INSERT INTO "+tabla+" (identificador,descripcion,imagen) VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, identificador);
            pst.setString(2, desc); 
            pst.setBlob(3, img);
            int n= pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en insercion en "+tabla+": " +ex.getMessage());
        }
    }
    public static DataImagen getDataImagen(int identificador,boolean miniatura){
        String tabla = null;
        if(miniatura){
            tabla = "miniaturas";
        }else{
            tabla = "imagenes";
        }
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE identificador = '"+Integer.toString(identificador)+"'";
            ResultSet resS = statement.executeQuery(sql);
            resS.next();
            String desc = resS.getString(2);
            ByteArrayInputStream img = null;
            img = (ByteArrayInputStream) resS.getBlob(3).getBinaryStream();
            byte[] array = new byte[img.available()];
            img.read(array);
            return new DataImagen(identificador,array,desc);
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    public static Collection<DataImagen> getDataImagenes(Collection<Integer> identsCol,boolean miniatura){
        String tabla = null;
        if(miniatura){
            tabla = "miniaturas";
        }else{
            tabla = "imagenes";
        }
        try {
            Statement statement = con.createStatement();
            String where = "";
            for(Integer identificador: identsCol){
                where = where +" OR " + "identificador = '"+Integer.toString(identificador)+"'";
            }
            where = where.substring(4);
            String sql = "SELECT * FROM "+tabla+" WHERE "+where;
            ResultSet resS = statement.executeQuery(sql);
            
            Collection<DataImagen> ret = new HashSet();
            while(resS.next()){
                Integer identificador = resS.getInt(1);
                String desc = resS.getString(2);
                ByteArrayInputStream img = null;
                img = (ByteArrayInputStream) resS.getBlob(3).getBinaryStream();
                byte[] array = new byte[img.available()];
                img.read(array);
                DataImagen dtim =  new DataImagen(identificador,array,desc);
                ret.add(dtim);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    public static Map<Integer,DataImagen> getDataImagenesMap(Collection<Integer> identsCol,boolean miniatura){
        String tabla = null;
        if(miniatura){
            tabla = "miniaturas";
        }else{
            tabla = "imagenes";
        }
        try {
            Statement statement = con.createStatement();
            String where = "";
            for(Integer identificador: identsCol){
                where = where +" OR " + "identificador = '"+Integer.toString(identificador)+"'";
            }
            where = where.substring(4);
            String sql = "SELECT * FROM "+tabla+" WHERE "+where;
            ResultSet resS = statement.executeQuery(sql);
            
            Map<Integer,DataImagen> ret = new HashMap();
            while(resS.next()){
                Integer identificador = resS.getInt(1);
                String desc = resS.getString(2);
                ByteArrayInputStream img = null;
                img = (ByteArrayInputStream) resS.getBlob(3).getBinaryStream();
                byte[] array = new byte[img.available()];
                img.read(array);
                DataImagen dtim =  new DataImagen(identificador,array,desc);
                ret.put(identificador, dtim);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    public static Collection<DataAnimeImNom> listarAnimes(){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT anime.nombre,miniaturas.imagen,miniaturas.identificador FROM anime JOIN miniaturas ON anime.imagen=miniaturas.identificador";
            ResultSet resS = statement.executeQuery(sql);
            
            Collection<DataAnimeImNom>  ret = new HashSet();
            while(resS.next()){
                String anime = resS.getString(1);
                Integer identificador = resS.getInt(3);
                ByteArrayInputStream img = null;
                img = (ByteArrayInputStream) resS.getBlob(2).getBinaryStream();
                byte[] array = new byte[img.available()];
                img.read(array);
                DataAnimeImNom dtim =  new DataAnimeImNom(anime,new DataImagen(identificador,array,null));
                ret.add(dtim);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    public static Collection<String> getGenerosAsociados(String anime){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT generosanime.nombre FROM generosanime WHERE generosanime.anime='"+anime+"' ";
            ResultSet resS = statement.executeQuery(sql);
            
            Collection<String> ret = new HashSet();
            while(resS.next()){
                String gen = resS.getString(1);
                ret.add(gen);                
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static Map<String, DataCalidad> getCalidadesAsociadas(String anime){//MAL ESTO,REVISAR
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT calidadimagen.calidad, calidadimagen.identificador,miniaturas.descripcion, miniaturas.imagen FROM calidadimagen JOIN miniaturas ON calidadimagen.anime='"+anime+"' and miniaturas.identificador=calidadimagen.identificador   ";
            ResultSet resS = statement.executeQuery(sql);
            
            Map<String, DataCalidad>   ret = new HashMap();
            while(resS.next()){
                String cali = resS.getString(1);
                Integer identificador = resS.getInt(2);
                String desc = resS.getString(3);
                
                ByteArrayInputStream img = null;
                img = (ByteArrayInputStream) resS.getBlob(4).getBinaryStream();
                byte[] array = new byte[img.available()];
                img.read(array);
                DataImagen dtim =new DataImagen(identificador,array,desc);
                
                DataCalidad dcal = ret.get(cali);
                if(dcal ==null){
                    dcal = new DataCalidad(null,cali,anime);
                    ret.put(cali, dcal);
                }
                Map<Integer,DataImagen>  colImCali = dcal.getImgs();
                colImCali.put(identificador, dtim);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    public static DataAnime detalleAnime(String anime){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT anime.descripcion,anime.link,anime.capitulos,miniaturas.imagen,miniaturas.identificador FROM anime JOIN miniaturas ON anime.nombre='"+anime+"' and anime.imagen=miniaturas.identificador";
            ResultSet resS = statement.executeQuery(sql);
            
            DataAnime  ret = null;
            if(resS.next()){
                String desc = resS.getString(1);
                String link = resS.getString(2);
                Integer capitulos = resS.getInt(3);
                Integer identificador = resS.getInt(5);
                ByteArrayInputStream img = null;
                img = (ByteArrayInputStream) resS.getBlob(4).getBinaryStream();
                byte[] array = new byte[img.available()];
                img.read(array);
                DataImagen dtim =new DataImagen(identificador,array,null);
                
                Map<String, DataCalidad> calidades = getCalidadesAsociadas(anime);
                Collection<String> generos=getGenerosAsociados(anime);
                
                ret = new DataAnime(generos,anime,desc,link,capitulos,calidades,dtim);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    public static Collection<String> listarGeneros(){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT generos.nombre FROM generos";
            ResultSet resS = statement.executeQuery(sql);
            
            Collection<String> ret = new HashSet();
            while(resS.next()){
                String gen = resS.getString(1);
                ret.add(gen);                
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static Collection<String> listarUsuarios(){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT usuario.nickname FROM usuario";
            ResultSet resS = statement.executeQuery(sql);
            
            Collection<String> ret = new HashSet();
            while(resS.next()){
                String usr = resS.getString(1);
                ret.add(usr);                
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static Usuario getUsuario(String nickOCorreo){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM usuario WHERE usuario.nickname='"+nickOCorreo+"' or usuario.correo='"+nickOCorreo+"'";
            ResultSet resS = statement.executeQuery(sql);
            Usuario ret = null;
            if(resS.next()){
                String nick = resS.getString(1);
                String correo = resS.getString(2);
                String pass = resS.getString(3);
                Boolean escliente = resS.getBoolean(4);
                if(escliente){
                    ret = new Cliente(nick,correo,pass);
                }else{
                    ret = new Admin(nick,correo,pass);
                }
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static DataGeneroReducido detalleGenero(String gen){ //RECIEN EMPEZANDO
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT generosanime.anime,miniaturas.imagen,miniaturas.identificador,miniaturas.descripcion FROM generosanime JOIN anime ON generosanime.nombre='"+gen+"' and generosanime.anime=anime.nombre JOIN miniaturas ON miniaturas.identificador=anime.imagen";
            ResultSet resS = statement.executeQuery(sql);
            
            Map<String,DataAnimeImNom> aux = new HashMap();
            while(resS.next()){
                String anime = resS.getString(1);
                Integer identificador = resS.getInt(3);
                String desc = resS.getString(4);
                
                ByteArrayInputStream img = null;
                img = (ByteArrayInputStream) resS.getBlob(2).getBinaryStream();
                byte[] array = new byte[img.available()];
                img.read(array);
                DataImagen dtim =new DataImagen(identificador,array,desc);
                
                aux.put(anime, new DataAnimeImNom(anime,dtim));
            }
            
            
            statement = con.createStatement();
            sql = "SELECT generos.descripcion FROM generos WHERE generos.nombre='"+gen+"'";
            resS = statement.executeQuery(sql);
            resS.next();
            String descripcion = resS.getString(1);
            
            return new DataGeneroReducido(aux,gen,descripcion);
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en casteo: " +ex.getMessage());
        }
        return null;
    }
    
    public static Map<String,Pack> getPacks(String cliente){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT packcliente.propietario, packcliente.nombrepack, pack.imagen FROM packcliente JOIN pack ON  packcliente.cliente='"+cliente+"' and packcliente.propietario=pack.propietario and packcliente.nombrepack = pack.nombre ";
            ResultSet resS = statement.executeQuery(sql);
            Map<String,Pack> ret = new HashMap();
            while(resS.next()){
                String propietario = resS.getString(1);
                String nomPack = resS.getString(2);
                Integer imagen = resS.getInt(3);
                
                String key = nomPack+"&"+propietario;
                Pack pack = ret.get(key);
                if(pack == null){
                    pack = new Pack(new HashSet(),nomPack,getUsuario(propietario));
                    ret.put(key, pack);
                }
                pack.getImgs().add(imagen);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static Pack getPack(String nombre, String propietario){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT pack.imagen FROM pack WHERE  pack.nombre='"+nombre+"' and pack.propietario='"+propietario+"'";
            ResultSet resS = statement.executeQuery(sql);
            Collection<Integer> imagenes = new HashSet();
            Pack ret = new Pack(imagenes,nombre,getUsuario(propietario));
            while(resS.next()){
                Integer imagen = resS.getInt(1);
                imagenes.add(imagen);
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
        public static Collection<Pack> listarPacks() {
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM pack";
            ResultSet resS = statement.executeQuery(sql);
            
            Map<String,Pack> ret = new HashMap();           
            
            while(resS.next()){
                String nombre = resS.getString(1);
                String propietario = resS.getString(2);
                Integer imagen = resS.getInt(3);
                
                Collection<Integer> imagenes = null;
                
                Pack pack = ret.get(nombre+"&"+propietario);
                if(pack==null){
                    imagenes = new HashSet();
                    pack = new Pack(imagenes,nombre,getUsuario(propietario));
                    ret.put(nombre+"&"+propietario, pack);
                }else{
                    imagenes = pack.getImgs();
                }
                imagenes.add(imagen);
            }
            return ret.values();
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static Collection<DataFavorito> getDataFavoritoAnime(String nick){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT clientefavanime.anime FROM clientefavanime WHERE  clientefavanime.nickname='"+nick+"'";
            ResultSet resS = statement.executeQuery(sql);
            Collection<DataFavorito> ret = new HashSet();
            while(resS.next()){
                String anime = resS.getString(1);
                ret.add( new DataAnime(null,anime,null,null,null,null,null));
            }
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
    public static Integer getIdentImg(){
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT Max(identificador) AS maxident FROM imagenes";
            ResultSet resS = statement.executeQuery(sql);
            resS.next();
            Integer ret = resS.getInt("maxident");            
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
        }
        return null;
    }
        

}
