/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataType;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataAnime extends DataFavorito {
    
    private Collection<String> generos;
    private String nombre,descripcion,link;
    private Integer capitulos;
    private Map<String,DataCalidad> calidades;
    private DataImagen imagen;

    public DataAnime() {
    }

    public void setGeneros(Collection<String> generos) {
        this.generos = generos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCapitulos(Integer capitulos) {
        this.capitulos = capitulos;
    }

    public void setCalidades(Map<String, DataCalidad> calidades) {
        this.calidades = calidades;
    }

    public void setImagen(DataImagen imagen) {
        this.imagen = imagen;
    }

    public DataAnime(Collection<String> generos, String nombre, String descripcion, String link, Integer capitulos, Map<String, DataCalidad> calidades,DataImagen im) {
        this.generos = generos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.capitulos = capitulos;
        this.calidades = calidades;
        this.imagen = im;
    }

    public DataImagen getImagen() {
        return imagen;
    }

    public Collection<String> getGeneros() {
        return generos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }

    public Integer getCapitulos() {
        return capitulos;
    }

    public Map<String, DataCalidad> getCalidades() {
        return calidades;
    }
    
    
}
