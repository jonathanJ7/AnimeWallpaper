/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
public class Pack {
    private Map<Integer,Imagen> colIm;
    private String nombre;
    private Usuario propietario;

    public Pack(Map<Integer,Imagen> colIm, String nombre, Usuario propietario) {
        this.nombre = nombre;
        this.propietario = propietario;
        if(colIm == null){
            this.colIm = new HashMap();
        }else{            
            this.colIm = colIm;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public Map<Integer,Imagen> getColIm() {
        return colIm;
    }
    public void add(Imagen imag){
        colIm.put(imag.getIdentificador(),imag);
    }
    public void remove(Integer id){        
        colIm.remove(id);
    }
    
}
