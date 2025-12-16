/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dtos.ProductoDTO;
import entidades.Producto;
import entidades.Reseña;
import exception.PersistenciaException;
import interfaces.IProductosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author gael_
 */
public class ProductoDAO implements IProductosDAO {

    @Override
    public boolean eliminarProducto(Long id) throws PersistenciaException {
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

            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el producto: " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Producto agregarProducto(Producto nuevoProducto) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(nuevoProducto);
            entityManager.getTransaction().commit();
            return nuevoProducto;

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
            String nuevoNombre = nuevoProducto.getNombre();
            Double nuevoPrecio = nuevoProducto.getPrecio();
            Integer nuevoStock = nuevoProducto.getStock();
            String nuevaDescripcion = nuevoProducto.getDescripcion();
            Boolean nuevaDisponibilidad = nuevoProducto.getDisponibilidad();
            String nuevaRutaImagen = nuevoProducto.getRutaImagen();

            Long nuevaCategoriaId = nuevoProducto.getCategoria().getId();

            em.getTransaction().begin();

            entidades.Categoria categoriaRef = em.getReference(entidades.Categoria.class, nuevaCategoriaId);

            String jpql = "UPDATE Producto p SET "
                    + "p.nombre = :nombre, "
                    + "p.precio = :precio, "
                    + "p.stock = :stock, "
                    + "p.descripcion = :descripcion, "
                    + "p.disponibilidad = :disponibilidad, "
                    + "p.rutaImagen = :rutaImagen, "
                    + "p.categoria = :categoria " 
                    + "WHERE p.id = :id";

            Query query = em.createQuery(jpql);

            query.setParameter("nombre", nuevoNombre);
            query.setParameter("precio", nuevoPrecio);
            query.setParameter("stock", nuevoStock);
            query.setParameter("descripcion", nuevaDescripcion);
            query.setParameter("disponibilidad", nuevaDisponibilidad);
            query.setParameter("rutaImagen", nuevaRutaImagen);

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
        // AGREGAMOS "LEFT JOIN FETCH r.usuario" para traer los datos del autor de la reseña
        String jpql = "SELECT p FROM Producto p " +
                      "LEFT JOIN FETCH p.resenias r " +
                      "LEFT JOIN FETCH r.usuario " +
                      "WHERE p.id=:id";

        Producto producto = em.createQuery(jpql, Producto.class)
                .setParameter("id", id)
                .getSingleResult();

        return producto;
    } catch (javax.persistence.NoResultException e) {
        return null;
    } catch (Exception e) {
        throw new PersistenciaException("Error al buscar el producto: " + e.getMessage(), e);
    } finally {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}

    @Override
    public List<Producto> buscarProductosDinamico(String nombre, Long categoriaId, Double precioMin, Double precioMax) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            StringBuilder jpql = new StringBuilder("SELECT p FROM Producto p WHERE 1=1");

            if (nombre != null && !nombre.isEmpty()) {
                jpql.append(" AND LOWER(p.nombre) LIKE :nombre");
            }
            if (categoriaId != null) {
                jpql.append(" AND p.categoria.id = :categoriaId");
            }
            if (precioMin != null) {
                jpql.append(" AND p.precio >= :precioMin");
            }
            if (precioMax != null) {
                jpql.append(" AND p.precio <= :precioMax");
            }

            Query query = em.createQuery(jpql.toString(), Producto.class);

            if (nombre != null && !nombre.isEmpty()) {
                query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
            }
            if (categoriaId != null) {
                query.setParameter("categoriaId", categoriaId);
            }
            if (precioMin != null) {
                query.setParameter("precioMin", precioMin);
            }
            if (precioMax != null) {
                query.setParameter("precioMax", precioMax);
            }

            return query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos con filtros: " + e.getMessage(), e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Reseña> obtenerReseñas(Long id) throws PersistenciaException{
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            String jpql = "SELECT p FROM Producto p LEFT JOIN FETCH p.resenias WHERE p.id=:id";

            Producto producto = em.createQuery(jpql, Producto.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return producto.getResenias();
        } catch (javax.persistence.NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar el producto: " + e.getMessage(), e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    @Override 
    public boolean verificarCompraUsuario(Long idUsuario, Long idProducto) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            String jpql = """
                SELECT COUNT(dp) 
                FROM DetallesPedido dp 
                JOIN dp.pedido p 
                WHERE p.usuario.id = :idUsuario 
                AND dp.producto.id = :idProducto
            """;

            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("idUsuario", idUsuario);
            query.setParameter("idProducto", idProducto);

            Long cantidad = query.getSingleResult();

            return cantidad > 0;

        } catch (Exception e) {
            throw new PersistenciaException("Error al verificar si el usuario compró el producto", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
