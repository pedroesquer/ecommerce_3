<%-- 
    Document   : inicioSesion
    Created on : Nov 11, 2025, 6:26:00 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="./styles.css">
    </head>
    <body>
        <header class = "encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt="" height="100" width="250">
        </header>
        <main class = "main-registro">
            <h1>Iniciar Sesion</h1>
            <form class = "form-login">
                <div class = "nombre-registro">
                    <label for="nombre">Nombre</label>
                    <br>
                    <input type="text" id="nombre" name="nombre" required minlength="10" max="100" class = input-login>
                </div>
               <div class="contrasenia-registro">
                    <br>
                    <label for="Contrasenia">Contraseña</label>
                    <br>
                    <input type="password" id="contrasenia" name="contrasenia" required min="8" max="20" class = "input-login">
                </div>
                <button type="submit" class = "boton-enviar-registro">Enviar</button>
            </form>
        </main>
        <div class = "register-link">
            <p>¿No tienes una cuenta? <a href="registro.html">Regístrate aquí</a></p>
        </div>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>




