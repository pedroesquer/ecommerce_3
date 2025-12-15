const API_URL = 'http://localhost:8080/API_ecommerce/api/usuarios/perfil';
let usuarioActual = {};


document.addEventListener('DOMContentLoaded', () => {
    cargarDatosParaEditar();
    
    const btnAceptar = document.querySelector('.btnAceptar');
    if (btnAceptar) {
        btnAceptar.addEventListener('click', actualizarUsuario);
    }
});

async function cargarDatosParaEditar() {
    try {
        console.log("Cargando datos del usuario...");
        
        const response = await fetch(API_URL, {
            method: 'GET',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        
        if (!response.ok) {
            if (response.status === 401 || response.status === 403) {
                alert("Tu sesión ha expirado. Por favor inicia sesión nuevamente.");
                window.location.href = 'inicioSesion.jsp';
                return;
            }
            throw new Error('Error al cargar datos');
        }
        
        usuarioActual = await response.json();
        console.log("Usuario cargado:", usuarioActual);
        
        const inputNombre = document.getElementById('nombre');
        const inputNumero = document.getElementById('numero');
        const inputCorreo = document.getElementById('correo');
        
        if (inputNombre) inputNombre.value = usuarioActual.nombre || '';
        if (inputNumero) inputNumero.value = usuarioActual.telefono || '';
        if (inputCorreo) inputCorreo.value = usuarioActual.correo || '';
        
    } catch (error) {
        console.error("Error al cargar datos:", error);
        alert("Error al cargar la información del usuario. Por favor intenta de nuevo.");
    }
}

async function actualizarUsuario() {
    console.log("Intentando actualizar usuario...");
    
    // Validar campos
    const nombre = document.getElementById('nombre').value.trim();
    const numero = document.getElementById('numero').value.trim();
    const correo = document.getElementById('correo').value.trim();
    
    if (!nombre || !numero || !correo) {
        alert("Por favor llena todos los campos obligatorios.");
        return;
    }

    if (nombre.length < 3) {
        alert("El nombre debe tener al menos 3 caracteres.");
        return;
    }
    
    if (!/^\d{10}$/.test(numero)) {
        alert("El teléfono debe tener exactamente 10 dígitos.");
        return;
    }
    
    if (!correo.includes('@') || !correo.endsWith('.com')) {
        alert("El correo debe contener '@' y terminar en '.com'.");
        return;
    }
    
    usuarioActual.nombre = nombre;
    usuarioActual.telefono = numero;
    usuarioActual.correo = correo;
    
    delete usuarioActual.contrasenia;
    
    console.log("Enviando datos:", usuarioActual);
    
    try {
        const response = await fetch(API_URL, {
            method: 'PUT',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuarioActual)
        });
        
        console.log(" Respuesta del servidor:", response.status);
        
        if (response.ok) {
            const actualizado = await response.json();
            console.log("Usuario actualizado:", actualizado);
            alert("Perfil actualizado correctamente.");
            window.location.href = 'usuario.jsp';
        } else {
            const errorData = await response.json();
            console.error("Error del servidor:", errorData);
            alert("Error al actualizar: " + (errorData.error || "Intente nuevamente."));
        }
        
    } catch (error) {
        console.error("Error de red:", error);
        alert("Error de conexión al intentar guardar. Verifica tu conexión e intenta de nuevo.");
    }
}