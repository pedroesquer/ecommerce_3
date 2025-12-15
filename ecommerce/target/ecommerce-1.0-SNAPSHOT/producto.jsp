<%-- 
    Document   : producto
    Created on : Nov 11, 2025, 6:30:24 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nombre de producto - Refacciones Morales</title>
    <link rel="stylesheet" href="./styles.css">
</head>


<body>
    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <header class="producto">
        
        <!-- El JS reemplaza este NOMBRE -->
        <h1 id="producto-nombre"></h1>
    </header>
    <main>
        <div class="contenedor-producto">
            <div class="calificacion">
                <span>★★★★☆</span>
                <a href="#opiniones">Ver opiniones</a>
            </div>
            <div class="imagen-producto">
                <!-- El JS reemplaza este src -->
                <img src="./imgs/llavero.jpg" alt="">
            </div>
            <div class="descripcion">
                <h2>Descripción</h2>
                <!-- Este p será reemplazado por el JS -->
                <p></p>
            </div>
            <div class="cuadro-compra">
                <!-- El JS reemplaza este precio -->
                <span></span>
                <!-- El JS modifica este texto a Disponible / Agotado -->
                <p class="estado">Disponible</p>
                <label for="cantidad">Cantidad:</label>
                <input type="number" id="cantidad" name="cantidad" min="1" max="10" value="1">
                <!--<a href="./carrito.jsp"> -->
                    <button class="btn-carrito" type="button">Agregar al carrito</button>
                <!--</a>-->
                <a href="./pago.jsp">
                    <button class="btn-comprar" type="submit">Comprar</button>
                </a>


            </div>
        </div>


        <div class="resenia">
            <h2>¡Comenta tu experiencia con este producto!</h2>
            <form class="form-resenia" id="formResenia">
                <div class="rating">
                    <label for="calificacion">Calificación</label>
                    <input type="number" id="calificacion" name="calificacion" min="1" max="5" placeholder="5" required>
                </div>




                <input type="text" name="opinion" id="opinion" required placeholder="Escribe tu opinión ">


               
               
                <button type="submit" class="btn-publicar">Publicar</button>
            </form>
        </div>
        <div id="opiniones">
            <h2>Opiniones de los usuarios</h2>
            <p>Cargando reseñas...</p>
        </div>




    </main>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
    <script src="./scripts/producto.js"></script>
</body>


</html>
