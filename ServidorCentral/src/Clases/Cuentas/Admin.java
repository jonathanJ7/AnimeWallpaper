/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Cuentas;

import dataBase.operaciones;
import dataType.DataAdmin;
import dataType.DataUsuario;

/**
 *
 * @author Jonathan
 */
public class Admin extends Usuario{
    
    public Admin(String nickname, String correo, String pass) {
        super(nickname, correo, pass);
    }
    public DataUsuario toData(){
        return new DataAdmin(this.getNickname(), this.getCorreo());
    }
    public void persistir(){
        operaciones.insertarUsuario(this.getNickname(), this.getCorreo(), this.getPass(), false);
    }
}
