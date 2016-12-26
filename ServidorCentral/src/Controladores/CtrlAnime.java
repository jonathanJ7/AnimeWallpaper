/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Anime;
import Clases.Genero;
import dataType.DataAnime;
import dataType.DataGenero;
import dataType.DataPack;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import dataType.reducidos.DataPackReducido;
import interfaz.IAnime;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class CtrlAnime extends IAnime{
    Map<String,Genero> generos;
    Map<String,Anime> animes;

    Collection<DataAnimeImNom> listarAnimes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    DataAnime detalleAnime(String anime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    Collection<String> listarGeneros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    DataGeneroReducido detalleGenero(String gen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    void addAnime(DataAnime dtanime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    void modAnime(DataAnime dtanime, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    void addGenero(DataGenero dtgen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    void modGenero(DataGenero dtgen, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    Collection<DataPackReducido> listarPacks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    DataPack detallePack(String nombre, String propietario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
