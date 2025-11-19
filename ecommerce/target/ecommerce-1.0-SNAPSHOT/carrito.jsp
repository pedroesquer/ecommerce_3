<%-- 
    Document   : carrito
    Created on : Nov 11, 2025, 6:24:28 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Tu Carrito</title>
    <link rel="stylesheet" href="./styles.css" />
  </head>
  <body>
    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <main class="main">
      <h1 class="labelMiCarrito">Mi carrito</h1>


      <div class="carritoGridDesktop">


        <div class="contenedorProductos">
            <div class="producto1">
                <img src="./imgs/llavero.jpg">
                <div class="infoProducto1">
                    <h3>Llavero Nissan</h3>
                    <h3>Precio: $110</h3>
                    <select class="seleccionarCantidad">
                        <option value="1">Cantidad: 1</option>
                        <option value="2">Cantidad: 2</option>
                        <option value="3">Cantidad: 3</option>
                    </select>
                    <h3>Importe: $110</h3>
                    <button class="btnEliminar">Eliminar</button>
                </div>
            </div>
        </div>




        <div class="contenedorPago">
            <h1 class="txtTotalProductos">Total de Productos: 1</h1>
            <h1 class="txtSubtotal">Subtotal: $110.00</h1>
            <button type="button" class="btnPagar" href='pago.html'">Proceder a Pago</button>
        </div>


    </div>
    </main>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
  </body>
</html>




