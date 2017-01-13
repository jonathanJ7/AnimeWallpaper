<%-- 
    Document   : home
    Created on : 10-ene-2017, 23:44:40
    Author     : Jonathan
--%>

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
        <jsp:include page="/header.jsp"/>
    </head>
    <body>
        
        <%
        DataAnime anime = (DataAnime) request.getAttribute("detalleAnime");
        String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(anime.getImagen().getImag());
        %>
        
        <br><img src="data:image/png;base64, <%=b64%>" style="width:150px;height: 150px" ><br>
        <h1><%=anime.getNombre()%></h1>
        <br><a><%=anime.getDescripcion()%></a>
        <br><a><%=anime.getLink()%></a>
        <br><a><%=anime.getCapitulos()%></a>
    
        
        
        <%      
        for(DataAnime.Calidades.Entry ent: anime.getCalidades().getEntry()){
            DataCalidad dcal = ent.getValue();
            DataCalidad.Imgs ims = dcal.getImgs();
            List<DataCalidad.Imgs.Entry> listIm =  ims.getEntry();
        %>

            <br><a><%=ent.getKey()%></a>


             <%       
            for(DataCalidad.Imgs.Entry entr: listIm){
                b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(entr.getValue().getImag());            
            %>
                <br><img src="data:image/png;base64, <%=b64%>" style="width:150px;height: 150px" ><br>

            <%
            }
            %>
        
        <%
        }
        %>
       
    
    </body>
</html>
