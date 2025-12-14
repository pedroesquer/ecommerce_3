<%-- 
    Document   : editarUsuario
    Created on : Nov 11, 2025, 6:25:31 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Usuario</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <main>
        <div class = "botonRegresar">
            <a href="./usuario.jsp">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
        </div>
            <h1 class = "h1_editarPerfil">Editar Perfil</h1>
            <div class = imagenes>
                <img src="./imgs/foto_usuario.png" alt=""height="100" width="100" class = "fondo">
            </div>
            <div class = "editarPerfil">
                <form class = "formEditarPerfil">
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
                    <div class="correo-registro"x>
                        <br>
                        <label for="correo">Email</label>
                        <br>
                        <input type="email" name="correo" id="correo" required min="5" max="100" class = "input-registro">
                    </div>
                </form>
            </div>
            <div class ="divAceptar">
                <button type= "button" class = "btnAceptar">Aceptar</button>
            </div>
        </main>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
        <script src="./scripts/editarUsuario.js"></script>
    </body>
</html>


