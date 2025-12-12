/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', () => {
    cargarProductos();
});

async function cargarProductos() {
    try {
        const response = await fetch('http://localhost:8080/API_ecommerce/api/productos');

        if (!response.ok) {
            throw new Error('Error al obtener productos');
        }

        const productos = await response.json();
        const contenedor = document.getElementById('contenedor-productos');

        contenedor.innerHTML = ''; 

        productos.forEach(producto => {
            const tarjeta = document.createElement('div');
            tarjeta.classList.add('producto-card');

            tarjeta.innerHTML = `
                <img src="${producto.rutaImagen}" class="producto" 
                     alt="${producto.nombre}" onclick="verDetalle(${producto.id})" style="cursor:pointer;">

                <div class="texto">
                    <p class="nombre-producto" onclick="verDetalle(${producto.id})" style="cursor:pointer;">
                        ${producto.nombre}
                    </p>
                    
                    <div class="precios">
                        <p class="precio">$${producto.precio}</p>
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
            `;

            contenedor.appendChild(tarjeta);
        });

    } catch (error) {
        console.error('Error:', error);
        document.getElementById('contenedor-productos').innerHTML =
            '<p>Error al cargar los productos.</p>';
    }
}

function verDetalle(id) {
    window.location.href = `producto.jsp?id=${id}`;
}
