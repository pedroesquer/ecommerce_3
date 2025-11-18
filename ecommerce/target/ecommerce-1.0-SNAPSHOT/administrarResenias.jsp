<%-- 
    Document   : administarResenias
    Created on : Nov 18, 2025, 12:23:53 PM
    Author     : juanpheras
--%>

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
            <div class = "botonRegresar">
                <a href="./menuadministrador.jsp">
                    <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                </a>
            </div>
            <div class="contenedorProductosMoviles">
                <div class=panelProducto  onclick="window.location.href = 'administrarReseñasProducto.html'">
                    <p><img src="./imgs/bujias.jpeg" alt="" class="imgAccion"></p>
                    <p>A-Premium Iridium Platinum Bujías compatibles con chevrolet colorado</p>
                </div>
                <div class=panelProducto>
                    <p><img src="./imgs/bujias.jpeg" alt="" class="imgAccion"></p>
                    <p>OXCANO 7092 - Bujía de iridio compatible con chevrolet</p>
                </div>
                <div class=panelProducto >
                    <p><img src="./imgs/bujias.jpeg" alt="" class="imgAccion"></p>
                    <p>Bosch 0242230530 / HR8NII332X Bujía de Iridio- Tecnología OE para Motores Modernos</p>
                </div>
                <div class="panelProducto">
                    <p><img src="./imgs/bujias.jpeg" alt="" class="imgAccion"></p>
                    <p>Mobil Aceite Premium 2025</p>
                </div>
                <div class=panelProducto>
                    <p><img src="./imgs/bujias.jpeg" alt="" class="imgAccion"></p>
                    <p>Aceite VTL Light Mediano</p>

                </div>
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
                                <tr>
                                    <td>1</td>
                                    <td><img src="./imgs/bujias.jpeg" class="imgProducto"></td>
                                    <td>A-Premium Iridium Platinum Bujías compatibles con chevrolet colorado</td>
                                    <td>$225.59</td>
                                    <td>30 unidades</td>
                                    <td><Button><img src="./imgs/rotores.png" alt="" class="imgAccion"
                                                     onclick="window.location.href = 'administrarReseñasProducto.html'"></Button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td><img src="./imgs/bujias2.png" class="imgProducto"></td>
                                    <td>OXCANO 7092 - Bujía de iridio compatible con chevrolet</td>
                                    <td>$325.59</td>
                                    <td>17 unidades</td>
                                    <td><Button><img src="./imgs/seleccionar.png" alt="" class="imgAccion"
                                                     onclick="window.location.href = 'administrarReseñasProducto.html'"></Button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td><img src="./imgs/bujias3.png" class="imgProducto"></td>
                                    <td>Bosch 0242230530 / HR8NII332X Bujía de Iridio- Tecnología OE para Motores Modernos
                                    </td>
                                    <td>$225.59</td>
                                    <td>40 unidades</td>
                                    <td><Button><img src="./imgs/seleccionar.png" alt="" class="imgAccion"
                                                     onclick="window.location.href = 'administrarReseñasProducto.html'"></Button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td><img src="./imgs/aceite1.png" class="imgProducto"></td>
                                    <td>Mobil Aceite Premium 2025</td>
                                    <td>$350.99</td>
                                    <td>85 unidades</td>
                                    <td><Button><img src="./imgs/seleccionar.png" alt="" class="imgAccion"
                                                     onclick="window.location.href = 'administrarReseñasProducto.html'"></Button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td><img src="./imgs/aceite2.png" class="imgProducto"></td>
                                    <td>Aceite VTL Light Mediano</td>
                                    <td>$280.00</td>
                                    <td>50 unidades</td>
                                    <td><Button><img src="./imgs/seleccionar.png" alt="" class="imgAccion"
                                                     onclick="window.location.href = 'administrarReseñasProducto.html'"></Button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                </main>
            </div>
        </div>

        <%@include file ="./WEB-INF/fragmentos/footer.jspf"%>
    </body>

</html>
