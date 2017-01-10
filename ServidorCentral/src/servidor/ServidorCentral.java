/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Jonathan
 */
public class ServidorCentral {

    /**
     * @param args the command line arguments
     */
    static private String prefix = null;
    
    
    public static void main(String[] args) {
        organizarImagenes();
        Publicador p = new Publicador();
        p.publicar();
    }
    static public String getResolucion(BufferedImage img){
        return Integer.toString(img.getWidth())+"x"+Integer.toString(img.getHeight());
    }
    static public void organizarImagenes(){
        BufferedImage img = null;
        try {
            if(prefix==null){
                try {
                     prefix = new File(".").getCanonicalPath()+"/boot/";
                } catch (Exception ex) {}
               
            }
            
            File folder = new File(prefix);
            String[] listOfFiles = folder.list();
            for (String files : listOfFiles){
                String pathAnime =prefix+files+"/";   
                File folder2 = new File(pathAnime);
                String[] listOfFiles2 = folder2.list();
                for ( String files2: listOfFiles2){
                    
                    String pathImg = pathAnime + files2;
                    File toIm = new File(pathImg);
                    if(toIm.isFile()){
                        img = ImageIO.read(toIm);
                        toIm.delete();
                        String resolucion = getResolucion(img);
                        File folder3 = new File(pathAnime+resolucion+"/");
                        folder3.mkdirs(); 
                        File outputfile = new File(pathAnime+resolucion+"/"+files2);
                        ImageIO.write(img, "png", outputfile);
                    }
                                           
                }
            }
        
            
            System.out.printf("exito");
        } catch (IOException e) {
            System.out.printf("error");
        }
    }
    
}
