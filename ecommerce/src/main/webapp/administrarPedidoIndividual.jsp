<%-- 
    Document   : adminisrarPedidoIndividual
    Created on : 18 nov 2025, 07:31:51
    Author     : ramonsebastianzamudioayala
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administar Pedido #X - Refaccionese Morales</title>
    <link rel="stylesheet" href="./styles.css">
</head>

<body>

    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <c:set var="p" value="${pedidoIndividual}"/> <%-- Alias para simplificar el código --%>
    <main>
        <div class="layout-admin">
            <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>
            <div class="pedido-individual">
                <div class="contenedor-articulos-pedido">
                    <div class="pedido-header">
                        <h2>Artículos</h2>
                    </div>

                    <div class="pedido-body">
                        <div class="articulos">
                            <c:forEach var="detalle" items="${p.detallesPedido}">
                                <a href="./producto.jsp?id=${detalle.producto.id}">
                                    <img src="${detalle.producto.rutaImagen}" alt="${detalle.producto.nombre}">
                                    <p>x${detalle.cantidad} - ${detalle.producto.nombre}</p>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="datos-pedido">
                    <ul>
                        <li><Strong>Cliente:</Strong> ${p.usuario.nombre}</li>
                        <li><Strong>Realizado el:</Strong> ${p.fechaHora}</li>
                        <li><span>Dirección</span>:</li>
                        <li>${p.direccion}</li>
                        <li> <span>Total:</span> $${p.total}</li>
                    </ul>
                    <form action="modificar_pedido" method="POST">
                        <input type="hidden" name="idPedido" value="${p.id}">
                        <label for="estado-pedido">Estado del pedido: <Strong>${p.estado}</Strong></label>
                        <select name="estado-pedido" id="estado">
                            <option value="ENTREGADO">Entregado</option>
                            <option value="ENVIADO">Enviado</option>
                            <option value="PREPARANDO">Preparando</option>
                            <option value="CANCELADO">Cancelado</option>
                        </select>
                        <br>
                        <button type="submit">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
</body>

</html>
