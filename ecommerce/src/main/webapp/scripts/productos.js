/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', () => {
    cargarProductos();

    const inputsFiltros = document.querySelectorAll('.filtros input');
    inputsFiltros.forEach(input => {
        input.addEventListener('change', cargarProductos);
    });
});

async function cargarProductos() {
    try {

        let url = 'http://localhost:8080/API_ecommerce/api/productos';
        const params = new URLSearchParams();

        const marcaSeleccionada = document.querySelector('.filtro-marca:checked');
        if (marcaSeleccionada) {
            params.append('nombre', marcaSeleccionada.value);
        }

        const categoriaSeleccionada = document.querySelector('.filtro-categoria:checked');
        if (categoriaSeleccionada && categoriaSeleccionada.value !== "") {
            params.append('categoriaId', categoriaSeleccionada.value);
        }

        const precioSeleccionado = document.querySelector('.filtro-precio:checked');
        if (precioSeleccionado) {
            const min = precioSeleccionado.getAttribute('data-min');
            const max = precioSeleccionado.getAttribute('data-max');
            
            if (min) params.append('precioMin', min);
            if (max) params.append('precioMax', max);
        }

        if (params.toString()) {
            url += `?${params.toString()}`;
        }

        console.log("Consultando API:", url); // Para depuración

        const response = await fetch(url);

        if (!response.ok) {
            throw new Error('Error al obtener productos');
        }

        const productos = await response.json();
        const contenedor = document.getElementById('contenedor-productos');

        contenedor.innerHTML = ''; // Limpiar contenedor

        if (productos.length === 0) {
            contenedor.innerHTML = '<p>No se encontraron productos con esos filtros.</p>';
            return;
        }

        productos.forEach(producto => {
            const tarjeta = document.createElement('div');
            tarjeta.classList.add('producto-card');

            const imagenSrc = producto.rutaImagen ? producto.rutaImagen : './imgs/default.png';

            tarjeta.innerHTML = `
                <img src="${imagenSrc}" class="producto" 
                     alt="${producto.nombre}" onclick="verDetalle(${producto.id})" style="cursor:pointer;">

                <div class="texto">
                    <p class="nombre-producto" onclick="verDetalle(${producto.id})" style="cursor:pointer;">
                        ${producto.nombre}
                    </p>
                    
                    <div class="precios">
                        <p class="precio">$${producto.precio}</p>
                        <button class="btn-agregar" onclick="agregarAlCarrito(${producto.id})">
                            <p class="buttonP">Agregar al carrito</p>
                        </button>
                    </div>

                    <div class="estrellas">
                        <p>4</p> <img src="./imgs/star.png">
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
            '<p>Error al cargar los productos. Asegúrate de que el servidor esté encendido.</p>';
    }
}

function verDetalle(id) {
    window.location.href = `producto.jsp?id=${id}`;
}