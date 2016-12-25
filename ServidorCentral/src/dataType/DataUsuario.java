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
public class DataUsuario {
    private String nickname;
    private String correo;

    public String getNickname() {
        return nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public DataUsuario(String nickname, String correo) {
        this.nickname = nickname;
        this.correo = correo;
    }
}
