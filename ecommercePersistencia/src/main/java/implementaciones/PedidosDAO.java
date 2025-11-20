/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.EstadoPedido;
import entidades.EstadoTransaccion;
import entidades.Pedido;
import exception.PersistenciaException;
import implementaciones.ManejadorConexiones;
import interfaces.IPedidosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author gael_
 */
public class PedidosDAO implements IPedidosDAO {

    @Override
    public void cambiarEstadoPedido(Long id, EstadoPedido estado) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        
        try{
            
            em.getTransaction().begin();
            em.createQuery("UPDATE Pedido p SET p.estado = :estado WHERE p.id = :id")
            .setParameter("estado", estado)
            .setParameter("id", id)

            .executeUpdate();
            

        em.getTransaction().commit();
            
        } catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al cambiar estado de pedido: " + e.getMessage(), e);
        } finally{
            em.close();
        }
    }

    @Override
    public Pedido obtenerPedidoIndividual(Long id) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            String jpql = "SELECT p FROM Pedido p WHERE p.id = :id";
            TypedQuery<Pedido> query = entityManager.createQuery(jpql, Pedido.class);
            query.setParameter("id", id);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al encontrar la categoria", e);
        }
    
            
        
    }

    @Override
    public List<Pedido> obtenerTodosPedidos() throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        
        try{
            String jpql = "SELECT P FROM Pedido p";
            
            List<Pedido> pedidos = em.createQuery(jpql, Pedido.class)
                    .getResultList();
            return pedidos;
    } catch (Exception e){
        throw new PersistenciaException("Error al obtener productos: " + e.getMessage(), e);
    } finally{
            em.close();
        }
      }      

}
