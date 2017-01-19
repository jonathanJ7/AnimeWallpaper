<%-- 
    Document   : crearPack
    Created on : 18-ene-2017, 18:30:30
    Author     : Jonathan
--%>

<%@page import="java.util.Collection"%>
<%@page import="servidor.DataAnimeImNom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        .globo{
            background-color: red;
            opacity: .7;
            border-radius: 20%;
        }
        .titulo{
            text-align: center;
            text-shadow: 2px 0 0 black, -2px 0 0 black, 0 2px 0 black, 0 -2px 0 black, 1px 1px black, -1px -1px 0 black, 1px -1px 0 black, -1px 1px 0 black;
        }
        .texto {
            width: 100%;
            display: inline-block;
            text-align: center;
            padding: 5px;
        }
    </style>
    <body>
        <a class="titulo"><h1>Crear Pack</h1></a>
        <div class="globo">
            <from action="">
                <a class="texto" >Nombre: <input type="text" name="Nombre" placeholder="Ingrese el nombre del pack"></a><br>
            </from>
        </div>
        <a class="titulo"><h1>Seleccionar anime</h1></a>
        <div class="globo">
            <% Collection<DataAnimeImNom> listaAnimes = (Collection<DataAnimeImNom>)request.getAttribute("listaAnimes");
            for(DataAnimeImNom danime: listaAnimes){
            %>
                <a class="textoItem" onclick="mostrarImagenes('<%=danime.getNombre()%>')"><%=danime.getNombre()%></a>
            <%}%>
        </div> 
        
            <a class="texto" ><span id="isE">j</span></a><br>
        
    <jsp:include page="/header.jsp"/>
    </body>
    <script>
        function mostrarImagenes(anime) {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
              if (this.readyState == 4 && this.status == 200) {
                document.getElementById("isE").innerHTML = this.responseText;
              }
            };
            xhttp.open("GET", "/ajax/Anime/"+anime, true);
            xhttp.send();
        }
    </script>
</html>
