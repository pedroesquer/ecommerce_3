<%-- 
    Document   : pagarContraEntrega
    Created on : Nov 11, 2025, 6:26:59 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagar con Contraentrega</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
    <body>
        <header class="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt=""height="100" width="250">
        </header>
        <main>
            <div class = "botonRegresar">
            <a href="./pago.jsp">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
            </div>
            <h1 class="labelPagoContraentrega">Pago al Entregar</h1>
     
            <div class="contenedorContraentrega">
                <form action="pedidoconfirmado.jsp" method="get">
                    <label>  
                    <input type="radio" name="metodoPago" id="radioEfectivo" value="efectivo">
                        Efectivo
                    </label> <br>


                    <label>
                    <input type="radio" name="metodoPago" id="radioTarjeta" value="tarjeta">
                        Tarjeta
                    </label> <br>
                    <input class="botonPagar" type="submit" value="Pagar" id="pagarContraentrega">
                </form>  
            </div>
        </main>
        <footer class="footer-desktop">
        <div class="logo-footer">
            <img src="./imgs/svg/logoBlanco.svg" alt="">
            <p>Rinden más y nunca se rinden</p>
            <p>©2025 Refacciones Morales S.A. de C.V.</p>
        </div>


        <div class="contacto">
            <h3>Contáctanos</h3>
            <ul class="social-links">
                <li><a href="https://www.whatsapp.com/"><img src="./imgs/svg/whatsappLogo.svg" alt="WhatsApp"></a></li>
                <li><a href="https://www.instagram.com/"><img src="./imgs/svg/instaLogo.svg" alt="Instagram"></a></li>
                <li><a href="https://www.facebook.com/"><img src="./imgs/svg/facebookLogo.svg" alt="Facebook"></a></li>
                <li><a href="https://mail.google.com/"><img src="./imgs/svg/gmailLogo.svg" alt="Correo"></a></li>
            </ul>
        </div>


        <div class="avisos">
            <ul class="legal-links">
                <li><a href="">Términos y condiciones</a></li>
                <li><a href="">Aviso de privacidad</a></li>
                <li><a href="">Políticas de cookies</a></li>
            </ul>
        </div>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>    
</html>




