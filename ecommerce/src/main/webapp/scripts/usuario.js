const API_URL = 'http://localhost:8080/API_ecommerce/api/usuarios/perfil';

alert("usuario.js cargandose...");
document.addEventListener('DOMContentLoaded', () => {
    cargarDatosUsuario();
    configurarBotones();
});

async function cargarDatosUsuario() {
    try {
        const response = await fetch(API_URL, {
            method: 'GET',
            credentials: 'include', // 🔥 CLAVE: manda la cookie jwt
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (response.status === 401 || response.status === 403) {
            // Token expirado o inválido
            console.log("WE OCURRIO UN ERROR NO SE QP CON EL TOKEN");
            window.location.href = 'inicioSesion.jsp';
            return;
        }

        const usuario = await response.json();

        const panelNombre = document.getElementById('panel_nomnre');
        if (panelNombre)
            panelNombre.querySelector('p').innerHTML += ` ${usuario.nombre}`;

        const panelCorreo = document.getElementById('panel_correo');
        if (panelCorreo)
            panelCorreo.querySelector('p').innerHTML += ` ${usuario.correo}`;

        const panelDireccion = document.getElementById('panel_direccion');
        if (panelDireccion)
            panelDireccion.querySelector('p').innerHTML += ` ${usuario.direccion}`;

        const panelTelefono = document.getElementById('panel_telefono');
        if (panelTelefono)
            panelTelefono.querySelector('p').innerHTML += ` ${usuario.telefono}`;

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

    const btnCerrarSesion = document.getElementById('btn_cerrarSesion'); // Asegúrate de tener este ID en tu HTML

    if (btnCerrarSesion) {
        btnCerrarSesion.addEventListener('click', async (e) => {
            e.preventDefault(); // Prevenir navegación default si es un enlace

            try {
                await fetch('http://localhost:8080/API_ecommerce/api/usuarios/logout', {
                    method: 'POST',
                    // No necesitas credentials: 'include' obligatorio para logout, 
                    // pero ayuda si quieres validar quién cierra sesión.
                });

                // Independientemente del resultado, redirigimos al login
                window.location.href = 'inicioSesion.jsp';

            } catch (error) {
                console.error("Error al cerrar sesión:", error);
                // Redirigir de todos modos por seguridad
                window.location.href = 'inicioSesion.jsp';
            }
        });
    }
}
