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
    <nav class="navbar">
        <div class="logo">
            <a href="./index.jsp">
                <img src="./imgs/svg/logoBlanco.svg" alt="logoRefacciones morales">
            </a>
        </div>

        <div class="nav-categoria">
            <select name="sel_account" id="sel_account" required>
                <option value="">Categoría</option>
                <option value="aceites">Aceites</option>
                <option value="iluminado">Iluminado</option>
                <option value="llantas">Llantas</option>
                <option value="frenos">Frenos</option>
                <option value="iluminacion">Iluminación</option>
                <option value="electrico">Eléctrico y encendido</option>
                <option value="accesorios">Accesorios</option>
                <option value="miscelaneos">Misceláneos</option>
            </select>
        </div>

        <div class="buscador">
            <form class="busqueda" action="/search" method="get">
                <input type="search" id="search-input" name="barraBusqueda" placeholder="Busca tus refacciones">
                <a href="productos.jsp" class="btn-buscar">
                    <img src="./imgs/lupaBuscar.png" alt="Buscar">
                </a>
            </form>

        </div>

        <div class="nav-icons">
            <ul>
                <li><a href="./carrito.jsp"> <img src="./imgs/svg/carrito.svg"></a></li>
                <li><a href="./perfil.jsp"><img src="./imgs/svg/perfil.svg"></a></li>
            </ul>
        </div>  
    </nav>
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
    <footer>
        <div class="logo-footer">
            <img src="./imgs/svg/logoBlanco.svg" alt="">
            <p>Rinden más y nunca se rinden</p>
            <p>©2025 Refacciones Morales S.A. de C.V.</p>
        </div>

        <div class="contacto">
            <h3>Contáctanos</h3>
            <ul class="social-links">
                <li><a href="https://www.whatsapp.com/"><img src="./imgs/svg/whatsappLogo.svg" alt="WhatsApp"></a></li>
                <li><a href="https://www.instagram.com/"><img src="./imgs/svg/instaLogo.svg" alt="Instagram"></a>
                </li>
                <li><a href="https://www.facebook.com/"><img src="./imgs/svg/facebookLogo.svg" alt="Facebook"></a></li>
                <li><a href="https://mail.google.com/"><img src="./imgs/svg/gmailLogo.svg" alt="Correo"></a></li>
            </ul>

        </div>

        <div class="avisos">
            <ul class="legal-links">
                <li><a href="">Términos y condiciones</a></li>
                <li><a href="">Aviso de privacidad</a></li>
                <li><a href="">Políticas de cookies</a></li>
            </ul>
        </div>
    </footer>
</body>

</html>
