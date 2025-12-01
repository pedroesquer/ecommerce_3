<%-- 
    Document   : administrarResenias
    Created on : Nov 18, 2025, 12:23:53 PM
    Author     : juanpheras
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrar reseñas</title>
    <link rel="stylesheet" href="./styles.css">
</head>

<body>

    <header class="encabezado">
        <img src="./imgs/refaccionesMoralesFondoNegro.png" alt="" height="100" width="250">
    </header>

    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>

    <div class="layout-admin">

        <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>

        <div class="contenido-general">

            <div class="botonRegresar">
                <a href="./menuadministrador.jsp">
                    <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                </a>
            </div>

            <div class="contenedorProductosMoviles">
                <c:forEach var="p" items="${listaProductos}">
                    <a href="administrarReseniasProducto?idProducto=${p.id}" class="panelProducto" style="text-decoration:none; color:inherit;">
                        <p><img src="${pageContext.request.contextPath}/${p.rutaImagen}" class="imgAccion"></p>
                        <p>${p.nombre}</p>
                    </a>
                </c:forEach>
            </div>

            <div class="pagina-completa-productos">
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
                                            <img src="${pageContext.request.contextPath}/${p.rutaImagen}" class="imgProducto">
                                        </td>

                                        <td>${p.nombre}</td>

                                        <td>$${p.precio}</td>

                                        <td>${p.stock} unidades</td>

                                        <td>
                                            <a href="administrarReseniasProducto?idProducto=${p.id}">
                                                <img src="./imgs/seleccionar.png" alt="ver" class="imgAccion">
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
    <%@include file="./WEB-INF/fragmentos/nav-mobile.jspf" %>    
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>

</body>

</html>
