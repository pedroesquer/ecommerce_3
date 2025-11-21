<%-- 
    Document   : administrarPedidos
    Created on : Nov 18, 2025, 12:12:04 PM
    Author     : juanpheras
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./styles.css">
    </head>

    <body>
        <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
        <main>
            <div class="layout-admin">
                <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>
                <div class="contenido-general">
                    <div class = "botonRegresar">
                        <a href="./menuadministrador.jsp">
                            <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                        </a>
                    </div>
                    
                    <c:forEach var="pedido" items="${listaPedidos}">
                        <!--SERA CORRECTO EL HREF??? -->
                    <a href="modificar_pedido?idPedido=${pedido.id}" class="pedido-link">
                        <div class="pedido">
                            <div class="pedido-header">
                                <h2>Pedido #${pedido.numeroPedido}</h2>
                            </div>

                            <div class="pedido-body">
                                <div class="articulos-admin-pedido">
                                        <h3>Fecha :  ${pedido.fechaHora}</h3>
                                        <h3>Total $ ${pedido.total}</h3>
                                </div>

                            </div>
                        </div>
                    </a>
                    </c:forEach>
                    
                    <c:if test="${empty listaPedidos}">
                        <p>No se encontraron pedidos en la base de datos.</p>
                    </c:if>

                    </main>
                    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>

                    </body>

                    </html>