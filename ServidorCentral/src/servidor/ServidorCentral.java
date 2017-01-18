/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import Clases.Imagen;
import dataType.DataAnime;
import dataType.DataCalidad;
import dataType.DataGenero;
import dataType.DataImagen;
import interfaz.IAnime;
import interfaz.fabrica;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        
        nombre="Colegial";
        descripcion = "Es un subgénero que consiste en que la historia se desarrolle en una escuela o secundaria";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        nombre="Cosas de la vida";
        descripcion = " es conocido por tener historias donde se centra más en los personajes que en la historia en general, y se tocan temas como la vida cotidiana de los personajes y sus problemas de todos los días.  Este tipo de animes también tienen elementos de romance y comedia para hacer de las series mucho más entretenidas";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Accion";
        descripcion = "Es un género cinematográfico en el que prima la espectacularidad de las imágenes";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Thriller";
        descripcion = "Es un género cuyo objetivo principal es mantener generalmente en un estado de tensión, de lo que pueda ocurrirle a los personajes y, por lo tanto, atento al desarrollo";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Seinen";
        descripcion = "El objetivo es atraer a una audiencia masculina mayor de 16 años. Como tal, este tipo de anime tiende a ser mucho más sofisticado que el anime y manga shōnen. Algunos temas frecuentes en las tramas son la violencia y la política.";
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
        
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
        nombre="Shonen";
        descripcion = "";
        interAnime.addGenero(new DataGenero(null,nombre,descripcion));
        
        
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
        
        nombre = "Watamote";
        link = "http://jkanime.net/watashi-ga-motenai-no-wa-dou-kangaetemo-omaera-ga-warui/";
        desc = "Kuroki Tomoko, una chica que tiene \"50 años de experiencia\" en citas y que ha salido con más de un centenar de chicos… en juegos otome.\n" +
