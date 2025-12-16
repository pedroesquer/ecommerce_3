<%-- 
    Document   : administrarReseñaProducto
    Created on : 19 nov 2025, 18:14:13
    Author     : ramonsebastianzamudioayala
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

            <div class="botonRegresar">
                <a href="cargarproducto?vista=adminResenias">
                    <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                </a>
            </div>

            <div class="contenedorProductosMoviles">
                <c:forEach var="resenia" items="${productoSeleccionado.reseñas}" varStatus="loop">
                    <div class="panelProducto" href='editarProducto.jsp'>
                        <p>resenia.usuario.nombre</p>
                        <p>resenia.comentario</p>
                        <p><Button><a href="./eliminarResenia?id=${resenia.id}"><img src="./imgs/trash.png" alt="" class="imgAccion"></a></Button></p>
                    </div>

                </c:forEach> 

                <c:if test="${empty productoSeleccionado.reseñas}">
                    <div class="panelProducto mensaje-vacio">
                        <p>No hay reseñas para este producto.</p>
                    </div>
                </c:if>


            </div>

            <div class="pagina-completa-productos">
                <main class="contenido-principal">
                    <h2>Reseñas para: ${productoSeleccionado.nombre}</h2>
                    <div class="contenedorTablaProductos">
                        <table class="tablaProductos">
                            <thead class="encabezadoTablaProductos">
                                <tr>
                                    <th>#</th>
                                    <th>Usuario</th>
                                    <th>Calificación</th>
                                    <th>Comentario</th>
                                    <th>Fecha</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="resenia" items="${productoSeleccionado.reseñas}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${resenia.usuario.nombre}</td> 
                                        <td>${resenia.estrellas} ★</td>
                                        <td>${resenia.comentario}</td>
                                        <td>${resenia.fecha}</td>
                                        <td>
                                            
                                                <a href='eliminarResenia?id=${resenia.id}'><img src="./imgs/trash.png" alt="Eliminar" class="imgAccion"></a>
                                            
                                        </td>
                                    </tr>
                                </c:forEach> 

                                <c:if test="${empty productoSeleccionado.reseñas}">
                                    <tr>
                                        <td colspan="6">Este producto no tiene reseñas.</td>
                                    </tr>
                                </c:if>


                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>
        <%@include file="./WEB-INF/fragmentos/nav-mobile.jspf" %>            
        <%@include file="./WEB-INF/fragmentos/footer.jspf"%>
    </body>

</html>