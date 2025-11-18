<%-- 
    Document   : menuadministrador
    Created on : Nov 18, 2025, 12:30:27 PM
    Author     : juanpheras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>        
<html>  
    <head>
        <meta charset="UTF-8">
        <title>Menú Administror</title>
        <link rel="stylesheet" href="./styles.css">
    </head>  
    <body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>

        <main>
            <div class="layout-admin">
                <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>
                <h1>Bienvenido Admin</h1>
        </main>

        <%@include file ="./WEB-INF/fragmentos/footer.jspf"%>
    </body>

</html> 