<%-- 
    Document   : usuario
    Created on : Nov 11, 2025, 6:31:34 PM
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
        <header class ="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt=""height="100" width="250">
        </header>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <main>
        <div class = "botonRegresar">
            <a href="./index.jsp">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
        </div>
            <div class = "foto_usuario">
                <img src="./imgs/foto_usuario.png" alt="" height="100" width="100">
                <h1 class= "h1-usuario">Mi perfil</h1>
            </div>
            <div class = "info-usuario">
                <div class = "panel-usuario" id="panel_nomnre">
                    <p>Nombre: <br></p>
                </div>
                <div class = "panel-usuario" id="panel_correo">
                    <p>Email: <br></p>
                </div>
                <div class = "panel-usuario" id="panel_direccion">
                    <p>Dirección: <br></p>
                </div>
                <div class ="panel-usuario" id="panel_telefono">
                    <p>Teléfono: <br></p>
                </div>
            </div>
            <form class = "botones-usuario" method="GET" action="logout">
                <button type = "button" class = "btn_editar">Editar perfil</button>
                <br>
                <button type = "button" class = "btn_pedidos" href='misPedidos.jsp'>Ver pedidos</button>
                <button type="submit" class= "btn_cerrarSesion" >Cerrar sesión</button>
            </form>
        </main>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
        <script defer src="${pageContext.request.contextPath}/scripts/usuario.js"></script>
    </body>
</html>
