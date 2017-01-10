/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.Collection;

/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCollection {
    Collection col;

    public DataCollection(Collection col) {
        this.col = col;
    }

    public DataCollection() {
    }

    public Collection getCol() {
        return col;
    }

    public void setCol(Collection col) {
        this.col = col;
    }
    
    
}
