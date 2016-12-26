/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Cuentas.Favorito;
import dataType.DataImagen;

/**
 *
 * @author Jonathan
 */
public class Imagen extends Favorito{
    private Integer identificador;
    private Byte[] imag;
    private String Descripcion;

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public DataImagen toData(){
        return new DataImagen(identificador,imag,Descripcion);
    }
    

    public Imagen(Integer identificador, Byte[] imag, String Descripcion) {
        this.identificador = identificador;
        this.imag = imag;
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public Imagen(Integer identificador, Byte[] imag) {
        this.identificador = identificador;
        this.imag = imag;
    }
    static public Imagen descargar(String url){
        return null;//VER
    }
    public void setImag(Byte[] imag) {
        this.imag = imag;
    }

    public Byte[] getImag() {
        return imag;
    }

    public Integer getIdentificador() {
        return identificador;
    }
    
}
