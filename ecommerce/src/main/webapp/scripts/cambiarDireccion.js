const API_PERFIL = 'http://localhost:8080/API_ecommerce/api/usuarios/perfil';
let usuarioActual = {};

document.addEventListener('DOMContentLoaded', () => {
    cargarDatosUsuario();
    
    const form = document.getElementById('formDireccion');
    form.addEventListener('submit', guardarDireccionCompleta);
});

async function cargarDatosUsuario() {
    try {
        const response = await fetch(API_PERFIL, {
            method: 'GET',
            credentials: 'include',
            headers: { 'Content-Type': 'application/json' }
        });

        if (response.status === 401) {
            window.location.href = 'inicioSesion.jsp';
            return;
        }

        usuarioActual = await response.json();

        if (usuarioActual.nombre) {
            document.getElementById('nombreCompleto').value = usuarioActual.nombre;
        }
        
       

    } catch (error) {
        console.error("Error cargando datos:", error);
    }
}

async function guardarDireccionCompleta(e) {
    e.preventDefault(); 

    const nombre = document.getElementById('nombreCompleto').value.trim();
    const calle = document.getElementById('calleNumero').value.trim();
    const colonia = document.getElementById('colonia').value.trim();
    const ciudad = document.getElementById('ciudad').value.trim();
    const estado = document.getElementById('estado').value.trim();
    const cp = document.getElementById('codigoPostal').value.trim();

    
    const direccionFinal = `${calle}, Col. ${colonia}, ${ciudad}, ${estado}, CP ${cp}`;

  
    usuarioActual.nombre = nombre; 
    usuarioActual.direccion = direccionFinal;

    try {
        const response = await fetch(API_PERFIL, {
            method: 'PUT',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuarioActual)
        });

        if (response.ok) {
            window.location.href = 'pago.jsp';
        } else {
            const msg = await response.text();
            alert("Error al guardar: " + msg);
        }

    } catch (error) {
        console.error(error);
        alert("Error de conexión al guardar.");
    }
}