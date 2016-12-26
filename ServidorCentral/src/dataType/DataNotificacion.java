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
public class DataNotificacion {
    
    private String mensaje,link;

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
