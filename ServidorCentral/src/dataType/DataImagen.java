/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

/**
 *
 * @author Jonathan
 */
public class DataImagen{
    private Integer identificador;
    private Byte[] imag;
    private String Descripcion;

    public DataImagen(Integer identificador, Byte[] imag, String Descripcion) {
        this.identificador = identificador;
        this.imag = imag;
        this.Descripcion = Descripcion;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public Byte[] getImag() {
        return imag;
    }

    public String getDescripcion() {
        return Descripcion;
    }
    
    
}
