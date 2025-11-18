<%-- 
    Document   : editarProducto
    Created on : Nov 11, 2025, 6:25:05 PM
    Author     : pedro
--%>

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
        <div class = "botonRegresar">
            <a href="./administrarProductos.html">
                <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
            </a>
        </div>
        <h1 class ="h1titulo">Editar Producto</h1>




       


       <div class="pagina-completa">


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
                        <tr>
                            <td>1</td>
                            <td></td>
                            <td>A-Premium Iridium Platinum Bujías compatibles con chevrolet colorado</td>
                            <td>$225.59</td>
                            <td>30 unidades</td>
                            <td><Button><img src="./imgs/edit.png" alt="" class = "imgAccion" onclick="window.location.href ='editarProducto.html'"></Button> <button><img src="./imgs/trash.png" class = "imgAccion" alt=""></button></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td></td>
                            <td>OXCANO 7092 - Bujía de iridio compatible con chevrolet</td>
                            <td>$325.59</td>
                            <td>17 unidades</td>
                            <td><Button><img src="./imgs/edit.png" alt="" class = "imgAccion" onclick="window.location.href ='editarProducto.html'"></Button> <button><img src="./imgs/trash.png" class = "imgAccion" alt=""></button></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td></td>
                            <td>Bosch 0242230530 / HR8NII332X Bujía de Iridio- Tecnología OE para Motores Modernos</td>
                            <td>$225.59</td>
                            <td>40 unidades</td>
                            <td><Button><img src="./imgs/edit.png" alt="" class = "imgAccion" onclick="window.location.href ='editarProducto.html'"></Button> <button><img src="./imgs/trash.png" class = "imgAccion" alt=""></button></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td></td>
                            <td>Mobil Aceite Premium 2025</td>
                            <td>$350.99</td>
                            <td>85 unidades</td>
                            <td><Button><img src="./imgs/edit.png" alt="" class = "imgAccion" onclick="window.location.href ='editarProducto.html'"></Button> <button><img src="./imgs/trash.png" class = "imgAccion" alt=""></button></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td></td>
                            <td>Aceite VTL Light Mediano</td>
                            <td>$280.00</td>
                            <td>50 unidades</td>
                            <td><Button><img src="./imgs/edit.png" alt="" class = "imgAccion" onclick="window.location.href ='editarProducto.html'"></Button> <button><img src="./imgs/trash.png" class = "imgAccion" alt=""></button></td>
                        </tr>
                    </tbody>
                </table>
            </div>


        </main>
        </div>


        <div class = "contendorpadre">
            <div class = "contenido">
                <form class = formEditarProducto>
                    <p>Icono: <img src="./imgs/bujias.jpeg" alt="" class = "img-bujia"><button class = "btn-trash"><img src="./imgs/trash.png" alt="" class = "img-trash"></button></p>
                    <label for="nombreProducto">Nombre:</label>
                    <input type="text" name = "nombreProducto" id = "nombreProducto">
                    <br>
                    <label for="precio">Precio:</label>
                    <input type="text" name = "precio" id = "precio">
                    <br>
                    <label for="stock">Stock:</label>
                    <input type="text" name = "stock" id = "stock">
                    <br>
                    <button type="submit">Confirmar</button>
                    <button type="submit">Eliminar Producto</button>
                </form>
            </div>
        </div>
         <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    </body>
</html>


