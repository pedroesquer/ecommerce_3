<%-- 
    Document   : editarProducto
    Created on : Nov 11, 2025, 6:25:05 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Producto</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <div class="layout-admin">
            <div class="aside-administrador">
                <aside class="menu-administrador">
                    <ul>
                        <li><a href="./administrarProductos.jsp">Administrar productos</a></li>
                        <li><a href="./administrarReseñas.jsp">Administrar reseñas</a></li>
                        <li><a href="./administrarUsuarios.jsp">Administrar usuarios</a></li>
                        <li><a href="./administrarPedidos.jsp">Administrar Pedidos</a></li> 
                    </ul>
                </aside>
            </div>
            <div class="contenido-general">
                <div class="botonRegresar">
                    <a href="cargarproducto?vista=adminProducto">
                        <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                    </a>
                </div>
                <h1>Editar Producto</h1>
                
                <c:if test="${not empty error}">
                    <p style="color: red;">${error}</p>
                </c:if>

                <div>
                    <form class="form-agregar-producto" action="EditarProducto" method="post" enctype="multipart/form-data">
                        <div class="form-div">
                            <input type="hidden" name="id" value="${producto.id}">
                            <input type="hidden" name="rutaImagenActual" value="${producto.rutaImagen}">
                        </div>
                        
                        <div class="form-div">
                            <label>Imagen Actual:</label>
                            <br>
                            <img src="${producto.rutaImagen}" alt="Imagen del producto" width="100" style="margin-top: 10px; border: 1px solid #ddd; padding: 5px;">
                        </div>

                        <div class="form-div">    
                            <label for="imagen">Cambiar imagen (Opcional)</label>
                            <br>
                            <input type="file" id="imagen" name="imagen" accept="image/*">
                        </div>

                        <div class="form-div">    
                            <label for="nombre">Nombre del producto</label>
                            <br>
                            <input type="text" id="nombre" name="nombre" value="${producto.nombre}" required>
                        </div>

                        <div class="form-div">
                            <label for="desc">Descripción del producto</label>
                            <br>
                            <input type="text" id="desc" name="desc" value="${producto.descripcion}">
                        </div>

                        <div class="form-div">
                            <label for="precio">Precio del producto</label>
                            <br>
                            <input type="number" id="precio" name="precio" step="0.01" value="${producto.precio}" required>
                        </div>

                        <div class="form-div">    
                            <label for="stock">Stock del producto</label>
                            <br>
                            <input type="number" id="stock" name="stock" value="${producto.stock}" required>
                        </div>

                        <div class="form-div">
                            <label for="categoria">Seleccione una categoría</label>
                            <br>
                            <select name="categoria" id="categoria" required>
                                <option value="" disabled>-- Selecciona una categoría --</option>
                                <c:forEach var="cat" items="${categorias}">
                                    <%-- Lógica para pre-seleccionar la categoría actual del producto --%>
                                    <option value="${cat.id}" ${cat.id == producto.categoria.id ? 'selected' : ''}>
                                        ${cat.nombre}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-div">
                            <button type="submit">Actualizar Producto</button>
                            <a href="./menuadministrador.jsp" style="text-decoration: none;">
                                <button type="button" style="background-color: #666; margin-left: 10px;">Cancelar</button>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>