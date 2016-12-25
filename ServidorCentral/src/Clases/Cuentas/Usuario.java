/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Cuentas;

import dataType.DataUsuario;

/**
 *
 * @author Jonathan
 */
public class Usuario {
    private String nickname;
    private String correo;
    private String pass;

    public DataUsuario toData(){
        return new DataUsuario(nickname,correo);
    }
    
    public Usuario(String nickname, String correo, String pass) {
        this.nickname = nickname;
        this.correo = correo;
        this.pass = pass;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }
    
}
