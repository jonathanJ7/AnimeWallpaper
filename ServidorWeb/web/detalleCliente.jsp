<%-- 
    Document   : detalleCliente
    Created on : 18-ene-2017, 10:58:44
    Author     : Jonathan
--%>

<%@page import="servidor.DataAnime"%>
<%@page import="servidor.DataFavorito"%>
<%@page import="servidor.DataCliente"%>
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
        .textoItem {
            width: 100%;
        }
    </style>
    <body>
        <%
        DataCliente dcli = (DataCliente) request.getAttribute("detalleCliente");
        String usrActual = (String) request.getSession().getAttribute("nickName");
        %>
        
        <a class="titulo"><h1>Datos:</h1></a>
        <div class="globo">
            
        <a class="textoItem" ><%=dcli.getNickname()%></a><br>
        
        <%
        if(usrActual!=null && usrActual.equals(dcli.getNickname())){
        %>
        
        <a class="textoItem" ><%=dcli.getCorreo()%></a><br>
        
        <%
        }
        %>
        
        
        </div>
        
        <a class="titulo"><h1>Animes favoritos:</h1></a>
        <div class="globo">
        <%
        for(DataFavorito dfav: dcli.getFav()){
            if(dfav instanceof DataAnime){
                DataAnime danime = (DataAnime) dfav;
        %>
        
            <a class="textoItem" href="/Anime/<%=danime.getNombre()%>"><%=danime.getNombre()%></a><br>
        
        <%
        }}
        %>
        </div>
    </body>
    <jsp:include page="/header.jsp"/>
</html>
