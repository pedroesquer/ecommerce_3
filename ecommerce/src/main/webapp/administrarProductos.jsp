<%-- 
    Document   : administrarProductos
    Created on : Nov 11, 2025, 6:20:59 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Administrar Productos</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>
        
            <header class="encabezado">
                <img src="./imgs/refaccionesMoralesFondoNegro.png" alt="" height="100" width="250">
            </header>
            <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
            <div class="layout-admin">
                <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>
                <div class="contenido-general">
                    <div class="botonRegresarAgregarProducto">
                        <a href="./menuadministrador.jsp">
                            <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                        </a>
                        <a href="${pageContext.request.contextPath}/AgregarProducto" class="btnAgregarProducto">Agregar Producto</a>
                    </div>

                    <h1 class="misProductos">Mis productos</h1>
                    <div class="contenedorProductosMovil">
                        <c:forEach var="p" items="${listaProductos}">
                            <a href="administrarReseñasProducto.jsp?idProducto=${p.id}" class="panelProducto" style="text-decoration:none; color:inherit;">
                                <p><img src="${pageContext.request.contextPath}/${p.rutaImagen}" alt="" class="imgAccion"></p>
                                <p>${p.nombre}</p>
                            </a>
                        </c:forEach>
                    </div>

                    <div class="pagina-completa-productos">

                        <div class="contenedorBarraLateral">
                            <aside class="filter-sidebar">
                                <h2>Filtros</h2>
                                <div class="filter-group">
                                    <h3>Marca</h3>
                                    <hr>
                                    <ul>
                                        <li>
                                            <input type="checkbox" id="marca-bosch" name="marca" value="bosch" checked>
                                            <label for="marca-bosch">Bosch</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" id="marca-ngk" name="marca" value="ngk">
                                            <label for="marca-ngk">NGK</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" id="marca-denso" name="marca" value="denso">
                                            <label for="marca-denso">Denso</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" id="marca-champion" name="marca" value="champion">
                                            <label for="marca-champion">Champion</label>
                                        </li>
                                    </ul>
                                </div>
                                <div class="filter-group">
                                    <h3>Categoría</h3>
                                    <hr>
                                    <ul>
                                        <li>
                                            <input type="checkbox" id="cat-motor" name="categoria" value="motor" checked>
                                            <label for="cat-motor">Motor</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" id="cat-suspension" name="categoria" value="suspension">
                                            <label for="cat-suspension">Suspensión</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" id="cat-filtros" name="categoria" value="filtros">
                                            <label for="cat-filtros">Filtros</label>
                                        </li>
                                        <li>
                                            <input type="checkbox" id="cat-interior" name="categoria" value="interior">
                                            <label for="cat-interior">Interior</label>
                                        </li>
                                    </ul>
                                </div>
                                <div class="filter-group">
                                    <h3>Precio</h3>
                                    <hr>
                                    <p class="price-subtitle">Rango de precio personalizado.</p>
                                    <div class="price-range-inputs">
                                        <input type="text" id="price-min" value="$0">
                                        <span>a</span>
                                        <input type="text" id="price-max" placeholder="Max">
                                    </div>
                                </div>
                            </aside>
                        </div>

                        <main class="contenido-principal">

                            <div class="contenedorTablaProductos">
                                <table class="tablaProductos">
                                    <thead class="encabezadoTablaProductos">
                                        <tr>
                                            <th>No.</th>
                                            <th>Imagen</th>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th>Disponibilidad</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="p" items="${listaProductos}" varStatus="i">
                                            <tr>
                                                <td>${i.index + 1}</td>

                                                <td>
                                                    <img src="${pageContext.request.contextPath}/${p.rutaImagen}" alt="img" width="60">
                                                </td>

                                                <td>${p.nombre}</td>

                                                <td>$${p.precio}</td>

                                                <td>${p.stock} unidades</td>

                                                <td>
                                                    <a href="editarProducto.jsp?id=${p.id}">
                                                        <img src="./imgs/edit.png" class="imgAccion" alt="">
                                                    </a>

                                                    <a href="EliminarProducto?id=${p.id}">
                                                        <img src="./imgs/trash.png" class="imgAccion" alt="">
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                            </div>

                        </main>
                    </div>
                </div>
            </div>
            <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>

</html>