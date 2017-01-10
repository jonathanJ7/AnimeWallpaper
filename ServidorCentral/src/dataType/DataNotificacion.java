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
public class DataNotificacion {
    
    private String mensaje,link;

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public DataNotificacion() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getLink() {
        return link;
    }

    public DataNotificacion(String mensaje, String link) {
        this.mensaje = mensaje;
        this.link = link;
    }
}
