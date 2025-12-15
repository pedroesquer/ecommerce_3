document.addEventListener('DOMContentLoaded', () => {
    
    const params = new URLSearchParams(window.location.search);
    const categoriaId = params.get('categoriaId');

    if (categoriaId) {
        const radioCategoria = document.querySelector(`.filtro-categoria[value="${categoriaId}"]`);
        if (radioCategoria) {
            radioCategoria.checked = true;
        }
    }

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
        const categoriaSeleccionada = document.querySelector('.filtro-categoria:checked');
        const precioSeleccionado = document.querySelector('.filtro-precio:checked');

        const urlParams = new URLSearchParams(window.location.search);
        const nombreBusqueda = urlParams.get('nombre');

        if (marcaSeleccionada) {
            params.append('nombre', marcaSeleccionada.value);
        } else if (nombreBusqueda) {
            params.append('nombre', nombreBusqueda);
        }

        if (categoriaSeleccionada && categoriaSeleccionada.value !== "") {
            params.append('categoriaId', categoriaSeleccionada.value);
        }

        if (precioSeleccionado) {
            const min = precioSeleccionado.getAttribute('data-min');
            const max = precioSeleccionado.getAttribute('data-max');
            if (min) params.append('precioMin', min);
            if (max) params.append('precioMax', max);
        }

        // --- PETICIÓN ---
        if (params.toString()) {
            url += `?${params.toString()}`;
        }

        console.log("Consultando API:", url);

        const response = await fetch(url);
        if (!response.ok) throw new Error('Error API');

        const productos = await response.json();
        const contenedor = document.getElementById('contenedor-productos');
        contenedor.innerHTML = '';

        if (productos.length === 0) {
            contenedor.innerHTML = '<p>No se encontraron productos.</p>';
            return;
        }

        // Renderizar Tarjetas
        productos.forEach(producto => {
            const tarjeta = document.createElement('div');
            tarjeta.classList.add('producto-card');
            
            // Imagen segura
            const img = producto.rutaImagen || './imgs/default.png';

            tarjeta.innerHTML = `
                <img src="${img}" class="producto" 
                     alt="${producto.nombre}" onclick="verDetalle(${producto.id})" style="cursor:pointer;">

                <div class="texto">
                    <p class="nombre-producto" onclick="verDetalle(${producto.id})" style="cursor:pointer;">
                        ${producto.nombre}
                    </p>
                    <div class="precios">
                        <p class="precio">$${producto.precio}</p>

                    </div>
                    <div class="estrellas">
                        <p>4</p> 
                        <img src="./imgs/star.png"><img src="./imgs/star.png"><img src="./imgs/star.png"><img src="./imgs/star.png">
                    </div>
                </div>
            `;
            contenedor.appendChild(tarjeta);
        });

    } catch (error) {
        console.error('Error:', error);
        document.getElementById('contenedor-productos').innerHTML = '<p>Error al cargar productos.</p>';
    }
}

function verDetalle(id) {
    window.location.href = `producto.jsp?id=${id}`;
}