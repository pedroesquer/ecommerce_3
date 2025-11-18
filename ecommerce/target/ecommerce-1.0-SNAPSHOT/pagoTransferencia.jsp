<%-- 
    Document   : pagoTransferencia
    Created on : Nov 11, 2025, 6:29:35 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagar con Transferencia</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
    <body>
        <header class="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt=""height="100" width="250">
        </header>
        <main>
            <div class = "botonRegresar">
            <a href="./pago.html">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
            </div>
            <h1 class="labelPagoTransferencia">Pago con Transferencia</h1>
     
            <div class="contenedorTransferencia">
                <img src="./imgs/transferenciaFicha.jpg">
                <form action="pedidoconfirmado.html" method="get">
                    <input class="botonPagar" type="submit" value="Pagar">
                </form>
            </div>
        </main>
       <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>
