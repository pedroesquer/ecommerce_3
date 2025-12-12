const API_URL = 'http://localhost:8080/API_ecommerce/api/usuario/perfil';

document.addEventListener('DOMContentLoaded', () => {
    cargarDatosUsuario();
    configurarBotones();
});

async function cargarDatosUsuario() {
    try {
        const token = localStorage.getItem('jwt_token');

        if (!token) {
            console.log("No hay token, redirigiendo a login...");
            window.location.href = 'inicioSesion.jsp';
            return;
        }

        // 2. Enviar el token en el Header Authorization
        const response = await fetch(API_URL, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`, // AQUÍ LA MAGIA
                'Content-Type': 'application/json'
            }
        });

        if (response.status === 401 || response.status === 403) {
            // Token expirado o inválido
            localStorage.removeItem('jwt_token');
            window.location.href = 'inicioSesion.jsp';
            return;
        }

        const usuario = await response.json();
        
        const panelNombre = document.getElementById('panel_nomnre');
        if (panelNombre) panelNombre.querySelector('p').innerHTML += ` ${usuario.nombre}`;

        const panelCorreo = document.getElementById('panel_correo');
        if (panelCorreo) panelCorreo.querySelector('p').innerHTML += ` ${usuario.correo}`;

        const panelDireccion = document.getElementById('panel_direccion');
        if (panelDireccion) panelDireccion.querySelector('p').innerHTML += ` ${usuario.direccion}`;

        const panelTelefono = document.getElementById('panel_telefono');
        if (panelTelefono) panelTelefono.querySelector('p').innerHTML += ` ${usuario.telefono}`;

    } catch (error) {
        console.error("Error cargando perfil:", error);
    }
}

function configurarBotones() {
    const btnEditar = document.querySelector('.btn_editar');
    if (btnEditar) {
        btnEditar.addEventListener('click', () => {
            window.location.href = 'editarUsuario.jsp';
        });
    }

    const btnPedidos = document.querySelector('.btn_pedidos');
    if (btnPedidos) {
        btnPedidos.addEventListener('click', () => {
            window.location.href = 'misPedidos.jsp';
        });
    }
}
