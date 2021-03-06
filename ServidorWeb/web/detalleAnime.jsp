<%-- 
    Document   : home
    Created on : 10-ene-2017, 23:44:40
    Author     : Jonathan
--%>

<%@page import="servidor.DataFavorito"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="servidor.DataCalidad"%>
<%@page import="servidor.DataImagen"%>
<%@page import="servidor.DataAnime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
             /*OVERLAY*/       
                    
            .container {
              position: relative;
              width: 25%;
              height: 250px;
              float: left;
              cursor: pointer;
            }

            .image {
              display: block;
              width: 100%;
              height: 100%;
            }

            .overlay {
              position: absolute;
              bottom: 100%;
              left: 0;
              right: 0;
              background-color: black;
              opacity: 0.7;
              overflow: hidden;
              width: 100%;
              height:0;
              transition: .2s ease;
            }

            .container:hover .overlay {
              bottom: 0;
              height: 100%;
            }

            .text {
              white-space: nowrap; 
              color: white;
              font-size: 20px;
              position: absolute;
              overflow: hidden;
              top: 50%;
              left: 50%;
              transform: translate(-50%, -50%);
              -ms-transform: translate(-50%, -50%);              
            
            }
            
            /*MODAL*/
            /* Style the Image Used to Trigger the Modal */
            #myImg {
                border-radius: 5px;
                cursor: pointer;
                transition: 0.3s;
            }

            #myImg:hover {opacity: 0.7;}

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                padding-top: 100px; /* Location of the box */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
            }

            /* Modal Content (Image) */
            .modal-content {
                margin: auto;
                display: block;
                width: 80%;
                max-width: 700px;
            }

            /* Caption of Modal Image (Image Text) - Same Width as the Image */
            #caption {
                margin: auto;
                display: block;
                width: 80%;
                max-width: 700px;
                text-align: center;
                color: #ccc;
                padding: 10px 0;
                height: 150px;
            }

            /* Add Animation - Zoom in the Modal */
            .modal-content, #caption { 
                -webkit-animation-name: zoom;
                -webkit-animation-duration: 0.6s;
                animation-name: zoom;
                animation-duration: 0.6s;
            }

            @-webkit-keyframes zoom {
                from {-webkit-transform:scale(0)} 
                to {-webkit-transform:scale(1)}
            }

            @keyframes zoom {
                from {transform:scale(0)} 
                to {transform:scale(1)}
            }

            /* The Close Button */
            .close {
                position: absolute;
                top: 15px;
                right: 35px;
                color: #f1f1f1;
                font-size: 40px;
                font-weight: bold;
                transition: 0.3s;
            }

            .close:hover,
            .close:focus {
                color: #bbb;
                text-decoration: none;
                cursor: pointer;
            }

            /* 100% Image Width on Smaller Screens */
            @media only screen and (max-width: 700px){
                .modal-content {
                    width: 100%;
                }
            }
            .negrita{
                font-weight: bold; 
            }
            .globo{
                background-color: red;
                opacity: .8;
            }
        </style>
    </head>
    <body>
        
        <div class="globo">
        <%
        DataAnime anime = (DataAnime) request.getAttribute("detalleAnime");
        String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(anime.getImagen().getImag());
        %>
        <div class="container"style="margin-right: 2%;">
              <img class="image"  src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=anime.getNombre()%></div>
              </div>
        </div>
        <h1><%=anime.getNombre()%></h1><br> 
        <a class="negrita">Link: </a> <a href="<%=anime.getLink()%>"><%=anime.getLink()%></a> <br><br>
        <a class="negrita">Capitulos: </a> <a><%=anime.getCapitulos()%></a> <br><br>
    
        <a class="negrita">Generos: </a> 
        <%      
        for(String genero: anime.getGeneros()){
            
        %>
        
        <a href="/Generos/<%=genero%>"  style="background-color: white"><%=genero%>, </a>
        
        <%
        }
        %>
        <br><br>
        
        <a class="negrita">Descripción: </a>  <a><%=anime.getDescripcion()%></a> <br><br>
        <%
        Collection<DataFavorito> colFav =  (Collection<DataFavorito>) request.getAttribute("colFav");
        if(colFav !=null){
        
            boolean encontrado = false;
            for(DataFavorito dfav : colFav){
                if(dfav instanceof DataAnime){
                    DataAnime danime = (DataAnime) dfav;
                    if(danime.getNombre().equals(anime.getNombre())){
                        encontrado = true;
                        break;
                    }
                }
            }
            if(encontrado){
        %>
        
            <img  onclick="cambio(this)" style="float:left;" width="75px" height="75px" src="/recursos/imagenes/favSi.png">
        
        <%
            }else{
         %>

         <img  onclick="cambio(this)" style="float:left;" width="75px" height="75px" src="/recursos/imagenes/favNo.gif">
         
         
         <%
        }}
        %>
        </div>
        <br><br><br><br><br><br><br>
        
        <%      
        for(DataAnime.Calidades.Entry ent: anime.getCalidades().getEntry()){
            DataCalidad dcal = ent.getValue();
            DataCalidad.Imgs ims = dcal.getImgs();
            List<DataCalidad.Imgs.Entry> listIm =  ims.getEntry();
        %>



             <%       
            for(DataCalidad.Imgs.Entry entr: listIm){
                b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(entr.getValue().getImag()); 
                String alt = entr.getValue().getDescripcion();
                if(alt ==null){
                    alt="Sin descripción";
                }
            %>
                
                
            <div class="container" onclick="zoom(this)" >
              <img class="image" src="data:image/png;base64, <%=b64%>" alt="<%=alt%>" >
              <img style="display:none;" src="/imagenes/<%=anime.getNombre()%>/<%=ent.getKey()%>/<%=entr.getValue().getIdentificador()%>">
              <div class="overlay">
                <div class="text"><%=ent.getKey()%></div>
              </div>
            </div>
            
            
            
            <%
            }
            %>
        
        <%
        }
        %>
       
            <!-- The Modal -->
            <div id="myModal" class="modal">

              <!-- The Close Button -->
              <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>

              <!-- Modal Content (The Image) -->
              <img class="modal-content" id="img01">

              <!-- Modal Caption (Image Text) -->
              <div id="caption"></div>
            </div>
    
    </body>
    <script>
        function zoom(div){
            var imagen = div.childNodes[1];
            var imDos = div.childNodes[3];
            modal.style.display = "block";
            modalImg.src = imDos.src;
            captionText.innerHTML = imagen.alt;
        }
        var modal = document.getElementById('myModal');

        // Get the image and insert it inside the modal - use its "alt" text as a caption
        var img = document.getElementById('myImg');
        var modalImg = document.getElementById("img01");
        var captionText = document.getElementById("caption");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() { 
          modal.style.display = "none";
        }
        function cambio(img){
            var completo = img.src;
            completo= completo.substring(completo.length-9,completo.length);
            if(completo == "favSi.png"){
                modificarFav(false);
                img.src = "/recursos/imagenes/favNo.gif";
            }else{
                modificarFav(true);
                img.src = "/recursos/imagenes/favSi.png"
            }
        }
        function modificarFav(isAdd) {
            var xhttp = new XMLHttpRequest();
            if(isAdd){
                xhttp.open("GET", "/Favorito/Anime/add/<%=anime.getNombre()%>", true);
            }else{
                xhttp.open("GET", "/Favorito/Anime/remove/<%=anime.getNombre()%>", true);
            }
            xhttp.send();
        }
    </script>
        <jsp:include page="/header.jsp"/>
</html>
