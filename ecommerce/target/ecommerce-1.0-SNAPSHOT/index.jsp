<%-- 
    Document   : index
    Created on : Nov 11, 2025, 6:08:25 PM
    Author     : pedro
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Refacciones Morales</title>
    <link rel="stylesheet" href="./styles.css">
</head>

<body>
    <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
    <header class="encabezado"></header>
    <main>
        <div class="presentacion">
            <div class="llantero-main">
                <div class="llantero-info">
                    <h1>Rinden más y nunca se rinden</h1>
                    <p>Refacciones que acompañan cada kilometro de tu camino</p>
                    <button><a href="./productos.html">Explorar refacciones</a></button>
                </div>
                <div class="imagen-llantero">
                    <img src="./imgs/imgLlantero.png" alt="hombre mecánico sonriendo">
                </div>
            </div>
            <aside class="ofertas">
                <h2>¡OFERTAS!</h2>
                <div class="oferta-card">
                    <img src="./imgs/llantas.png" alt="Llantas">
                    <p class="nombre-oferta">Hankook Kinergy ST 185/60 R14</p>
                    <p class="precio-anterior">de: $1,899.99</p>
                    <p class="precio-oferta">a: $1,599.99</p>
                </div>
                <div class="oferta-card">
                    <img src="./imgs/bateria.png" alt="Batería">
                    <p class="nombre-oferta">Batería AC Delco 12V 60Ah</p>
                    <p class="precio-anterior">de: $1,899.99</p>
                    <p class="precio-oferta">a: $1,599.99</p>
                </div>
            </aside>
        </div>
        <section class="categorias">
            <h2>Categorías más buscadas</h2>
            <div class="grid-categorias">
                <div class="categoria">
                    <img src="./imgs/aceites.png" alt="Aceites">
                    <p>Aceites</p>
                </div>
                <div class="categoria">
                    <img src="./imgs/filtros.png" alt="Filtro de aceite">
                    <p>Filtro de aceite</p>
                </div>
                <div class="categoria">
                    <img src="./imgs/balatas.png" alt="Balatas">
                    <p>Balatas</p>
                </div>
                <div class="categoria">
                    <img src="./imgs/bateria.png" alt="Baterías">
                    <p>Baterías</p>
                </div>
                <div class="categoria">
                    <img src="./imgs/rotores.png" alt="Rotores">
                    <p>Rotores</p>
                </div>
                <div class="categoria">
                    <img src="./imgs/bujias.png" alt="Bujías">
                    <p>Bujías</p>
                </div>
            </div>
        </section>
    </main>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>

</body>
</html>