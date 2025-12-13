document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const idProducto = params.get('id');

    if (idProducto) {
        cargarDetalleProducto(idProducto);
    } else {
        // NO alert — solo no cargamos nada
        console.warn("No se especificó un producto.");
    }
});

async function cargarDetalleProducto(id) {
    try {
        const response = await fetch(`http://localhost:8080/API_ecommerce/api/productos/${id}`);
        if (!response.ok) {
            throw new Error('Producto no encontrado');
        }
        const producto = await response.json();
        document.getElementById('producto-nombre').textContent = producto.nombre;
        document.querySelector(".imagen-producto img").src = producto.rutaImagen;
        document.querySelector(".descripcion p").textContent = producto.descripcion;
        document.querySelector(".cuadro-compra span").textContent = "$" + producto.precio;
        document.querySelector(".estado").textContent =
            producto.stock > 0 ? "Disponible" : "Agotado";
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('producto-nombre').textContent = "Error al cargar producto";
    }
}