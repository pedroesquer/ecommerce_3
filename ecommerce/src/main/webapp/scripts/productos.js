/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//mostrar todos los productos
document.addEventListener('DOMContentLoaded', () => {
    cargarProductos();
});

async function cargarProductos() {
    try {
        // 1. Llamar a la API que definiste en ProductosResource.java
        // Asegúrate de que la ruta sea correcta según tu configuración del servidor (ej: /ecommerce/api/productos)
        const response = await fetch('api/productos'); 
        
        if (!response.ok) {
            throw new Error('Error al obtener productos');
        }

        const productos = await response.json(); // Esto convierte el JSON a objetos de JS
        const contenedor = document.getElementById('contenedor-productos');
        
        contenedor.innerHTML = ''; // Limpiar contenedor por si acaso

        // 2. Recorrer la lista de productos (ProductoDTO)
        productos.forEach(producto => {
            // Crear el HTML de una tarjeta de producto
            const tarjeta = document.createElement('div');
            tarjeta.classList.add('card-producto'); // Clase para CSS
            
            // Usamos los atributos de tu ProductoDTO: id, nombre, precio, rutaImagen
            tarjeta.innerHTML = `
                <img src="${producto.rutaImagen}" alt="${producto.nombre}" class="img-producto">
                <h3>${producto.nombre}</h3>
                <p class="precio">$${producto.precio}</p>
                <button class="btn-ver-detalle" onclick="verDetalle(${producto.id})">Ver Detalles</button>
            `;

            contenedor.appendChild(tarjeta);
        });

    } catch (error) {
        console.error('Error:', error);
    }
}

// 3. Función para redirigir al presionar el producto
function verDetalle(id) {
    // Redirige a la página de detalle pasando el ID en la URL
    window.location.href = `producto.jsp?id=${id}`;
}




//ver detalles de producto
document.addEventListener('DOMContentLoaded', () => {
    // 1. Obtener el ID de la URL (ej. ?id=5)
    const params = new URLSearchParams(window.location.search);
    const idProducto = params.get('id');

    if (idProducto) {
        cargarDetalleProducto(idProducto);
    } else {
        alert("Producto no especificado");
    }
});

async function cargarDetalleProducto(id) {
    try {
        // 2. Hacer fetch al endpoint individual: /api/productos/{id}
        const response = await fetch(`api/productos/${id}`);
        
        if (!response.ok) {
            throw new Error('Producto no encontrado');
        }

        const producto = await response.json();

        // 3. Llenar el HTML con los datos del ProductoDTO
        document.getElementById('producto-nombre').textContent = producto.nombre;
        document.getElementById('producto-descripcion').textContent = producto.descripcion;
        document.getElementById('producto-precio').textContent = producto.precio;
        document.getElementById('producto-estado').textContent = `Disponibles: ${producto.stock}`;
        document.getElementById('producto-imagen').src = producto.rutaImagen;
        
        // Si tienes especificaciones técnicas en tu DTO
        if(producto.especificacionesTecnicas) {
             document.getElementById('detalle-especificaciones').textContent = producto.especificacionesTecnicas;
        }

    } catch (error) {
        console.error('Error:', error);
        document.getElementById('producto-nombre').textContent = "Error al cargar producto";
    }
}
