const ID_USUARIO_ACTUAL = 1;

document.addEventListener('DOMContentLoaded', () => {
    cargarMisPedidos();
});

async function cargarMisPedidos() {
    const contenedor = document.querySelector('main'); // O el contenedor específico que elijas
    
    try {
        const response = await fetch(`http://localhost:8080/API_ecommerce/api/pedidos/usuario/${ID_USUARIO_ACTUAL}`);
        
        if (!response.ok) throw new Error('Error al cargar pedidos');
        
        const pedidos = await response.json();
        
        contenedor.innerHTML = ''; // Limpiar mocks

        if (pedidos.length === 0) {
            contenedor.innerHTML = '<p style="text-align:center">No has realizado pedidos aún.</p>';
            return;
        }

        pedidos.forEach(pedido => {
            // Formatear fecha
            const fecha = new Date(pedido.fechaPedido).toLocaleDateString('es-ES', {
                year: 'numeric', month: 'long', day: 'numeric'
            });

            // Obtener el primer artículo para la foto de portada (o una por defecto)
            const primerDetalle = pedido.detallesPedido && pedido.detallesPedido.length > 0 
                                  ? pedido.detallesPedido[0] : null;
            
            const imagenSrc = (primerDetalle && primerDetalle.producto && primerDetalle.producto.rutaImagen)
                              ? primerDetalle.producto.rutaImagen 
                              : './imgs/default.png';

            // Convertimos el estado (DTO o String) a texto legible
            const estadoTexto = pedido.estadoPedido ? pedido.estadoPedido.nombre : "Procesando";

            // Crear tarjeta HTML
            const tarjeta = document.createElement('a');
            tarjeta.href = `pedidoConfirmado.jsp?id=${pedido.id}`; // Redirige al detalle
            tarjeta.classList.add('pedido-link');
            
            tarjeta.innerHTML = `
                <div class="pedido">
                    <div class="pedido-header">
                        <h2>Pedido #${pedido.id}</h2>
                        <p>${fecha} - ${estadoTexto}</p>
                    </div>
                    <div class="pedido-body">
                        <div class="articulos">
                            <img src="${imagenSrc}" alt="Imagen pedido">
                            ${pedido.detallesPedido.length > 1 ? `<span class="mas-articulos">+ ${pedido.detallesPedido.length - 1} artículos más</span>` : ''}
                        </div>
                        <div class="direccion">
                            <p>Total: <strong>$${pedido.total.toFixed(2)}</strong></p>
                        </div>
                    </div>
                </div>
            `;
            
            contenedor.appendChild(tarjeta);
        });

    } catch (error) {
        console.error(error);
        contenedor.innerHTML = '<p>Error al cargar tus pedidos.</p>';
    }
}