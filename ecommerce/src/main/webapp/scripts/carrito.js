document.addEventListener('DOMContentLoaded', () => {
    cargarCarrito();
});

async function cargarCarrito() {
    const URL_API = 'http://localhost:8080/API_ecommerce/api/carrito/mi-carrito';

    try {
        const response = await fetch(URL_API, {
            method: 'GET',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            }
        });


        if (!response.ok) {
            if (response.status === 401 || response.status === 403) {
                alert("Tu sesión ha expirado.");
                window.location.href = "inicioSesion.jsp";
                return;
            }
            throw new Error(`Error HTTP: ${response.status}`);
        }

        const textoRespuesta = await response.text();

        if (!textoRespuesta) {
            renderizarCarrito({detallesCarrito: []});
            return;
        }

        const carrito = JSON.parse(textoRespuesta);

        renderizarCarrito(carrito);

    } catch (error) {
        document.querySelector('.contenedorProductos').innerHTML =
                '<p style="text-align:center; color:red; margin-top:20px;">Error al cargar: ' + error.message + '</p>';
    }
}

function renderizarCarrito(carrito) {
    const contenedor = document.querySelector('.contenedorProductos');
    contenedor.innerHTML = ''; 

    // Validación si el carrito viene vacío
    if (!carrito || !carrito.detallesCarrito || carrito.detallesCarrito.length === 0) {
        contenedor.innerHTML = '<p style="text-align:center; margin-top: 20px;">No hay productos en tu carrito.</p>';
        actualizarTotales(0, 0);
        return;
    }

    let cantidadTotalAcumulada = 0;
    let subtotalAcumulado = 0;

    carrito.detallesCarrito.forEach(detalle => {
        const producto = detalle.producto;

        const precio = producto.precio;
        const cantidad = detalle.cantidadProductos; 
        const importe = precio * cantidad;

        cantidadTotalAcumulada += cantidad;
        subtotalAcumulado += importe;

        const imagenSrc = producto.rutaImagen ? producto.rutaImagen : './imgs/default.png';

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

    actualizarTotales(cantidadTotalAcumulada, subtotalAcumulado);

    const btnPagar = document.querySelector('.btnPagar');
    if (btnPagar) {
        btnPagar.onclick = () => {
            window.location.href = 'pago.jsp';
        };
    }
}

function actualizarTotales(cantidadTotal, subtotalTotal) {
    document.querySelector('.txtTotalProductos').textContent = `Total de Productos: ${cantidadTotal}`;
    document.querySelector('.txtSubtotal').textContent = `Subtotal: $${subtotalTotal.toFixed(2)}`;
}

async function eliminarProducto(idProducto, idCarrito) {
    if (!confirm("¿Deseas eliminar este producto del carrito?"))
        return;

    const url = 'http://localhost:8080/API_ecommerce/api/carrito/eliminarProductoCarrito';

    try {
        const datosEnviar = {
            producto: {
                id: idProducto
            },
            carrito: idCarrito
        };

        const response = await fetch(url, {
            method: 'DELETE',
            credentials: 'include', 
            headers: {
                'Content-Type': 'application/json' 
            },
            body: JSON.stringify(datosEnviar)
        });

        if (response.ok) {
            cargarCarrito();
            console.log("Producto eliminado correctamente");
        } else {
            const textoError = await response.text();
            console.error("Error del servidor:", textoError);
            alert("No se pudo eliminar el producto.");
        }
    } catch (error) {
        console.error("Error al eliminar:", error);
    }
}