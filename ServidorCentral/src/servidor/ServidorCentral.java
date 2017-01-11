/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataGenero;
import dataType.DataImagen;
import interfaz.IAnime;
import interfaz.fabrica;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
        cargarAnimes();
        Publicador p = new Publicador();
        p.publicar();
    }
    static public String getResolucion(BufferedImage img){
        return Integer.toString(img.getWidth())+"x"+Integer.toString(img.getHeight());
    }
    static private void cargarGeneros(){
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
        
        nombre="Misterio";
        descripcion = "Es un género típicamente enfocado en la investigación de un crimen";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Harem";
        descripcion = "Es caracterizado por un hombre generalmente sin muchos talentos, rodeado por mujeres muy alocadas y distintas entre sí y comúnmente viviendo juntos.";
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
    static private void cargarAnimes(){
        organizarImagenes();
        cargarGeneros();
        Collection<String> generos;
        String nombre,link,desc;
        int capitulos;
        IAnime interAnime = fabrica.getInstance().getIAnime();
        
        nombre = "Inu x Boku SS";
        link = "http://jkanime.net/inu-x-boku-ss/";
        desc = "La historia tiene por protagonista a Ririchou Shirakiin, hija de la casa Shirakiin y que se siente acomplejada por no poder vivir por su propia cuenta y sin protección, con lo que decide irse a vivir sola bajo la condición de vivir en la mansión “Ayakashi Kan“. En la mansión sólo pueden residir aquellos que han pasado por un duro examen, y cada uno de sus residentes está acompañado por un agente del Servicio Secreto. Aunque Riricho ha rechazado la idea de tener un agente detrás, descubrirá estando en la mansión que en realidad el agente que la protege es el espíritu de un zorro al que ella había salvado anteriormente.";
        capitulos = 12;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Misterio");
        generos.add("Shonen");
        generos.add("Sobrenatural");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
        
        nombre = "Kami nomi zo Shiru Sekai";
        link = "http://jkanime.net/kami-nomi-zo-shiru-sekai/";
        desc = "Katsuragi Keima, un estudiante de segundo año de secundaria, ávido jugador de Galges. En Internet es conocido como \"Dios Caído\", por sus legendarias habilidades para \"capturar\" cualquier chica 2D en los juegos. Keima recibe un e-mail ofreciendole un contrato para \"capturar\" chicas. El acepta tomandolo como si fuera un reto, y una demonio del infierno apodada Elsee aparece. Ella le pide su cooperación para ayudarla en la captura de los espíritus profugos. Estos espíritus se ocultan dentro del corazón de las chicas, por lo que Elsee le sugiere que el único método para obligar a los espíritus a salir es \"capturar\" sus corazones haciéndolas que se enamoren. Horrorizado por la idea, Keima se niega luego de aclarar a Elsee que él sólo está interesado en \"capturar\" las chicas 2D y que aborrece la realidad. Sin embargo, con el contrato ya aceptado, Keima tendra que ayudar a Elsee; ya que ambos podrían perder sus cabezas si no lo obedecen.";
        capitulos = 36;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Misterio");
        generos.add("Shonen");
        generos.add("Sobrenatural");
        generos.add("Romance");
        generos.add("Harem");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
        /*
        nombre = "";
        link = "";
        desc = "";
        capitulos = 12;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Misterio");
        generos.add("Shonen");
        generos.add("Sobrenatural");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));*/
        
        
        
    }
    static private DataAnime cargarAnimeAux(Collection<String> generos,String nombre,String link,String descrip,int capitulos){
        
        if(prefix==null){
            try {
                 prefix = new File(".").getCanonicalPath()+"/boot/";
            } catch (Exception ex) {}
        }
        String prefijoImagenes = prefix +"imagenes/";
        String anime = prefijoImagenes+nombre+"/";
        
        DataImagen dtim = null;
        File folder = new File(anime);
        String[] listOfFiles = folder.list();
        Map<String,DataCalidad> calidades = new HashMap();
        for(String calidad: listOfFiles){
            String pathCali = anime+calidad+"/";
            File folderCali = new File(pathCali);
            String[] listaImagenes = folderCali.list();
            Map<Integer,DataImagen> imgs = new HashMap();
            for(String nomIm :listaImagenes){
                int identif = Integer.parseInt(nomIm.split("\\.")[0]);
                dtim = new DataImagen(identif,getFile(pathCali+nomIm),null);
                imgs.put(identif,dtim);                
            }
            DataCalidad dcal = new DataCalidad(imgs,calidad,nombre);
            calidades.put(calidad, dcal);
        }
        DataAnime ret = new DataAnime(generos,nombre,descrip,link,capitulos,calidades,dtim);        
        return ret;
    }
    static private byte[] getFile(String name){
        byte[] byteArray = null;
        try {
                File f = new File(name);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
        }
        return byteArray;
    }
    static private void organizarImagenes(){
        BufferedImage img = null;
        try {
            if(prefix==null){
                try {
                     prefix = new File(".").getCanonicalPath()+"/boot/";
                } catch (Exception ex) {}
               
            }
            String prefijoImagenes = prefix +"imagenes/";
            File folder = new File(prefijoImagenes);
            String[] listOfFiles = folder.list();
            for (String files : listOfFiles){
                String pathAnime =prefijoImagenes+files+"/";   
                File folder2 = new File(pathAnime);
                String[] listOfFiles2 = folder2.list();
                for ( String files2: listOfFiles2){
                    
                    String pathImg = pathAnime + files2;
                    File toIm = new File(pathImg);
                    if(toIm.isFile()){
                        img = ImageIO.read(toIm);
                        String resolucion = getResolucion(img);
                        File folder3 = new File(pathAnime+resolucion+"/");
                        folder3.mkdirs(); 
                        Integer ident = fabrica.getInstance().getIAnime().getIdentImg();
                        String[] split = files2.split("\\.");
                        String ext = "."+split[split.length-1];
                        File outputfile = new File(pathAnime+resolucion+"/"+Integer.toString(ident)+ext);
                        ImageIO.write(img, "png", outputfile);
                        toIm.delete();
                    }
                                           
                }
            }
        
            
            System.out.printf("exito");
        } catch (IOException e) {
            System.out.printf("error");
        }
    }
    
}
