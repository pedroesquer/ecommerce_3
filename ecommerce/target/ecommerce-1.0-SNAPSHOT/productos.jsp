<%-- 
    Document   : productos
    Created on : Nov 11, 2025, 6:30:54 PM
    Author     : pedro
--%>

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
            <div class="grid-productos">
                    <div class="producto-card">
                        <img src="./imgs/aceite1.png" class="producto">
                        <div class="texto">
                            <p class="nombre-producto">Aceite multigrado Mineral SAE 25W</p>
                            <div class="precios">
                                <p class="precio">$135.78</p>
                                <button class="btn-agregar">
                                    <p class="buttonP">Agregar al carrito</p>
                                </button>
                            </div>
                            <div class="estrellas">
                                <p>4</p>
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                            </div>
                        </div>
                    </div>
                    <div class="producto-card">
                        <img src="./imgs/aceite2.png" class="producto">
                        <div class="texto">
                            <p class="nombre-producto">Aceite premium Akron</p>
                            <div class="precios">
                                <p class="precio">$265.26</p>
                                <button class="btn-agregar">
                                    <p class="buttonP">Agregar al carrito</p>
                                </button>
                            </div>
                            <div class="estrellas">
                                <p>4</p>
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                            </div>
                        </div>
                    </div>
                    <div class="producto-card">
                        <img src="./imgs/aceite3.png" class="producto">
                        <div class="texto">
                            <p class="nombre-producto">Aceite Mobil Alto Kilometraje</p>
                            <div class="precios">
                                <p class="precio">$635.55</p>
                                <button class="btn-agregar">
                                    <p class="buttonP">Agregar al carrito</p>
                                </button>
                            </div>
                            <div class="estrellas">
                                <p>4</p>
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                            </div>
                        </div>
                    </div>
                    <div class="producto-card">
                        <img src="./imgs/aceite4.png" class="producto">
                        <div class="texto">
                            <p class="nombre-producto">Aceite Mobil 5W-20</p>
                            <div class="precios">
                                <p class="precio">$699.99</p>
                                <button class="btn-agregar">
                                    <p class="buttonP">Agregar al carrito</p>
                                </button>
                            </div>
                            <div class="estrellas">
                                <p>4</p>
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                                <img src="./imgs/star.png">
                            </div>
                        </div>
                    </div>
            </div>
    </main>

    </div>
    <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
</body>


</html>
