const API_URL = 'http://localhost:8080/API_ecommerce/api/pedidos/mis-pedidos';

document.addEventListener('DOMContentLoaded', () => {
    cargarMisPedidos();
});

async function cargarMisPedidos() {
    const contenedor = document.querySelector('main');
    
    try {
        
        const response = await fetch(API_URL, {
            method: 'GET',
            credentials: 'include',             headers: {
                'Content-Type': 'application/json'
            }
        });
        
        if (response.status === 401 || response.status === 403) {
            contenedor.innerHTML = '<p style="text-align:center; margin-top:20px;">Tu sesión ha expirado.</p>';
            return;
        }
        
        if (!response.ok) {
            throw new Error(`Error HTTP: ${response.status}`);
        }
        
        const pedidos = await response.json();

        contenedor.innerHTML = ''; 

        const header = document.createElement('header');
        header.className = 'mis-pedidos';
        contenedor.appendChild(header);

        if (!pedidos || pedidos.length === 0) {
            const mensaje = document.createElement('p');
            mensaje.style.textAlign = 'center';
            mensaje.style.marginTop = '20px';
            mensaje.textContent = 'No has realizado pedidos aún.';
            contenedor.appendChild(mensaje);
            return;
        }
        
        pedidos.forEach(pedido => {

            let fechaTexto = pedido.fechaHoraFormateada; 
            
            if (!fechaTexto && pedido.fecha) {
                try {
                    fechaTexto = new Date(pedido.fecha).toLocaleDateString('es-MX', {
                        year: 'numeric', month: 'long', day: 'numeric'
                    });
                } catch (e) { fechaTexto = "Fecha desconocida"; }
            }

            const estadoTexto = pedido.estado || "Procesando";
            const numeroPedido = pedido.numeroPedido || `#${pedido.id}`;
            const total = pedido.total ? pedido.total.toFixed(2) : '0.00';
            const direccion = pedido.direccion || 'Dirección de envío no disponible';
            let imagenSrc = './imgs/default.png';
            let cantidadArticulos = 0;

            if (pedido.detallesPedido && Array.isArray(pedido.detallesPedido)) {
                cantidadArticulos = pedido.detallesPedido.length;
                
                const primerDetalle = pedido.detallesPedido[0];
                if (primerDetalle && primerDetalle.producto && primerDetalle.producto.rutaImagen) {
                    imagenSrc = primerDetalle.producto.rutaImagen;
                }
            }
            
            // CREACIÓN DEL HTML
            const link = document.createElement('a');
            link.href = `pedidoConfirmado.jsp?id=${pedido.id}`;
            link.classList.add('pedido-link');
            
            link.innerHTML = `
                <div class="pedido">
                    <div class="pedido-header">
                        <h2>Pedido ${numeroPedido}</h2>
                        <p>${fechaTexto} - ${estadoTexto}</p>
                    </div>

                    <div class="pedido-body">
                        <div class="articulos">
                            <img src="${imagenSrc}" alt="Producto" onerror="this.src='./imgs/default.png'">
                            ${cantidadArticulos > 1 
                                ? `<span class="mas-articulos">+ ${cantidadArticulos - 1} artículos más</span>` 
                                : ''}
                        </div>
                        <div class="direccion">
                            <p><strong>Total: $${total}</strong></p>
                            <p class="direccion-texto">${direccion}</p>
                        </div>
                    </div>
                </div>
            `;
            
            contenedor.appendChild(link);
        });
        
    } catch (error) {
        console.error('❌ Error JS:', error);
        contenedor.innerHTML += '<p style="text-align:center; color:red;">Hubo un error al cargar tus pedidos.</p>';
    }
}