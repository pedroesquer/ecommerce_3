const API_URL = 'http://localhost:8080/API_ecommerce/api/usuario/perfil';
let usuarioActual = {}; // Variable para guardar el objeto completo

document.addEventListener('DOMContentLoaded', () => {
    cargarDatosParaEditar();

    const btnAceptar = document.querySelector('.btnAceptar');
    if (btnAceptar) {
        btnAceptar.addEventListener('click', actualizarUsuario);
    }
});

async function cargarDatosParaEditar() {
    try {
        const response = await fetch(API_URL, {credentials: "include"});
        
        if (response.status === 401) {
            window.location.href = 'inicioSesion.jsp';
            return;
        }

        usuarioActual = await response.json();

        // Rellenar los inputs usando los IDs de tu HTML
        const inputNombre = document.getElementById('nombre');
        const inputNumero = document.getElementById('numero'); // Tu HTML usa id="numero"
        const inputCorreo = document.getElementById('correo');

        if (inputNombre) inputNombre.value = usuarioActual.nombre || '';
        if (inputNumero) inputNumero.value = usuarioActual.telefono || ''; // Mapeamos telefono -> numero
        if (inputCorreo) inputCorreo.value = usuarioActual.correo || '';

    } catch (error) {
        console.error("Error al cargar datos:", error);
        alert("Error al cargar la información del usuario.");
    }
}

async function actualizarUsuario() {
    // 1. Validaciones básicas de HTML (ya que al usar JS saltamos la validación nativa del form submit)
    const nombre = document.getElementById('nombre').value;
    const numero = document.getElementById('numero').value;
    const correo = document.getElementById('correo').value;

    if (!nombre || !numero || !correo) {
        alert("Por favor llena todos los campos obligatorios.");
        return;
    }

    // 2. Actualizamos el objeto usuarioActual con los nuevos valores
    usuarioActual.nombre = nombre;
    usuarioActual.telefono = numero; // El DTO espera "telefono", tu input es "numero"
    usuarioActual.correo = correo;

    // 3. Enviamos la petición PUT
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
            window.location.href = 'usuario.jsp'; // Regresar al perfil
        } else {
            const errorData = await response.json();
            alert("Error al actualizar: " + (errorData.error || "Intente nuevamente."));
        }

    } catch (error) {
        console.error("Error de red:", error);
        alert("Error de conexión al intentar guardar.");
    }
}