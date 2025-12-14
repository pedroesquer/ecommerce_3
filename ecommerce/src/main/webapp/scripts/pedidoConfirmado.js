document.addEventListener('DOMContentLoaded', () => {
    // 1. Obtener ID de la URL (ej: pedidoConfirmado.jsp?id=5)
    const params = new URLSearchParams(window.location.search);
    const idPedido = params.get('id');

    if (idPedido) {
        cargarDetallePedido(idPedido);
    } else {
        document.querySelector('main').innerHTML = '<p>Pedido no especificado.</p>';
    }
});

async function cargarDetallePedido(id) {
    try {
        const response = await fetch(`http://localhost:8080/API_ecommerce/api/pedidos/${id}`);
        
        if (!response.ok) throw new Error('Pedido no encontrado');
        
        const pedido = await response.json();

        // 1. Título y Número
        document.querySelector('.confirmacion-pedido h2').textContent = `Pedido #${pedido.id}`;
        
        // 2. Dirección (Asumiendo que viene en el Usuario o en el Pedido)
        // NOTA: Como limpiamos los datos sensibles, el password viene null, pero la dirección debería estar.
        const direccion = pedido.usuario ? pedido.usuario.direccion : "Dirección no disponible";
        document.querySelector('.direccion-envio p').textContent = direccion;

        // 3. Artículos
        const contenedorArticulos = document.querySelector('.articulos-pedido');
        contenedorArticulos.innerHTML = '<h3>Artículos</h3>'; // Resetear y poner título

        let totalCalculado = 0;

        if (pedido.detallesPedido) {
            pedido.detallesPedido.forEach(detalle => {
                const prod = detalle.producto;
                const subtotal = detalle.precioUnitario * detalle.cantidad; // O detalle.importe si existe
                totalCalculado += subtotal;

                const itemDiv = document.createElement('div');
                itemDiv.classList.add('item-detalle'); // Puedes agregar estilos CSS para esto
                itemDiv.style.display = "flex";
                itemDiv.style.gap = "15px";
                itemDiv.style.marginBottom = "10px";
                itemDiv.style.borderBottom = "1px solid #ccc";
                itemDiv.style.paddingBottom = "10px";

                itemDiv.innerHTML = `
                    <img src="${prod.rutaImagen || './imgs/default.png'}" style="width:80px; height:80px; object-fit:cover;">
                    <div>
                        <p><strong>${prod.nombre}</strong></p>
                        <p>Cantidad: ${detalle.cantidad}</p>
                        <p>Precio: $${detalle.precioUnitario}</p>
                        <p>Subtotal: $${subtotal.toFixed(2)}</p>
                    </div>
                `;
                contenedorArticulos.appendChild(itemDiv);
            });
        }

        // Agregar Total Final al HTML
        const totalDiv = document.createElement('div');
        totalDiv.innerHTML = `<h3>Total Pagado: $${pedido.total.toFixed(2)}</h3>`;
        contenedorArticulos.appendChild(totalDiv);

    } catch (error) {
        console.error(error);
        document.querySelector('main').innerHTML = '<p>Error al cargar los detalles del pedido.</p>';
    }
}