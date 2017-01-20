/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import dataType.DataImagen;
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
            if(n>0){
                System.out.println("Insercion exitosa");
            }
        } catch (SQLException ex) {
            System.out.println("Error en insercion: " +ex.getMessage());
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
}
