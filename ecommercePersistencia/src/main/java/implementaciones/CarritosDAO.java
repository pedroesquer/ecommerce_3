/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Carrito;
import entidades.Pedido;
import entidades.Usuario;
import exception.PersistenciaException;
import interfaces.ICarritosDAO;
import java.util.List;
import javax.persistence.EntityManager;
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
        Usuario usuario = em.find(Usuario.class, idUsuario);

        try {
            String jpql = "SELECT c FROM Carrito c WHERE c.usuario = :usuario";

            TypedQuery<Carrito> query = em.createQuery(jpql, Carrito.class);
            query.setParameter("usuario", usuario); // Establecer el objeto Usuario como parámetro

            return query.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener carrito: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

}
