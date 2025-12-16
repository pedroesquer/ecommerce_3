<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>

        <header class="header-inicioSesion">
            <a href="./index.jsp"><img src="imgs/refaccionesMoralesFondoNegro.png" 
                                       alt="" height="100" width="250"></a>

        </header>

        <main class="main-registro">
            <h1>Iniciar Sesión</h1>



            <form class="form-login" method="POST" action="login">

                <div class="nombre-registro">
                    <label for="correo">Correo:</label>
                    <br>
                    <input type="text" id="correo" name="correo"
                           required minlength="10" maxlength="100"
                           class="input-login">
                </div>

                <div class="contrasenia-registro">
                    <br>
                    <label for="contrasenia">Contraseña:</label>
                    <br>
                    <input type="password" id="contrasenia" name="contrasenia"
                           required minlength="8" maxlength="50"
                           class="input-login">
                </div>
                <%
                    String mensaje = (String) request.getAttribute("mensaje");
                    if (mensaje != null) {
                %>
                <p class="mensaje-error"><%= mensaje%></p>
                <%
                    }
                %>

                <button type="submit" class="boton-enviar-registro">Enviar</button>
            </form>
        </main>

        <div class="register-link">
            <p>¿No tienes una cuenta? 
                <a href="registro.jsp">Regístrate aquí</a>
            </p>
        </div>
        <%@include file="./WEB-INF/fragmentos/nav-mobile.jspf" %>
        <%@ include file="WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>
