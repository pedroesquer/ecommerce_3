<%-- 
    Document   : borrarProducto
    Created on : Nov 20, 2025, 2:53:05 AM
    Author     : pedro
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Borrar Producto</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <div class="layout-admin">
            <div class="aside-administrador">
                <aside class="menu-administrador">
                    <ul>
                        <li><a href="./administrarProductos.html">Administrar productos</a></li>
                        <li><a href="./administrarReseñas.html">Administrar reseñas</a></li>
                        <li><a href="./administrarUsuarios.html">Administrar usuarios</a></li>
                        <li><a href="./administrarPedidos.html">Administrar Pedidos</a></li> 
                    </ul>
                </aside>
            </div>
            <div class="contenido-general">
                <div class="botonRegresar">
                    <a href="cargarproducto?vista=adminProducto">
                        <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                    </a>
                </div>
                <h1>Borrar Producto</h1>

                <c:if test="${not empty error}">
                    <p style="color: red;">${error}</p>
                </c:if>

                <div>
                    <form class="form-agregar-producto" action="borrarproducto" method="POST">
                        <input type="hidden" name="idProducto" value="${param.id}">
                        <input type="hidden" name="nombre" value="${producto.nombre}">
                        <label for="pregunta">¿Desea eliminar este producto?</label>
                        <br>
                        <label for="nombre">Nombre del producto</label>
                        <br>
                        <br>
                        <a href="cargarproducto?vista=adminProducto" class="btn-cancelar">Cancelar</a>
                        <button type="submit">Eliminar Producto</button>

                    </form>
                </div>
            </div>
        </div>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>