/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Controladores.CtrlAnime;
import Controladores.CtrlUsr;

/**
 *
 * @author Jonathan
 */
public class fabrica {

    static public fabrica instance =null;
    private fabrica() {
    }
    static public fabrica getInstance(){
        if (instance==null){
            instance= new fabrica();
        }
        return instance;
    }
    public IAnime getIAnime(){
        return CtrlAnime.getInstance();
    }
    public IUsr getIUsr(){
        return CtrlUsr.getInstance();
    }
    
}
