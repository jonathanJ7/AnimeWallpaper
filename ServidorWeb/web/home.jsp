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
        
        <style>
            .container {
              position:relative;
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
        </style>
    </head>
    <body>
        <% 
        Collection<DataAnimeImNom> listaAnimes = (Collection<DataAnimeImNom> ) request.getAttribute("listaAnimes");        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

              
            <div class="container" onclick="location.href = '/Anime/<%=data.getNombre()%>'" >
              <img class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <%--RELLEO--%>
        <% 
        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

            <div class="container">
              <img onclick="location.href = '/Anime/<%=data.getNombre()%>'" class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <% 
        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

            <div class="container">
              <img onclick="location.href = '/Anime/<%=data.getNombre()%>'" class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <% 
        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

            <div class="container">
              <img onclick="location.href = '/Anime/<%=data.getNombre()%>'" class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <% 
        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

            <div class="container">
              <img onclick="location.href = '/Anime/<%=data.getNombre()%>'" class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <% 
        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

            <div class="container">
              <img onclick="location.href = '/Anime/<%=data.getNombre()%>'" class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <% 
        
        for(DataAnimeImNom data: listaAnimes){
            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(data.getImg().getImag());
        %>
        

            <div class="container" onclick="location.href = '/Anime/<%=data.getNombre()%>'" >
              <img class="image" src="data:image/png;base64, <%=b64%>" >
              <div class="overlay">
                <div class="text"><%=data.getNombre()%></div>
              </div>
            </div>
        <%
        }
        %>
        
        
        <jsp:include page="/header.jsp"/>
    </body>
</html>
