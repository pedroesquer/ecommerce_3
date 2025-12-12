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
                <label><input type="checkbox" checked> Boschk</label><br>
                <label><input type="checkbox"> NGK</label><br>
                <label><input type="checkbox"> Denso</label><br>
                <label><input type="checkbox"> Champion</label><br>


                <p class="titulo-filtro">Categoria</p>
                <hr>
                <label><input type="checkbox" checked> Platino</label><br>
                <label><input type="checkbox"> Cobre</label><br>
                <label><input type="checkbox"> Iridio</label><br>


                <p class="titulo-filtro">Precio</p>
                <hr>
                <label><input type="checkbox" checked> 100-300</label><br>
                <label><input type="checkbox"> 300-500</label><br>
                <label><input type="checkbox"> 500-800</label><br>
            </aside>
            
                <div id="contenedor-productos" class="grid-productos">
                    <!-- Aquí se cargarán las tarjetas desde la API -->
                </div>
            </div>
    </main>

    </div>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    <script src="./scripts/productos.js"></script>
</body>


</html>
