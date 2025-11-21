/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dtos.ProductoDTO;
import entidades.Producto;
import exception.PersistenciaException;
import interfaces.IProductosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gael_
 */
public class ProductoDAO implements IProductosDAO {

    @Override
    public void eliminarProducto(Long id) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            String deleteDetalles = """
            DELETE FROM DetallesPedido d WHERE d.producto.id = :id
        """;
            Query queryDetalles = entityManager.createQuery(deleteDetalles);
            queryDetalles.setParameter("id", id);
            queryDetalles.executeUpdate();

            String deleteResenias = """
            DELETE FROM Reseña r WHERE r.producto.id = :id
        """;
            Query queryResenias = entityManager.createQuery(deleteResenias);
            queryResenias.setParameter("id", id);
            queryResenias.executeUpdate();

            String deleteProducto = """
            DELETE FROM Producto p WHERE p.id = :id
        """;
            Query queryProducto = entityManager.createQuery(deleteProducto);
            queryProducto.setParameter("id", id);
            queryProducto.executeUpdate();

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el producto: " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void agregarProducto(Producto nuevoProducto) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(nuevoProducto);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar el producto: " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void editarProducto(Long id, ProductoDTO nuevoProducto) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            // 1. Extraer datos del DTO
            String nuevoNombre = nuevoProducto.getNombre();
            Double nuevoPrecio = nuevoProducto.getPrecio();
            Integer nuevoStock = nuevoProducto.getStock();
            String nuevaDescripcion = nuevoProducto.getDescripcion();
            Boolean nuevaDisponibilidad = nuevoProducto.getDisponibilidad();
            String nuevaRutaImagen = nuevoProducto.getRutaImagen();

            // 2. Obtener el ID de la categoría
            Long nuevaCategoriaId = nuevoProducto.getCategoria().getId();

            em.getTransaction().begin();

            // --- CAMBIO CLAVE AQUÍ ---
            // Para actualizar una relación en JPQL, necesitamos el OBJETO Categoria, no solo el ID.
            // Usamos getReference porque es más eficiente (no hace Select si no es necesario), 
            // solo crea un proxy para asignarlo.
            entidades.Categoria categoriaRef = em.getReference(entidades.Categoria.class, nuevaCategoriaId);

            // 3. Consulta JPQL Corregida
            // Nota el cambio: "p.categoria = :categoria" (sin el .id)
            String jpql = "UPDATE Producto p SET "
                    + "p.nombre = :nombre, "
                    + "p.precio = :precio, "
                    + "p.stock = :stock, "
                    + "p.descripcion = :descripcion, "
                    + "p.disponibilidad = :disponibilidad, "
                    + "p.rutaImagen = :rutaImagen, "
                    + "p.categoria = :categoria " // <--- AQUI ESTABA EL ERROR (quitamos .id)
                    + "WHERE p.id = :id";

            Query query = em.createQuery(jpql);

            query.setParameter("nombre", nuevoNombre);
            query.setParameter("precio", nuevoPrecio);
            query.setParameter("stock", nuevoStock);
            query.setParameter("descripcion", nuevaDescripcion);
            query.setParameter("disponibilidad", nuevaDisponibilidad);
            query.setParameter("rutaImagen", nuevaRutaImagen);

            // Pasamos el OBJETO completo, no el Long
            query.setParameter("categoria", categoriaRef);

            query.setParameter("id", id);

            int filasAfectadas = query.executeUpdate();

            em.getTransaction().commit();

            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontró el producto con ID: " + id);
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new PersistenciaException("Error al editar el producto con ID: " + id + " | " + e.getMessage(), e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Producto> obtenerProductos() throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            // Consulta JPQL CORRECTA
            String jpql = "SELECT p FROM Producto p";

            List<Producto> productos = em.createQuery(jpql, Producto.class)
                    .getResultList();

            return productos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener productos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Producto obtenerProductoPorId(Long id) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            String jpql = "SELECT p FROM Producto p LEFT JOIN FETCH p.resenias WHERE p.id=:id";

            Producto producto = em.createQuery(jpql, Producto.class)
                    .setParameter("id", id)
                    .getSingleResult();

            return producto;
        } catch (javax.persistence.NoResultException e) {
            // Si no encuentra el producto, retorna null
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar el producto: " + e.getMessage(), e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
