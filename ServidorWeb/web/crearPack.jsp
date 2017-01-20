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
        .celdas:hover {
          background-color: #424242;
          cursor: pointer;
        }
        .celdas{
            text-align: center;
            text-shadow: 2px 0 0 black, -2px 0 0 black, 0 2px 0 black, 0 -2px 0 black, 1px 1px black, -1px -1px 0 black, 1px -1px 0 black, -1px 1px 0 black;
        }
        table {
            width: 100%;
            border-collapse:collapse; 
        }

    </style>
    <body>
        <a class="titulo"><h1>Crear Pack</h1></a>
        <div class="globo">
                <a class="texto" >Nombre: <input type="text" id="nombrePack" name="Nombre" placeholder="Ingrese el nombre del pack"><input type="submit" onclick="crearPack()" value="Crear"></a><br>
        </div>
        <a class="titulo"><h1>Imagenes seleccionadas</h1></a>
        <div class="globo">
            
            
            <table id="contenedorFilas">
                <tr>
                    <th> Anime </th>
                    <th> Resolucion </th>
                    <th> Imagen </th>
                    <th> Identificador </th>
                </tr>
            </table>
            
            
        </div>
        <a class="titulo"><h1>Seleccionar anime</h1></a>
        <div class="globo">
            <% Collection<DataAnimeImNom> listaAnimes = (Collection<DataAnimeImNom>)request.getAttribute("listaAnimes");
            for(DataAnimeImNom danime: listaAnimes){
            %>
                <a class="textoItem" onclick="mostrarImagenes('<%=danime.getNombre()%>')"><%=danime.getNombre()%></a>
            <%}%>
        </div> 
        
            <a class="texto" ><span id="isE"></span></a><br>
        
    <jsp:include page="/header.jsp"/>
    </body>
    <script>
        function crearPack(){
            var nomPack = document.getElementById("nombrePack");
            var consulta = "/"+ nomPack.value;
            
            var table = document.getElementById('contenedorFilas');
            for (var r = 1, n = table.rows.length; r < n; r++) {
                consulta = consulta + "/"+ table.rows[r].cells[0].innerHTML;
                consulta = consulta + "/"+ table.rows[r].cells[1].innerHTML;
                consulta = consulta + "/"+ table.rows[r].cells[3].innerHTML;                
            }
            window.location = "/Pack/darAltaPack"+consulta;            
            
        }
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
        
        function borrar(celda){
            celda.parentNode.remove();
        }
        function seleccionar(img){
            var parametros = img.alt.split("/");
            var contenedor = document.getElementById("contenedorFilas");
            
            
            var row = document.createElement("tr"); 
            row.setAttribute("class","celdas");
            
            
            var cell = document.createElement("td");    
            var cellText = document.createTextNode(parametros[0]);
            cell.appendChild(cellText);
            row.appendChild(cell);            
            
            var cell = document.createElement("td");    
            var cellText = document.createTextNode(parametros[1]);
            cell.appendChild(cellText);
            row.appendChild(cell);
            
            
            var cell = document.createElement("td"); 
            var imagen = document.createElement("img");    
            imagen.src=img.src;
            imagen.setAttribute("width","30px");
            imagen.setAttribute("heigth","30px");
            cell.appendChild(imagen);
            row.appendChild(cell);
            
            var cell = document.createElement("td");    
            var cellText = document.createTextNode(parametros[2]);
            cell.appendChild(cellText);
            row.appendChild(cell);
            
            var cell = document.createElement("td");    
            var cellText = document.createTextNode("x");
            cell.setAttribute("onclick","borrar(this)");
            cell.appendChild(cellText);
            row.appendChild(cell);
            
            
            contenedor.appendChild(row);
        }
    </script>
</html>
