// ID del usuario hardcodeado (simulando login)
const ID_USUARIO_ACTUAL = 1;

document.addEventListener('DOMContentLoaded', () => {
    cargarCarrito();
});

async function cargarCarrito() {
    try {
        // Petición a la API
        const response = await fetch(`http://localhost:8080/API_ecommerce/api/carrito/${ID_USUARIO_ACTUAL}`);
        
        if (!response.ok) {
            throw new Error('No se pudo obtener el carrito');
        }

        const carrito = await response.json();
        renderizarCarrito(carrito);

    } catch (error) {
        console.error('Error:', error);
        document.querySelector('.contenedorProductos').innerHTML = 
            '<p style="text-align:center; margin-top: 20px;">Tu carrito está vacío o hubo un error al cargarlo.</p>';
        actualizarTotales(0, 0);
    }
}

function renderizarCarrito(carrito) {
    const contenedor = document.querySelector('.contenedorProductos');
    contenedor.innerHTML = ''; // Limpiar contenido previo

    // Validación si el carrito viene vacío
    if (!carrito || !carrito.detallesCarrito || carrito.detallesCarrito.length === 0) {
        contenedor.innerHTML = '<p style="text-align:center; margin-top: 20px;">No hay productos en tu carrito.</p>';
        actualizarTotales(0, 0);
        return;
    }

    let cantidadTotalAcumulada = 0;
    let subtotalAcumulado = 0;
    
    // Recorremos cada producto del carrito
    carrito.detallesCarrito.forEach(detalle => {
        const producto = detalle.producto;
        
        // DATOS PARA EL CÁLCULO
        const precio = producto.precio;
        const cantidad = detalle.cantidadProductos; // Ojo: en tu DTO se llama 'cantidadProductos'
        const importe = precio * cantidad;

        // ACUMULADORES GLOBALES
        cantidadTotalAcumulada += cantidad;
        subtotalAcumulado += importe;

        // FOTO DEL PRODUCTO (Validación por si viene null)
        const imagenSrc = producto.rutaImagen ? producto.rutaImagen : './imgs/default.png';

        // CREACIÓN DEL HTML EXACTO
        const divProducto = document.createElement('div');
        divProducto.classList.add('producto1');

        divProducto.innerHTML = `
            <img src="${imagenSrc}" alt="${producto.nombre}">
            <div class="infoProducto1">
                <h3>${producto.nombre}</h3>
                <h3>Precio: $${precio.toFixed(2)}</h3>
                <h3>Cantidad: ${cantidad}</h3>
                <h3>Importe: $${importe.toFixed(2)}</h3>
                <button class="btnEliminar" onclick="eliminarProducto(${producto.id}, ${carrito.id})">Eliminar</button>
            </div>
        `;

        contenedor.appendChild(divProducto);
    });

    // ACTUALIZAR LA ZONA DE PAGO
    actualizarTotales(cantidadTotalAcumulada, subtotalAcumulado);
    
    // Asignar evento al botón de pagar (ya que href en button no funciona directo)
    const btnPagar = document.querySelector('.btnPagar');
    if(btnPagar) {
        btnPagar.onclick = () => {
            window.location.href = 'pago.jsp';
        };
    }
}

function actualizarTotales(cantidadTotal, subtotalTotal) {
    // NUMERO TOTAL DE PRODUCTOS DEL CARRITO
    document.querySelector('.txtTotalProductos').textContent = `Total de Productos: ${cantidadTotal}`;
    
    // SUMA DE TODOS LOS IMPORTES
    document.querySelector('.txtSubtotal').textContent = `Subtotal: $${subtotalTotal.toFixed(2)}`;
}

//AQUI VEZ QUE PEDO PEDRO O QUIEN HAGA ESTA MIERDA
async function eliminarProducto(idProducto, idCarrito) {
    if(!confirm("¿Deseas eliminar este producto del carrito?")) return;

    try {

        const url = `http://localhost:8080/API_ecommerce/api/carrito/eliminarProducto?idProducto=${idProducto}&idCarrito=${idCarrito}`;
        
        const response = await fetch(url, { method: 'DELETE' });

        if (response.ok) {
            // Recargar el carrito para ver los cambios
            cargarCarrito();
        } else {
            alert("No se pudo eliminar el producto.");
        }
    } catch (error) {
        console.error("Error al eliminar:", error);
    }
}