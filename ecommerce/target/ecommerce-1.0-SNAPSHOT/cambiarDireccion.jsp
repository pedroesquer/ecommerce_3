<%-- 
    Document   : cambiarDireccion
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cambiar dirección</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
    <body>
        
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        
        <header class="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt="Logo" height="100" width="250">
        </header>

        <main>
            <div class="botonRegresar">
                <a href="./pago.jsp">
                    <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                </a>
            </div>

            <h1 class="labelCambiarDir">Cambiar dirección de envío</h1>

            <div class="formularioDir">
                <form id="formDireccion">
                    <label for="nombreCompleto">Nombre completo (quien recibe):</label><br>
                    <input type="text" id="nombreCompleto" name="nombreCompleto" required><br><br>

                    <label for="calleNumero">Calle y número:</label><br>
                    <input type="text" id="calleNumero" name="calleNumero" required><br><br>

                    <label for="colonia">Colonia:</label><br>
                    <input type="text" id="colonia" name="colonia" required><br><br>

                    <label for="ciudad">Ciudad:</label><br>
                    <input type="text" id="ciudad" name="ciudad" required><br><br>

                    <label for="estado">Estado:</label><br>
                    <input type="text" id="estado" name="estado" required><br><br>

                    <label for="codigoPostal">Código postal:</label><br>
                    <input type="text" id="codigoPostal" name="codigoPostal" required minlength="5" maxlength="5" pattern="\d{5}" title="5 dígitos numéricos"><br><br>

                    <input type="submit" value="Guardar Dirección" id="guardar" class="botonGuardar">
                </form>
            </div>
        </main>

        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
        
        <script src="./scripts/cambiarDireccion.js"></script>
    </body>
</html>