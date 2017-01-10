/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import dataType.DataAnime;
import dataType.DataGenero;
import interfaz.IAnime;
import interfaz.fabrica;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
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
    static public void cargarGeneros(){
        IAnime interAnime = fabrica.getInstance().getIAnime();
        String nombre =null;
        String descripcion =null;
        
        nombre="Shojo";
        descripcion = "En japonés significa \"joven\" o \"niña\". Estos anime son generalmente dirigidos a las niñas. Ejemplos: Fruits Basket o Mermaid Melody Pichi Pichi Pitch ";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Shonen";
        descripcion = "En japonés significa \"joven\" estos animes van mas dirijidos a los niños. Ejemplos: Dragon Ball Z o Digimon";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Comedia";
        descripcion = "Es el género dramático opuesto a la tragedia y, por tanto, relacionado casi siempre con historias con final feliz.";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Drama";
        descripcion = "Es la representación de algún episodio o conflicto de la vida de los seres humanos por medio del diálogo de los personajes o del monólogo. En el género dramático, el autor lleva el desarrollo de la acción a la escena: los hechos no se relatan, sino que se representan.";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Romance";
        descripcion = "Es un género  que se caracteriza por retratar argumentos construidos de eventos y personajes relacionados con la expresión del amor y las relaciones románticas";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Sobrenatural";
        descripcion = "Es un subgénero de fantasía que combina elementos de Ficción sobrenatural y el género dramático";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        /*
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        */
    }
    static public DataAnime cargarAnimeAux(String nombre,Collection<String> generos){
        return null;
        
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
