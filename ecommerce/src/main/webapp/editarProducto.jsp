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
        <header class ="encabezado">
            <img src="./imgs/refaccionesMoralesFondoNegro.png" alt=""height="100" width="250">
        </header>
        <nav class="navbar-usuario">
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

            <form class="busqueda" action="/search" method="get">
                <input type="search" id="search-input" name="barraBusqueda" placeholder="Busca tus refacciones">
                <button type="submit" label="Buscar">
                    <img src="./imgs/lupaBuscar.png" alt="Buscar">
                </button>
            </form>

            <div class="nav-icons">
                <ul>
                    <li><p>Administrador</p></li>
                    <li><a href="./perfil.jsp"><img src="./imgs/svg/perfil.svg"></a></li>
                </ul>
            </div>
        </nav>

        <h1>Editar Producto</h1>
        <div class = "contenido">
            <p>Icono: <img src="./imgs/bujias.jpeg" alt=""><button><img src="./imgs/trash.png" alt=""></button></p>
            <p>Nombre: A-Premium Iridium Platinum Bujías compatibles con chevrolet colorado <button><img src="./imgs/edit.png" alt=""></button></p>
            <p>Precio: $225.59 <button><img src="./imgs/edit.png" alt=""></button></p>
            <p>Stock: 40 unidades <button><img src="./imgs/edit.png" alt=""></button></p>
        </div>
        
        <div class = "botones">
            <button class = "GuardarProducto">GuardarProducto</button>
            <button class = "eliminarProducto">eliminarProducto</button>
        </div>


        <div class = "zonaCancelarRegister">    
            <hr>
            <button type="button" class = "btn-cancelar" onclick="window.location.href='administrarProductos.jsp'">Cancelar</button>
        </div>

        <footer class = "footer">
            <div class="logo-footer">
                <img src="./imgs/svg/logoBlanco.svg" alt="">
                <p>Rinden más y nunca se rinden</p>
                <p>©2025 Refacciones Morales S.A. de C.V.</p>
            </div>

            <div class="contacto">
                <h3>Contáctanos</h3>
                <ul class="social-links">
                    <li><a href="https://www.whatsapp.com/"><img src="./imgs/svg/whatsappLogo.svg" alt="WhatsApp"></a></li>
                    <li><a href="https://www.instagram.com/"><img src="./imgs/svg/instagramLogo.svg" alt="Instagram"></a>
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