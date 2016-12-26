/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Cuentas;

import dataType.DataNotificacion;

/**
 *
 * @author Jonathan
 */
public class Notificacion {
    private String mensaje,link;
    
    public DataNotificacion toData(){
        return new DataNotificacion(mensaje,link);
    }

    public Notificacion(String mensaje, String link) {
        this.mensaje = mensaje;
        this.link = link;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getLink() {
        return link;
    }
    
}
