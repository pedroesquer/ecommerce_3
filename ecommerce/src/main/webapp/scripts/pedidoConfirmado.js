document.addEventListener('DOMContentLoaded', () => {

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

        const numPedido = pedido.numeroPedido || pedido.id;
        document.querySelector('.confirmacion-pedido h2').textContent = `Pedido #${numPedido}`;
        
        const direccion = pedido.direccion || (pedido.usuario ? pedido.usuario.direccion : "Dirección no disponible");
        document.querySelector('.direccion-envio p').textContent = direccion;

        const contenedorArticulos = document.querySelector('.articulos-pedido');
        contenedorArticulos.innerHTML = '<h3>Artículos</h3>'; 

        let totalCalculado = 0;

        if (pedido.detallesPedido) {
            pedido.detallesPedido.forEach(detalle => {
                const prod = detalle.producto;

                const precioUnitario = prod.precio || 0; 
                const subtotal = precioUnitario * detalle.cantidad;
                // -----------------------

                totalCalculado += subtotal;

                const itemDiv = document.createElement('div');
                itemDiv.classList.add('item-detalle'); 
                itemDiv.style.display = "flex";
                itemDiv.style.gap = "15px";
                itemDiv.style.marginBottom = "10px";
                itemDiv.style.borderBottom = "1px solid #ccc";
                itemDiv.style.paddingBottom = "10px";

                itemDiv.innerHTML = `
                    <img src="${prod.rutaImagen || './imgs/default.png'}" style="width:80px; height:80px; object-fit:cover;" onerror="this.src='./imgs/default.png'">
                    <div>
                        <p><strong>${prod.nombre}</strong></p>
                        <p>Cantidad: ${detalle.cantidad}</p>
                        <p>Precio: $${precioUnitario.toFixed(2)}</p>
                        <p>Subtotal: $${subtotal.toFixed(2)}</p>
                    </div>
                `;
                contenedorArticulos.appendChild(itemDiv);
            });
        }

        const totalFinal = pedido.total !== undefined ? pedido.total : totalCalculado;
        
        const totalDiv = document.createElement('div');
        totalDiv.innerHTML = `<h3>Total Pagado: $${totalFinal.toFixed(2)}</h3>`;
        contenedorArticulos.appendChild(totalDiv);

    } catch (error) {
        console.error(error);
        const main = document.querySelector('main');
        if (main) {
             main.innerHTML = '<p style="text-align:center; color:red; margin-top: 20px;">Error al cargar los detalles del pedido.</p>';
        }
    }
}