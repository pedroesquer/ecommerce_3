document.addEventListener('DOMContentLoaded', () => {

    // Interceptar TODOS los forms de pago
    document.querySelectorAll('.contenedorMetodoPago form')
        .forEach(form => {
            form.addEventListener('submit', procesarPago);
        });
});

async function procesarPago(event) {
    event.preventDefault(); 

    let tipoPago = null;

    if (document.getElementById('tarjeta').checked) {
        tipoPago = 'TARJETA';
    } else if (document.getElementById('transferencia').checked) {
        tipoPago = 'TRANSFERENCIA';
    } else if (document.getElementById('contraentrega').checked) {
        tipoPago = 'EFECTIVO';
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