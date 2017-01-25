/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataImagen;
import dataType.reducidos.DataAnimeImNom;
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
    public static void insertarCalidad(Collection<Integer> imgsIdent,String calidad,String anime){
        String sql = "INSERT INTO calidad (anime,calidad) VALUES(?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, anime); 
            pst.setString(2, calidad); 
            int n= pst.executeUpdate();
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
            
        } catch (SQLException ex) {
            System.out.println("Error en insercion en calidad: " +ex.getMessage());
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
        return null;
    }
    public static Map<String, DataCalidad> getCalidadesAsociadas(String anime){//MAL ESTO,REVISAR
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT calidadimagen.identificador FROM calidadimagen WHERE calidadimagen.anime='"+anime+"' ";
            ResultSet resS = statement.executeQuery(sql);
            
            Map<String, DataCalidad>   ret = new HashMap();
            Collection<Integer> identsCol = new HashSet();
            while(resS.next()){
                Integer ident = resS.getInt(1);
                 identsCol.add(ident);
                
            }
            Collection<DataImagen>  col = getDataImagenes(identsCol,true);
            return ret;
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " +ex.getMessage());
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
}
