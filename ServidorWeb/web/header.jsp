<%-- 
    Document   : header
    Created on : 12-ene-2017, 23:48:51
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            /* Remove margins and padding from the list, and add a black background color */
#cabezal {
    position: fixed;
    top:0;
    left:0;
    overflow:visible;
    background-color: #333;
    width: 100%;
    box-shadow: 0px 1px 5px red;
}

/* Float the list items side by side */
.itemTop {float: left;
          margin-right: 10px;
        }

/* Style the links inside the list items */
.textoItem {
    display: inline-block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    transition: 0.3s;
    font-size: 17px;
}
body{
    margin-top :50px;
    
    margin-bottom:0px;
    
    margin-left :0px;
    
    margin-right :0px;
    background-color: #333;
    color: white;
    
}
/* Change background color of links on hover */
.textoItem:hover {background-color: #555;}

.login{
   float: right;
   margin-right: 10px;
}
.inputLogin{
    display: inline-block;
    color: #f2f2f2;
    text-align: center;
    margin-top: 3%;
    text-decoration: none;
    transition: 0.3s;
    font-size: 17px;
}


/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    float: right;
    display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    margin-top: 30%;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
    display: block;
}

        </style>
    </head>
    <body>
        <div id="cabezal">
            <div class="itemTop"><a class="textoItem" href="/Home">Home</a></div>
            <div class="itemTop"><a class="textoItem" href="/Generos">Generos</a></div>
            <div class="itemTop"><a class="textoItem" href="/Perfiles">Usuarios</a></div>
            <div class="itemTop"><a class="textoItem" href="#home">Packs</a></div>
            
            <% String nickName = (String) request.getSession().getAttribute("nickName"); 
            if(nickName==null){
            %>
            <form action="/Cuenta/Conectar" class="login">
                    <a class="inputLogin" href="#home">
                        <input type="email" name="Email" placeholder="Email" >
                    </a>
                    <a class="inputLogin" href="#home">
                        <input type="password" name="Password" placeholder="Password">
                    </a>
                    <input type="submit" value="Conectar">    
            </form>
            
            <div class="dropdown">
                <div class="itemTop"><a class="textoItem" href="#home">Registrar</a></div>
                <div id="myDropdown" class="dropdown-content">
                    <form action="/Cuenta/Registrar" class="login">
                        <a class="inputLogin" href="#home">
                            <input type="email" name="Email" placeholder="Email">
                        </a>
                        <a class="inputLogin" href="#home">
                            <input type="text" name="Nickname" placeholder="Nickname">
                        </a>
                        <a class="inputLogin" href="#home">
                            <input type="password" name="Password" placeholder="Password" >
                        </a>
                        <input style="margin-left: 33%" type="submit" value="Registrar">  
                        <br>
                    </form>
                </div>
            </div>
            <% }else{ %>
            <div style="float:right;">
                    <div class="dropdown">
                    <div class="itemTop"><a class="textoItem" href="/Perfiles/<%=nickName%>"><%=nickName%></a></div>
                    <div id="myDropdown" class="dropdown-content" style="right:0; margin-top: 50%;">
                            <a class="inputLogin" href="/Perfiles/<%=nickName%>">Mi perfil</a>
                            <a class="inputLogin" href="#home">cosa</a>
                            <a class="inputLogin" href="/cerrarsesion.jsp">Cerrar sesion</a>
                            
                    </div>
                </div>
            </div>
            <% }%>
            
        </div>
            
    <% String alerta= (String) request.getSession().getAttribute("alerta");
    if(alerta!=null){ %>
        <script>
            alert("<%=alerta%>");
        </script>
    <%  
    request.getSession().setAttribute("alerta", null);
    }
    %>
    </body>
    
</html>
