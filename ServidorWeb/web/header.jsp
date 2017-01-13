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
    overflow: hidden;
    background-color: #333;
    width: 100%;
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


        </style>
    </head>
    <body>
        <div id="cabezal">
            <div class="itemTop"><a class="textoItem" href="/Home">Home</a></div>
            <div class="itemTop"><a class="textoItem" href="#home">awsd</a></div>
            <div class="itemTop"><a class="textoItem" href="#home">adf</a></div>
            <div class="itemTop"><a class="textoItem" href="#home">asdasd</a></div>
        </div>
    </body>
</html>
