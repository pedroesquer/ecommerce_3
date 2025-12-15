document.addEventListener('DOMContentLoaded', () => {
    cargarResumenCompra();

    document.querySelectorAll('.contenedorMetodoPago form')
        .forEach(form => {
            form.addEventListener('submit', procesarPago);
        });
});

async function cargarResumenCompra() {
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
                window.location.href = "inicioSesion.jsp";
                return;
            }
            throw new Error(`Error HTTP: ${response.status}`);
        }

        const textoRespuesta = await response.text();
        if (!textoRespuesta) return; 

        const carrito = JSON.parse(textoRespuesta);
        renderizarResumen(carrito);

    } catch (error) {
        console.error("Error al cargar resumen:", error);
        document.querySelector('.contenedorArticulos').innerHTML = 
            '<p style="color:red;">No se pudieron cargar los artículos.</p>';
    }
}

function renderizarResumen(carrito) {
    const contenedor = document.querySelector('.contenedorArticulos');
    contenedor.innerHTML = ''; 

    if (!carrito || !carrito.detallesCarrito || carrito.detallesCarrito.length === 0) {
        contenedor.innerHTML = '<p>No hay artículos por pagar.</p>';
        return;
    }

    contenedor.style.maxHeight = '300px'; 
    contenedor.style.overflowY = 'auto';  
    contenedor.style.display = 'block';   
    contenedor.style.paddingRight = '10px'; 


    let totalGlobal = 0;

    carrito.detallesCarrito.forEach(detalle => {
        const producto = detalle.producto;
        const cantidad = detalle.cantidadProductos;
        const precio = producto.precio;
        const importe = precio * cantidad;
        
        totalGlobal += importe;

        const imagenSrc = producto.rutaImagen ? producto.rutaImagen : './imgs/default.png';

        const itemDiv = document.createElement('div');
        itemDiv.classList.add('articulo1'); 
        
        itemDiv.style.display = 'flex';
        itemDiv.style.alignItems = 'center';
        itemDiv.style.marginBottom = '15px';
        itemDiv.style.paddingBottom = '10px';
        itemDiv.style.borderBottom = '1px solid #ddd';

        itemDiv.innerHTML = `
            <img src="${imagenSrc}" alt="${producto.nombre}" style="width: 60px; height: 60px; object-fit: contain; margin-right: 15px; border-radius: 5px;">
            <div style="flex: 1;">
                <h4 style="margin: 0; font-size: 1rem; color: #333;">${producto.nombre}</h4>
                <p style="margin: 5px 0; font-size: 0.9rem; color: #666;">
                    ${cantidad} x $${precio.toFixed(2)}
                </p>
            </div>
            <div style="font-weight: bold; font-size: 1.1rem; color: #000;">
                $${importe.toFixed(2)}
            </div>
        `;

        contenedor.appendChild(itemDiv);
    });


    const totalDiv = document.createElement('div');
    totalDiv.style.marginTop = '20px';
    totalDiv.style.textAlign = 'right';
    totalDiv.style.paddingTop = '10px';
    
    totalDiv.innerHTML = `
        <h3 style="margin: 0; font-size: 1.2rem;">Total a Pagar:</h3>
        <span style="font-size: 1.5rem; color: #d32f2f; font-weight: bold;">$${totalGlobal.toFixed(2)}</span>
    `;
    contenedor.appendChild(totalDiv);
}

async function procesarPago(event) {
    event.preventDefault(); 

    let tipoPago = null;

    if (document.getElementById('tarjeta').checked) {
        tipoPago = 'TARJETA';
    } else if (document.getElementById('transferencia').checked) {
        tipoPago = 'TRANSFERENCIA';
    } else if (document.getElementById('contraentrega').checked) {
        tipoPago = 'CONTRAENTREGA';
    }

    if (!tipoPago) {
        alert("Selecciona un método de pago");
        return;
    }

    const direccionEnvio = document.querySelector('.contenedorDireccion p')
        ?.textContent
        ?.trim();

    if (!direccionEnvio) {
        alert("No se encontró dirección de envío");
        return;
    }

    try {
        const response = await fetch(
            'http://localhost:8080/API_ecommerce/api/pedidos',
            {
                method: 'POST',
                credentials: 'include',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    tipoPago: tipoPago,
                    direccionEnvio: direccionEnvio
                })
            }
        );

        if (!response.ok) {
            if (response.status === 401) {
                window.location.href = 'inicioSesion.jsp';
                return;
            }
            const error = await response.text();
            throw new Error(error);
        }

        const pedido = await response.json();

        alert(`Pedido creado correctamente\nNúmero: ${pedido.numeroPedido}`);

        window.location.href = `misPedidos.jsp`;

    } catch (error) {
        console.error(error);
        alert(error.message || "Error al procesar el pago");
    }
}