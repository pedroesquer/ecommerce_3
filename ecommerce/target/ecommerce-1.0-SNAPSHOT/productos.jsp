<%-- 
    Document   : productos
    Created on : Nov 11, 2025, 6:30:54 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" href="styles.css">
</head>


<body>
    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <main>
        <div class="principal">
            <aside class="filtros">
                <p class="filtroP">Filtros</p>
                <p class="titulo-filtro">Marca</p>
                <hr>
                <label><input type="checkbox" class="filtro-marca" value="Bosch"> Bosch</label><br>
                <label><input type="checkbox" class="filtro-marca" value="NGK"> NGK</label><br>
                <label><input type="checkbox" class="filtro-marca" value="Denso"> Denso</label><br>
                <label><input type="checkbox" class="filtro-marca" value="Champion"> Champion</label><br>


                <p class="titulo-filtro">Categoria</p>
                <hr>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="1"> Miscelaneos</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="2"> Electrico y Encendido</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="3"> Iluminacion</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="4"> Bujías</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="5"> Llantas</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="6"> Frenos</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="7"> Transmicion</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="8"> Accesorios</label><br>
                <label><input type="radio" name="categoria" class="filtro-categoria" value="" checked> Ver todas</label><br>


                <p class="titulo-filtro">Precio</p>
                <hr>
                <label><input type="radio" name="precio" class="filtro-precio" data-min="100" data-max="300"> $100 - $300</label><br>
                <label><input type="radio" name="precio" class="filtro-precio" data-min="300" data-max="500"> $300 - $500</label><br>
                <label><input type="radio" name="precio" class="filtro-precio" data-min="500" data-max="800"> $500 - $800</label><br>
                <label><input type="radio" name="precio" class="filtro-precio" data-min="" data-max="" checked> Cualquier precio</label><br>
            </aside>
            
                <div id="contenedor-productos" class="grid-productos">
                    <!-- Aquí se cargarán las tarjetas desde la API -->
                </div>
            </div>
    </main>

    </div>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    <script defer src="${pageContext.request.contextPath}/scripts/productos.js"></script>
</body>


</html>
