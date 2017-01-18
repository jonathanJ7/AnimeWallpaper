<%-- 
    Document   : generos
    Created on : 17-ene-2017, 14:28:14
    Author     : Jonathan
--%>

<%@page import="servidor.DataUsuario"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .card {
                margin: 1%;
                transition: 0.3s;
                width: 150px;
                max-height: 20%;
                height: 200px;
                float: left;
                border: 2px solid transparent;
                overflow: hidden;
                background-image: url("/recursos/imagenes/generos.jpg");
            }
            .card:hover {
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
                border: 2px solid red;
            } 
    </style>
    <body>
        <% 
        Collection<DataUsuario> usuarios = (Collection<DataUsuario> ) request.getAttribute("colUsr");        
        for(DataUsuario dusr: usuarios){
        %>
        

            <div class="card" onclick="location.href = '/Perfiles/<%=dusr.getNickname()%>'" >
                <p><%=dusr.getNickname()%></p>
            </div>
        <%
        }
        %>
        <jsp:include page="/header.jsp"/>
    </body>
</html>
