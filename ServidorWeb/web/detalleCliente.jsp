<%-- 
    Document   : detalleCliente
    Created on : 18-ene-2017, 10:58:44
    Author     : Jonathan
--%>

<%@page import="servidor.DataCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        DataCliente dcli = (DataCliente) request.getAttribute("detalleCliente");
        String usrActual = (String) request.getSession().getAttribute("nickName");
        %>
        
        <p><%=dcli.getNickname()%></p>
        <%
        if(usrActual!=null && usrActual.equals(dcli.getNickname())){
        %>
        
        <p><%=dcli.getCorreo()%></p>
        
        <%
        }
        %>
    </body>
    <jsp:include page="/header.jsp"/>
</html>
