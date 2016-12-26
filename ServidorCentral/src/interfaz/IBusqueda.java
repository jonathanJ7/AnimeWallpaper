/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dataType.DataCalidad;
import dataType.reducidos.DataAnimeImNom;
import dataType.reducidos.DataGeneroReducido;
import dataType.reducidos.DataPackReducido;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
abstract public class IBusqueda {
    abstract Collection<DataAnimeImNom> buscarAnime(String anime);
    abstract Collection<DataCalidad> buscarCalidad(String anime,String calidadMin,String calidadMax,Boolean horizontal);
    abstract Collection<DataGeneroReducido> buscarGenero(String nombre);
    abstract Collection<DataPackReducido> buscarPack(String nombre,String propietario);
    
}
