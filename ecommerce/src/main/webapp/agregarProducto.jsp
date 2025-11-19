<%-- 
    Document   : agregarProducto
    Created on : Nov 11, 2025, 6:23:16 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>agregar Productos</title>
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
                <div class = "botonRegresar">
                    <a href="./menuadministrador.html">
                        <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                    </a>
                </div>
                <h1>Agrega un producto nuevo</h1>
                <div>
                    <form class = "form-agregar-producto">
                        <label for="imagen">Sube la imagen del producto</label>
                        <br>
                        <input type="file" id="imagen" name="imagen" accept="image/*" required>
                        <br>
                        <label for="nombre">Nombre del producto</label>
                        <br>
                        <input type="text" id="nombre" name="nombre" required>
                        <br>
                        <label for="precio">Precio del producto</label>
                        <br>
                        <input type="number" id="precio" name="precio" step="0.01" required>
                        <br>
                        <label for="stock">Stock del producto</label>
                        <br>
                        <input type="number" id="stock" name="stock" required>
                        <br>
                        <button type="submit">Agregar Producto</button>
                        <button type="reset">Cancelar</button>
                    </form>
                </div>

            </div>
        </div>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>