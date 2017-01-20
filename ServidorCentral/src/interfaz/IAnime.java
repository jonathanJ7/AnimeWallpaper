/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dataType.DataAnime;
import dataType.DataGenero;
import dataType.DataPack;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import dataType.reducidos.DataPackReducido;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
 public interface IAnime {
    
    Collection<DataAnimeImNom> listarAnimes();
    DataAnime detalleAnime(String anime);
    
    Collection<String> listarGeneros();
    DataGeneroReducido detalleGenero(String gen);
    
    void addAnime(DataAnime dtanime);
    void modAnime(DataAnime dtanime,String nombre);
    
    void addGenero(DataGenero dtgen);
    void modGenero(String nombre,String nuevoNom,String desc);
    
    Collection<DataPackReducido> listarPacks();
    DataPack detallePack(String nombre,String propietario);
    
    Integer getIdentImg();
    byte[] getImagen(int identificador);
    
}
