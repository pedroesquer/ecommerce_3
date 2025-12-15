document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const idProducto = params.get('id');

    if (idProducto) {
        cargarDetalleProducto(idProducto);
    } else {
        // NO alert — solo no cargamos nada
        console.warn("No se especificó un producto.");
    }
});

async function cargarDetalleProducto(id) {
    try {
        const response = await fetch(`http://localhost:8080/API_ecommerce/api/productos/${id}`);
        if (!response.ok) {
            throw new Error('Producto no encontrado');
        }
        const producto = await response.json();
        document.getElementById('producto-nombre').textContent = producto.nombre;
        document.querySelector(".imagen-producto img").src = producto.rutaImagen;
        document.querySelector(".descripcion p").textContent = producto.descripcion;
        document.querySelector(".cuadro-compra span").textContent = "$" + producto.precio;
        const estado = document.querySelector(".estado");
        if(producto.stock > 0){
            estado.textContent = "Disponible";
            estado.style.color = "green";
        } else {
            estado.textContent = "Agotado";
            estado.style.color = "red";
            document.querySelector('.btn-carrito').disabled = true;
            document.querySelector('.btn-comprar').disabled = true;
        }
    
        renderizarResenias(producto.reseñas);    
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('producto-nombre').textContent = "Error al cargar producto";
    }
}

function renderizarResenias(listaResenias) {
    const contenedor = document.getElementById('opiniones');
    const titulo = contenedor.querySelector('h2'); 
    
    // Limpiamos el contenido (borramos los mocks estáticos del JSP), dejando solo el título
    contenedor.innerHTML = '';
    contenedor.appendChild(titulo);

    if (!listaResenias || listaResenias.length === 0) {
        const mensaje = document.createElement('p');
        mensaje.textContent = "Este producto aún no tiene opiniones. ¡Sé el primero!";
        mensaje.style.fontStyle = "italic";
        mensaje.style.color = "#666";
        contenedor.appendChild(mensaje);
        return;
    }

    // Ordenamos por fecha (opcional: más recientes primero)
    listaResenias.sort((a, b) => new Date(b.fecha) - new Date(a.fecha));

    listaResenias.forEach(resenia => {
        const divOpinion = document.createElement('div');
        divOpinion.classList.add('opinion');

        // Nombre del usuario (o Anónimo si no viene)
        const nombreUsuario = (resenia.usuario && resenia.usuario.nombre) ? resenia.usuario.nombre : "Usuario Anónimo";
        
        // Fecha formateada
        let fechaTexto = "Fecha desconocida";
        if (resenia.fecha) {
            fechaTexto = new Date(resenia.fecha).toLocaleDateString('es-MX', {
                year: 'numeric', month: 'long', day: 'numeric'
            });
        }

        // Estrellas (texto o iconos)
        const estrellas = "★".repeat(resenia.estrellas) + "☆".repeat(5 - resenia.estrellas);

        divOpinion.innerHTML = `
            <strong>${nombreUsuario}</strong>
            <p class="resumen"><span style="color: #f39c12;">${estrellas}</span> - ${fechaTexto}</p>
            <p class="resenia">${resenia.comentario}</p>
        `;

        contenedor.appendChild(divOpinion);
    });
}


// AGREGAR RESEÑA

document.addEventListener("DOMContentLoaded", () => {
    const formResenia = document.getElementById("formResenia");
    if (!formResenia) return;

    formResenia.addEventListener("submit", async (e) => {
        e.preventDefault();

        const params = new URLSearchParams(window.location.search);
        const idProducto = params.get("id");

        if (!idProducto) {
            alert("Producto inválido.");
            return;
        }

        const estrellas = document.getElementById("calificacion").value;
        const comentario = document.getElementById("opinion").value.trim();

        if (!comentario || estrellas < 1 || estrellas > 5) {
            alert("Completa correctamente la reseña.");
            return;
        }

        try {
            const response = await fetch(
                `http://localhost:8080/API_ecommerce/api/productos/${idProducto}/resenias`,
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    credentials: "include", 
                    body: JSON.stringify({
                        estrellas: Number(estrellas),
                        comentario: comentario
                    })
                }
            );

            if (!response.ok) {
                const error = await response.text();
                throw new Error(error);
            }

            alert("Reseña publicada correctamente.");

            // Limpia formulario
            formResenia.reset();

            // Recarga producto para traer la nueva reseña
            cargarDetalleProducto(idProducto);

        } catch (error) {
            console.error("Error al publicar reseña:", error);
            alert(error.message || "No se pudo publicar la reseña.");
        }
    });
});
