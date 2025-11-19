<%-- 
    Document   : misPedidos
    Created on : Nov 11, 2025, 6:26:21 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis pedidos - Refacciones Morales</title>
    <link rel="stylesheet" href="./styles.css">
</head>


<body>
    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <div class = "botonRegresar">
            <a href="./usuario.html">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
        </div>
    <header class="mis-pedidos">
        <h1>Mis Pedidos</h1>
    </header>
    <main>
        <a href="./pedidoConfirmado.html" class="pedido-link">
            <div class="pedido">
                <div class="pedido-header">
                    <h2>Pedido #1</h2>
                    <p>18 de octubre de 2025 - enviado</p>
                </div>


                <div class="pedido-body">
                    <div class="articulos">
                        <img src="./imgs/llavero.jpg" alt="">
                    </div>
                    <div class="direccion">
                        <p>Del agua azul. #115 Casa Naranja. CASA BLANCA, CIUDAD OBREGÓN SONORA, 85140 MÉXICO</p>
                    </div>


                </div>
            </div>
        </a>


    </main>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
</body>


</html>
