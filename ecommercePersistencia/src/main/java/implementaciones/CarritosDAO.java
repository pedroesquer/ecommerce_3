/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Carrito;
import entidades.DetallesCarrito;
import entidades.Pedido;
import entidades.Producto;
import entidades.Usuario;
import exception.PersistenciaException;
import interfaces.ICarritosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author pedro
 */
public class CarritosDAO implements ICarritosDAO {

    @Override
    public List<Carrito> obtenerCarritos() throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();

        try {
            String jpql = "SELECT c FROM Carrito c";

            List<Carrito> carritos = em.createQuery(jpql, Carrito.class)
                    .getResultList();
            return carritos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener carritos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Carrito obtenerCarritoUsuario(Long idUsuario) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        
        try {
            // CAMBIO CLAVE: Usamos LEFT JOIN FETCH para traer los detalles y el producto de una vez
            String jpql = "SELECT c FROM Carrito c " +
                          "LEFT JOIN FETCH c.detallesCarrito dc " +
                          "LEFT JOIN FETCH dc.producto " +
                          "WHERE c.usuario.id = :idUsuario"; // Asumiendo que Usuario tiene atributo id

            TypedQuery<Carrito> query = em.createQuery(jpql, Carrito.class);
            query.setParameter("idUsuario", idUsuario);

            // getSingleResult lanza excepción si no hay resultado. 
            // Podrías usar getResultList().stream().findFirst().orElse(null) si prefieres evitar el try-catch
            return query.getSingleResult();
            
        } catch (NoResultException e) {
            // Si el usuario no tiene carrito, retornamos null o creamos uno nuevo según tu lógica
            return null; 
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener carrito: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Carrito agregarProducto(Producto producto, Long carritoId, Integer cantidad) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        em.getTransaction().begin();

        Carrito carrito = em.find(Carrito.class, carritoId);

        if (carrito == null) {
            em.getTransaction().rollback();
            throw new RuntimeException("Carrito no encontrado con ID: " + carritoId);
        }

        DetallesCarrito detalleExistente = null;

        for (DetallesCarrito detalle : carrito.getDetallesCarrito()) {
            if (detalle.getProducto().getId().equals(producto.getId())) {
                detalleExistente = detalle;
                break;
            }
        }

        if (detalleExistente != null) {
            detalleExistente.setCantidadProducto(detalleExistente.getCantidadProducto() + cantidad);

            float nuevoImporte = detalleExistente.getCantidadProducto() * producto.getPrecio().floatValue();
            detalleExistente.setImporte(nuevoImporte);

        } else {
            float importeInicial = cantidad * producto.getPrecio().floatValue();
            DetallesCarrito nuevoDetalle = new DetallesCarrito(
                    cantidad,
                    producto,
                    carrito
            );
            carrito.getDetallesCarrito().add(nuevoDetalle);
        }

        double nuevoTotal = carrito.getDetallesCarrito().stream()
                .mapToDouble(d -> d.getImporte().doubleValue())
                .sum();
        carrito.setTotal(nuevoTotal);

        Carrito carritoActualizado = em.merge(carrito);

        em.getTransaction().commit();
        return carritoActualizado;
    }

    @Override
    public Carrito eliminarProducto(Long productoId, Long carritoId) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        em.getTransaction().begin();

        Carrito carrito = em.find(Carrito.class, carritoId);

        if (carrito == null) {
            em.getTransaction().rollback();
            throw new RuntimeException("Carrito no encontrado con ID: " + carritoId);
        }

        DetallesCarrito detalleAEliminar = null;

        for (DetallesCarrito detalle : carrito.getDetallesCarrito()) {
            if (detalle.getProducto().getId().equals(productoId)) {
                detalleAEliminar = detalle;
                break;
            }
        }

        if (detalleAEliminar == null) {
            em.getTransaction().rollback();
            throw new RuntimeException("Producto no encontrado en el carrito con ID: " + productoId);
        }

        carrito.getDetallesCarrito().remove(detalleAEliminar);
        em.remove(detalleAEliminar);

        double nuevoTotal = carrito.getDetallesCarrito().stream()
                .mapToDouble(d -> d.getImporte().doubleValue())
                .sum();
        carrito.setTotal(nuevoTotal);

        Carrito carritoActualizado = em.merge(carrito);

        em.getTransaction().commit();
        return carritoActualizado;
    }
}
