<%-- 
    Document   : index
    Created on : Nov 11, 2025, 6:08:25 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Refacciones Morales</title>
    <link rel="stylesheet" href="./styles.css">
</head>

<body>
    <%@include file="./WEB-INF/fragmentos/navBar.jspf" %>
    <header class="encabezado">
    </header>
    <main>
        <div class="presentacion">
            <img src="./imgs/imagenPresentacion.png">
            <aside class="ofertas">
                <h2>¡OFERTAS!</h2>

                <div class="oferta-card">
                    <img src="./imgs/llantas.png" alt="Llantas">
                    <p>Llantas Michelin</p>
                    <p class="precio-anterior">de: $1,899.99</p>
                    <p class="precio-oferta">a: $1,599.99</p>
                </div>

                <div class="oferta-card">
                    <img src="./imgs/bateria.png" alt="Batería">
                    <p class="precio-anterior">de: $1,899.99</p>
                    <p>Bateria LTH</p>
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
