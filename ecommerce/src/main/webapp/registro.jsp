<%-- 
    Document   : registro
    Created on : Nov 11, 2025, 6:31:20 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Regístrate</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
    <body>
        <header class="header-inicioSesion">
            <a href="./index.jsp"><img src="imgs/refaccionesMoralesFondoNegro.png" 
                 alt="" height="100" width="250"></a>
          
        </header>
        <main class = "main-registro">
            <h1>Regístrate</h1>
            <form class = "form-registro">
                <div class = "nombre-registro">
                    <label for="nombre">Nombre</label>
                    <br>
                    <input type="text" id="nombre" name="nombre" required minlength="10" max="100" class = "input-registro">
                </div>
                <div class = "numero-registro">
                    <br>
                    <label for="numero">Número</label>
                    <br>
                    <input type= "text" name="numero" id="numero" required pattern="[0-9]{10}" class = "input-registro">
                </div>
                <div class="correo-registro">
                    <br>
                    <label for="correo">Email</label>
                    <br>
                    <input type="email" name="correo" id="correo" required min="5" max="100" class = "input-registro">
                </div>
                <div class="contrasenia-registro">
                    <br>
                    <label for="Contrasenia">Contraseña:</label>
                    <br>
                    <input type="password" id="contrasenia" name="contrasenia" required min="8" max="20" class = "input-registro">
                </div>
                
                <br>
                <button type="submit" class = boton-enviar-registro>Enviar</button>
            </form>
        </main>
        <div class = "register-link">    
            <p>¿Ya tienes una cuenta? <a href="inicioSesion.jsp">Inicia sesión aquí</a></p>
        </div>
       <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>




