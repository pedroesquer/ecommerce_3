const API_URL = 'http://localhost:8080/API_ecommerce/api/usuarios/perfil';
let usuarioActual = {}; 

alert("editarUsuario.js cargandose...");
document.addEventListener('DOMContentLoaded', () => {
    cargarDatosParaEditar();

    const btnAceptar = document.querySelector('.btnAceptar');
    if (btnAceptar) {
        btnAceptar.addEventListener('click', actualizarUsuario);
    }
});

async function cargarDatosParaEditar() {
    try {
        const response = await fetch(API_URL, {
            method: 'GET',
            credentials: 'include', 
            headers: {
                'Content-Type': 'application/json'
            }
        });
        
        if (!response.ok) {
            window.location.href = 'inicioSesion.jsp';
            return;
        }

        usuarioActual = await response.json();

        const inputNombre = document.getElementById('nombre');
        const inputNumero = document.getElementById('numero'); 
        const inputCorreo = document.getElementById('correo');

        if (inputNombre) inputNombre.value = usuarioActual.nombre || '';
        if (inputNumero) inputNumero.value = usuarioActual.telefono || ''; 
        if (inputCorreo) inputCorreo.value = usuarioActual.correo || '';

    } catch (error) {
        console.error("Error al cargar datos:", error);
        alert("Error al cargar la información del usuario.");
    }
}

async function actualizarUsuario() {

    const nombre = document.getElementById('nombre').value;
    const numero = document.getElementById('numero').value;
    const correo = document.getElementById('correo').value;

    if (!nombre || !numero || !correo) {
        alert("Por favor llena todos los campos obligatorios.");
        return;
    }

    usuarioActual.nombre = nombre;
    usuarioActual.telefono = numero; 
    usuarioActual.correo = correo;

    try {
        const response = await fetch(API_URL, {
            method: 'PUT',
            credentials: "include",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuarioActual)
        });

        if (response.ok) {
            alert("Perfil actualizado correctamente.");
            window.location.href = 'usuario.jsp'; 
        } else {
            const errorData = await response.json();
            alert("Error al actualizar: " + (errorData.error || "Intente nuevamente."));
        }

    } catch (error) {
        console.error("Error de red:", error);
        alert("Error de conexión al intentar guardar.");
    }
}