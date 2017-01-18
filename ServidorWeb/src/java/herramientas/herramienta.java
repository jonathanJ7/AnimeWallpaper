/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import servidor.DataCollection;
import servidor.DataGenero.Animes.Entry;
import servidor.DataMap;

/**
 *
 * @author Jonathan
 */
public class herramienta{
    static public Map pasarAMap(DataMap mapa){
        Map ret = new HashMap();
        for (Object ob : mapa.getMapa().getEntry()){
            DataMap.Mapa.Entry ent = (DataMap.Mapa.Entry) ob;
            ret.put(ent.getKey(),ent.getValue());
        }
        return ret;
    }   
    static public Collection pasarACol(DataCollection col){
        Collection ret = new HashSet();
        for (Object ob : col.getCol()){
            ret.add(ob);
        }
        return ret;
    }
}
