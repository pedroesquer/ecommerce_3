<%-- 
    Document   : usuario
    Created on : Nov 11, 2025, 6:31:34 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Usuario</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <header class ="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt=""height="100" width="250">
        </header>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <main>
        <div class = "botonRegresar">
            <a href="./index.html">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
        </div>
            <div class = "foto_usuario">
                <img src="./imgs/foto_usuario.png" alt="" height="100" width="100">
                <h1 class= "h1-usuario">HOLA GAEL</h1>
            </div>
            <div class = "info-usuario">
                <div class = "panel-usuario" id="panel_nomnre">
                    <p>Nombre: <br>Gael Guerra Landavazo</p>
                </div>
                <div class = "panel-usuario" id="panel_correo">
                    <p>Email: <br>gaelwar@gmail.com</p>
                </div>
                <div class = "panel-usuario" id="panel_direccion">
                    <p>Direccion: <br>DR oakland 5008</p>
                </div>
                <div class ="panel-usuario" id="panel_telefono">
                    <p>Telefono: <br>5590466778</p>
                </div>
            </div>
            <div class = "botones-usuario">
                <button type = "button" class = "btn_editar" onclick="window.location.href = 'editarUsuario.html' ">Editar Perfil</button>
                <br>
                <button type = "button" class = "btn_pedidos" onclick="window.location.href='misPedidos.html'">Ver pedidos</button>
                <button type="button" class = "btn_cerrarSesion">Cerrar Sesion</button>
            </div>
        </main>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>
