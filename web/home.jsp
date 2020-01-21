<%-- 
    Document   : home
    Created on : 14-ene-2020, 10:05:48
    Author     : JorgeCervi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pojos.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            ArrayList<Categoria> categorias = (ArrayList<Categoria>) session.getAttribute("categorias");
            for (Categoria categoria:categorias){
                
        %>
                <h1><%= categoria.getNombre()%></h1>
            <%}
        %>
    </body>
</html>
