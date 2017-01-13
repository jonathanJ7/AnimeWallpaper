<%-- 
    Document   : home
    Created on : 10-ene-2017, 23:44:40
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
        <jsp:include page="/header.jsp"/>
        <style>
            .imagenHome{
                width: 100%;
                height: 100%;
                cursor:pointer;
            }
            .paraMostrar{
                width: 25%;
                height: 250px;
                cursor:pointer;
                float: left;
            }
            .paraMostrar:hover .textoSobreImagen{
                display: block;
            }
            .paraMostrar:hover .imagenHome{
                opacity: 0.3;
            }
            .textoSobreImagen{
                display: none;
                position:absolute;
                color:black;
                text-shadow: 2px 0 0 #fff, -2px 0 0 #fff, 0 2px 0 #fff, 0 -2px 0 #fff, 1px 1px #fff, -1px -1px 0 #fff, 1px -1px 0 #fff, -1px 1px 0 #fff;
            }
      
        </style>
    </head>
    <body>
        <% 
        Collection<DataAnimeImNom> listaAnimes = (Collection<DataAnimeImNom> ) request.getAttribute("listaAnimes");        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        
        <div class="paraMostrar">
            <a> </a> 
            <a class="textoSobreImagen"><br>&nbsp;&nbsp;&nbsp;<%=data.getNombre()%></a>
            <img onclick="location.href = '/Anime/<%=data.getNombre()%>'" class="imagenHome" src="data:image/png;base64, <%=b64%>" >
        </div>
        <%
        }
        %>
    </body>
</html>