"\n" +
"En la vida real acaba de cumplir 15 años y va a dar comienzo su época en el instituto, está convencida de que con sus conocimientos será la más de popular. Una vez comienza el instituto, comienzan a pasar los días y se da cuenta de que no habla con nadie. ¿Cómo es posible? Un simple vistazo al espejo le hace darse cuenta de la realidad: no es precisamente una belleza y parece que hasta puede ser antipática.\n" +
"\n" +
"Poco a poco intentará cambiar para ser popular, pero claro, entre lo que le cuesta y lo que tiene una idea bastante distorsionada de la realidad, no será tan sencillo.";
        capitulos = 12;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Colegial");
        generos.add("Shonen");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
        
        nombre = "Toradora";
        link = "http://jkanime.net/toradora/";
        desc = "Takasu Ryuuji comienza su segundo año de instituto con mucho animo. Sin embargo, hay una cosa que el odia, y es su mirada, heredada de su padre (un ganster), con lo cual posee una habilidad innata para intimidar a los demás, provocándole esto muchos malentendidos con sus compañeros, no obstante, todo esto va cambiar el primer día de clases, cuando Ryuuji tiene un encontronazo con Aisaka Taiga, la persona mas peligrosa del centro.";
        capitulos = 25;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Romance");
        generos.add("Colegial");
        generos.add("Cosas de la vida");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
        
        
        nombre = "Requiem for the Phantom";
        link = "http://jkanime.net/requiem-for-the-phantom/";
        desc = "La mafía americana, una de las más poderosas del mundo ceden ante el temor de una organización llamada INFERNO, no por su poder económico ni tampoco por su influencia mundial, sino por sus creaciones,asesinos a sangre fría y con habilidades sobre-humanas. Agatsuma Reiji llega a America para encontrarse con un familiar y presencia un asesinato brutal donde él es el único testigo de ese hecho. Más tarde es capturado por una de las más hábiles asesinas de la organización INFERNO, Phantom.Poco después es llevado a los laboratorios de INFERNO y es víctima de un lavado de cerebro.Al despertar,no recuerda nada,sin embargo,se da cuenta que poseé ciertas \"habilidades\".";
        capitulos = 26;
        
        generos=new HashSet();
        generos.add("Drama");
        generos.add("Accion");
        generos.add("Thriller");
        generos.add("Seinen");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
                
                
        nombre = "Oreimo";
        link = "http://jkanime.net/ore-no-imouto-ga-konnani-kawaii-wake-ga-nai/";
        desc = "Nos cuenta la historia de Kyousuke Kousaka un estudiante de 17 años que cursa la preparatoria, tiene una hermana menor de 14 años quien es estudiante de secundaria, ademas es una modelo teen muy popular y que siempre lo ignora y rechaza como hermano sin llevarse nada bien llamada Kirino. Ore No Imouto Ga Konnani Kawaii Wake Ga Nai escrita por Tsukasa Fushimi y que llegará a estrenarse para octubre del 2010 viniendo a manos de la empresa Aniplex, trata mas que todo sobre como se relacionan estás dos personas luego de que un dia Kyousuke encuentra en el cuarto de su hermana por casualidad un dvd de Anime, pero lo mas interezante es que junto con ese dvd venía un juego eroge(erótico) llamado Imouto to Koishiyo(amor con la pequeña hermana) descubriendo así que su hermana Kirino es una otaku fanatica a muerte de los juegos para adultos y todo lo que esto conlleva haciendo mas difícil de lo que ya es la vida Kyosuke debido a todas las travesuras de su hermana. Un nuevo título con bastante Ecchi recomendado ya que el manga de la serie tuvo mucho exito y esperemos ocurra lo mismo con la serie.";
        capitulos = 32;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Cosas de la vida");
        generos.add("Seinen");
        
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
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
                
                
        nombre = "";
        link = "";
        desc = "";
        capitulos = 12;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Misterio");
        generos.add("Shonen");
        generos.add("Sobrenatural");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
                
                
        nombre = "";
        link = "";
        desc = "";
        capitulos = 12;
        
        generos=new HashSet();
        generos.add("Comedia");
        generos.add("Misterio");
        generos.add("Shonen");
        generos.add("Sobrenatural");
        
        interAnime.addAnime(cargarAnimeAux(generos,nombre,link,desc,capitulos));
                
                
                
                */
        
        
        
    }
    static public Imagen redimencion(Imagen img){
        BufferedImage toResize = ServidorCentral.byteToBuff(img.getImag());
        toResize = ServidorCentral.resize(toResize, 400, 400);
        byte[] miniatura = ServidorCentral.buffTobyte(toResize);
        Imagen imMini = new Imagen(img.getIdentificador(),miniatura,null);
        return imMini;
    }
    static public DataAnime cargarAnimeAux(Collection<String> generos,String nombre,String link,String descrip,int capitulos){
        
        if(prefix==null){
            try {
                 prefix = new File(".").getCanonicalPath()+"/boot/";
            } catch (Exception ex) {}
        }
        String prefijoImagenes = prefix +"imagenes/";
        String anime = prefijoImagenes+nombre+"/";
        String pathIm=null;
        int identif=-1;
        
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
                pathIm = pathCali+nomIm;
                identif = Integer.parseInt(nomIm.split("\\.")[0]);
                dtim = new DataImagen(identif,getFile(pathIm),null);
                imgs.put(identif,dtim);                
            }
            DataCalidad dcal = new DataCalidad(imgs,calidad,nombre);
            calidades.put(calidad, dcal);
        }
        File toIm = new File(pathIm);
        BufferedImage img = null;
        try {
            img= ImageIO.read(toIm);
        } catch (IOException ex) {}
        img= resize(img,500,500);
        dtim = new DataImagen(identif,buffTobyte(img),null);
        DataAnime ret = new DataAnime(generos,nombre,descrip,link,capitulos,calidades,dtim);        
        return ret;
    }
    static public byte[] buffTobyte(BufferedImage img){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "jpg", baos);
        } catch (IOException ex) {}
        return baos.toByteArray();
    }
    static public BufferedImage byteToBuff(byte[] imageInByte){
        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bImageFromConvert = null;
        try {
            bImageFromConvert = ImageIO.read(in);
        } catch (IOException ex) {
        }
        return bImageFromConvert;
    }
    static public byte[] getFile(String name){
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
    static public void organizarImagenes(){
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
    static public BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage imagenRedimensionada = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = imagenRedimensionada.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return imagenRedimensionada;
    }
}
