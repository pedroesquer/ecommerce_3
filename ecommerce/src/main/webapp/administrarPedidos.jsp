<%-- 
    Document   : administrarPedidos
    Created on : Nov 18, 2025, 12:12:04 PM
    Author     : juanpheras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./styles.css">
    </head>

    <body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <main>
            <div class="layout-admin">
                <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>
                <div class="contenido-general">
                    <div class = "botonRegresar">
                        <a href="./menuadministrador.jsp">
                            <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                        </a>
                    </div>
                    <a href="./administrarPedidoIndividual.jsp" class="pedido-link">
                        <div class="pedido">
                            <div class="pedido-header">
                                <h2>Pedido #1</h2>
                            </div>

                            <div class="pedido-body">
                                <div class="articulos-admin-pedido">
                                    <img src="./imgs/llavero.jpg" alt="">
                                    <img src="./imgs/aceite.png" alt="">
                                </div>

                            </div>
                        </div>
                    </a>

                    </main>
                    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>

                    </body>

                    </html>