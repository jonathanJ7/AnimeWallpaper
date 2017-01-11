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
    </head>
    <body>
        <% 
        Collection<DataAnimeImNom> listaAnimes = (Collection<DataAnimeImNom> ) request.getAttribute("listaAnimes");        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        <div id="anime" onclick="location.href = '/Anime/<%=data.getNombre()%>'">
            <a><%=data.getNombre()%></a><br>
            <img src="data:image/png;base64, <%=b64%>" style="width:150px;height: 150px" ><br>
        </div>
        <%
        }
        %>
    </body>
</html>
