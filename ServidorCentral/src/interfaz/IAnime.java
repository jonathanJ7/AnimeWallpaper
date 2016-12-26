/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dataType.DataAnime;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
abstract public class IAnime {
    
    abstract Collection<DataAnimeImNom> listarAnimes();
    abstract DataAnime detalleAnime(String anime);
    
    abstract Collection<String> listarGeneros();
    abstract DataGeneroReducido detalleGenero(String gen);
    
    abstract void addAnime(DataAnime dtanime);
    abstract void modAnime(DataAnime dtanime);
    
}
