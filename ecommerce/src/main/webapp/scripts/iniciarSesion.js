// Asigna esto al botón de "Ingresar" o al evento submit del formulario
async function iniciarSesion(event) {
    event.preventDefault(); // Evita que el formulario haga submit y recargue

    const correo = document.getElementById('correo').value; // Asegurate que tus inputs tengan estos IDs
    const contrasenia = document.getElementById('contrasenia').value;

    try {
        const response = await fetch('http://localhost:8080/API_ecommerce/api/usuarios/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ correo: correo, contrasenia: contrasenia })
        });

        if (response.ok) {
            const data = await response.json();
            // AQUÍ ESTÁ LA CLAVE: Guardar el token en el navegador
            localStorage.setItem('jwt_token', data.token);
            
            // Decodificar el token para saber si es admin o cliente (opcional, o redireccionar genérico)
            // Por simplicidad, redirigimos al index y que la página decida
             window.location.href = 'index.jsp'; 
        } else {
            alert("Credenciales incorrectas");
        }
    } catch (error) {
        console.error("Error:", error);
    }
}