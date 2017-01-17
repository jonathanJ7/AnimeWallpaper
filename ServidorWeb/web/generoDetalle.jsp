<%-- 
    Document   : home
    Created on : 10-ene-2017, 23:44:40
    Author     : Jonathan
--%>

<%@page import="servidor.DataImagen"%>
<%@page import="servidor.DataAnimeImNom"%>
<%@page import="servidor.DataGeneroReducido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/header.jsp"/>
    </head>
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
        </style>
    <body>
        
        <%
        DataGeneroReducido genero = (DataGeneroReducido) request.getAttribute("detalleGenero");
        String b64 = null;
        %>
        
        <h1><%=genero.getNombre()%></h1><br> 
        <a class="negrita">Descripción: </a>  <a><%=genero.getDescripcion()%></a> <br><br>
        
        
        <%      
        for(DataGeneroReducido.Animes.Entry ent: genero.getAnimes().getEntry()){
            DataAnimeImNom animeR = ent.getValue();
            DataImagen imagen = animeR.getImg();
            String alt = imagen.getDescripcion();
            b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imagen.getImag());
            if(alt==null){
                alt="Sin descripción";
            }
        %>


            <div class="container" onclick="location.href = '/Anime/<%=ent.getKey()%>'" >
              <img class="image" src="data:image/png;base64, <%=b64%>" alt="<%=alt%>" >
              <div class="overlay">
                <div class="text"><%=ent.getKey()%></div>
              </div>
            </div>
            
        <%
        }
        %>
       
    </body>
    
</html>
