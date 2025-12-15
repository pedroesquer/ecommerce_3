document.addEventListener('DOMContentLoaded', () => {
    cargarCategorias();
});

async function cargarCategorias() {
    const urlAPI = 'http://localhost:8080/API_ecommerce/api/categorias'; 
    const contenedor = document.querySelector('.grid-categorias');

    try {
        const respuesta = await fetch(urlAPI);
        
        if (!respuesta.ok) {
            throw new Error('Error en la red: ' + respuesta.statusText);
        }

        const categorias = await respuesta.json();

        contenedor.innerHTML = '';

        categorias.forEach(categoria => {

            const divCategoria = document.createElement('div');
            divCategoria.classList.add('categoria');

            divCategoria.style.cursor = 'pointer';

            divCategoria.onclick = () => {
                window.location.href = `productos.jsp?categoriaId=${categoria.id}`;
            };

            const nombreImagen = categoria.nombre.toLowerCase();

            divCategoria.innerHTML = `
                <p>${categoria.nombre}</p>
            `;

            contenedor.appendChild(divCategoria);
        });

    } catch (error) {
        console.error('Hubo un problema al cargar las categorías:', error);
        contenedor.innerHTML = '<p>No se pudieron cargar las categorías.</p>';
    }
    
    
}
