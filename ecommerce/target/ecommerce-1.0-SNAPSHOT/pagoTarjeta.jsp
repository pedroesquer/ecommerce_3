<%-- 
    Document   : pagoTarjeta
    Created on : Nov 11, 2025, 6:27:34 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagar con Tarjeta</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
    <body>
        <header class="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt=""height="100" width="250">
        </header>
        <main>
            <h1 class="labelPagoTarjeta">Pago con Tarjeta</h1>
        </main>
        <div class = "botonRegresar">
            <a href="./pago.jsp">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
            </div>
        <div class="formularioTarjeta">
            <form action="pedidoconfirmado.jsp" method="get">
                <label for="text">Número de tarjeta:</label><br>
                <input type="text" id="numeroTarjeta" name="numeroTarjeta" required><br><br>
                <label for="text">Fecha de expiración:</label><br>
                <input type="text" id="fechaExp" name="fechaExp" required minlength="5" maxlength="5"><br><br>
                <label for="text">CVV:</label><br>
                <input type="text" id="cvv" name="cvv" required minlength="3" maxlength="3"><br><br>
                <label for="text">Nombre en la tarjeta:</label><br>
                <input type="text" id="nombreTarjeta" name="nombreTarjeta" required><br><br>


                <input class="botonPagar" type="submit" value="Pagar" id="pagarTarjeta">
            </form>
        </div>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>    
