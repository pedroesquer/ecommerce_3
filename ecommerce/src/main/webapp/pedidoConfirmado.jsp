<%-- 
    Document   : pedidoConfirmado
    Created on : Nov 11, 2025, 6:29:59 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedido confirmado - Refacciones Morales</title>
    <link rel="stylesheet" href="./styles.css">
</head>


<body>
    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <div class = "botonRegresar">
            <a href="./usuario.jsp">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
        </div>
    <header class="pedido-confirmado">
        <h1>¡Pedido Confirmado!</h1>
    </header>
    <main>
        <section class="confirmacion-pedido">
            <h2>Se generó el pedido con el #1</h2>
        </section>
        <div class="articulos-pedido">
            <h3>Artículos</h3>
            <img src="./imgs/llavero.jpg" alt="">
        </div>
        <div class="direccion-envio">
            <h3>Dirección de envío</h3>
            <p>Del agua azul, #115 Casa Naranja.
                CASA BLANCA, CIUDAD OBREGÓN SONORA, 85140 MÉXICO
            </p>


        </div>
    </main>


   <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
   <script src="./scripts/pedidoConfirmado.js"></script>
</body>


</html>