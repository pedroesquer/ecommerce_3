<%-- 
    Document   : adminisrarPedidoIndividual
    Created on : 18 nov 2025, 07:31:51
    Author     : ramonsebastianzamudioayala
--%>

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
                            <a href="./producto.jsp"><img src="./imgs/llavero.jpg" alt=""></a>
                            <a href="./producto.jsp"><img src="./imgs/aceite.png" alt=""></a>
                        </div>
                    </div>
                </div>
                <div class="datos-pedido">
                    <ul>
                        <li>Juan Pablo Heras</li>
                        <li>Realizado el 28/07/2025</li>
                        <li><span>Dirección</span>:</li>
                        <li>Del agua azul. #115 Casa Naranja.  CASA BLANCA, CIUDAD OBREGÓN SONORA, 85140 MÉXICO</li>
                        <li> <span>Total:</span> $456</li>
                    </ul>
                    <form action="modificar_pedido" method="POST">
                        <label for="estado-pedido">Estado del pedido</label>
                        <select name="estado-pedido" id="estado">
                            <option value="entregado">Entregado</option>
                            <option value="enviado">En camino</option>
                            <option value="porenviar">Por enviar</option>
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
