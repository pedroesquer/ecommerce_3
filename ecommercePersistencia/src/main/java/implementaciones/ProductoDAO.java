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

            String jpqlQuery = """
                               DELETE FROM Producto p WHERE p.id = :id
                               """;
            Query query = entityManager.createQuery(jpqlQuery);
            query.setParameter("id", id);
            query.executeUpdate();

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el producto: " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void agregarProducto(ProductoDTO nuevoProducto) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Producto producto = new Producto();
            producto.setNombre(nuevoProducto.getNombre());
            producto.setPrecio(nuevoProducto.getPrecio());
            producto.setRutaImagen(nuevoProducto.getRutaImagen());
            producto.setStock(nuevoProducto.getStock());
            producto.setDescripcion(nuevoProducto.getDescripcion());
            producto.setDisponibilidad(nuevoProducto.getDisponibilidad());
            producto.setEspecificacionesTecnicas(nuevoProducto.getEspecificacionesTecnicas());
            producto.setResenias(new ArrayList<>());

            entityManager.persist(producto);
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
            String nuevoNombre = nuevoProducto.getNombre();
            Double nuevoPrecio = nuevoProducto.getPrecio();
            Integer nuevoStock = nuevoProducto.getStock();
            String nuevaDescripcion = nuevoProducto.getDescripcion();
            Boolean nuevaDisponibilidad = nuevoProducto.getDisponibilidad();
            String nuevasEspecificaciones = nuevoProducto.getEspecificacionesTecnicas();

            em.getTransaction().begin();

            em.createQuery("UPDATE Producto p SET "
                    + "p.nombre = :nombre, "
                    + "p.precio = :precio, "
                    + "p.stock = :stock, "
                    + "p.descripcion = :descripcion, "
                    + "p.disponibilidad = :disponibilidad, "
                    + "p.especificacionesTecnicas = :especificacionesTecnicas"
                    + "WHERE p.id = :id")
                    .setParameter("nombre", nuevoNombre)
                    .setParameter("precio", nuevoPrecio)
                    .setParameter("stock", nuevoStock)
                    .setParameter("descripcion", nuevaDescripcion)
                    .setParameter("disponibilidad", nuevaDisponibilidad)
                    .setParameter("especificacionesTecnicas", nuevasEspecificaciones)
                    .setParameter("id", id)
                    .executeUpdate();

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new PersistenciaException("Error al editar el producto con ID: " + id, e);
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

}
