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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataImagen{
    private Integer identificador;
    private Byte[] imag;
    private String Descripcion;

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public void setImag(Byte[] imag) {
        this.imag = imag;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public DataImagen() {
    }

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
