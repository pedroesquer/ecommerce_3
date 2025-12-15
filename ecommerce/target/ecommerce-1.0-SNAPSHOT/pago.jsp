<%-- 
    Document   : pago
    Created on : Nov 11, 2025, 6:27:21 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pago</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
<body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        
        <main class="contenedorGridPago">
            <h1 class="labelPago">Pago</h1>
            
            <div class="contenedorPagar">
                <h2>Enviar a:</h2>
                <div class="contenedorDireccion">
                    <p>Del agua azul. #115 Casa Naranja. CASA BLANCA, CIUDAD OBREGÓN SONORA, 85140 MÉXICO</p>
                    <button class="btnCambiarDir" type="button">
                        <a href="./cambiardireccion.jsp" style="text-decoration: none; color: inherit;">
                            <span>Cambiar dirección</span>
                        </a>
                    </button>
                </div>
            </div>

            <div class="contenedorMetodoPago">
                <h2>Seleccione su método de pago</h2>

                <input type="radio" name="metodo" id="tarjeta" class="radioMetodo">
                <input type="radio" name="metodo" id="transferencia" class="radioMetodo">
                <input type="radio" name="metodo" id="contraentrega" class="radioMetodo">

                <div class="contenedorOpcionesPago">
                    <label for="tarjeta" class="opcionPago">
                        <span>Tarjeta</span>
                        <img src="./imgs/tarjeta.png" alt="Tarjeta">
                    </label>

                    <label for="transferencia" class="opcionPago">
                        <span>Transferencia</span>
                        <img src="./imgs/transferencia.png" alt="Transferencia">
                    </label>

                    <label for="contraentrega" class="opcionPago">
                        <span>Contraentrega</span>
                        <img src="./imgs/contraentrega.png" alt="Contraentrega">
                    </label>
                </div>

                <div class="seccionTarjeta">
                    <h3>Pago con Tarjeta</h3>
                    <form>
                        <input type="text" placeholder="Número de tarjeta" required><br>
                        <input type="text" placeholder="Fecha de expiración" required><br>
                        <input type="text" placeholder="CVV" required><br>
                        <input type="text" placeholder="Nombre en la tarjeta" required><br>
                        <input class="botonPagar" type="submit" value="Pagar">
                    </form>
                </div>

                <div class="seccionTransferencia">
                    <h3>Pago con Transferencia</h3>
                    <img src="./imgs/transferenciaFicha.jpg" alt="Ficha de transferencia" style="max-width: 200px; display:block; margin: 10px auto;">
                    <form>
                        <p style="text-align: center;">Sube tu comprobante o da clic en pagar para continuar.</p>
                        <input class="botonPagar" type="submit" value="Pagar">
                    </form>
                </div>

                <div class="seccionContraentrega">
                    <h3>Pago Contra Entrega</h3>
                    <form>
                        <label><input type="radio" name="opcionEntrega" required> Efectivo</label><br>
                        <label><input type="radio" name="opcionEntrega" required> Tarjeta</label><br>
                        <input class="botonPagar" type="submit" value="Pagar">
                    </form>
                </div>
            </div>

            <div class="contenedorCompras">
                <h2>Artículos</h2>
                <div class="contenedorArticulos">
                    <div class="articulo1"></div> 
                </div>
            </div>
        </main>    

        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
        <script src="./scripts/pago.js"></script>
    </body> 


</html>