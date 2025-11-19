/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.EstadoTransaccion;
import exception.PersistenciaException;
import interfaces.IPedidosDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author gael_
 */
public class PedidosDAO implements IPedidosDAO {

    @Override
    public void cambiarEstadoPedido(Long id, EstadoTransaccion estado) throws PersistenciaException {
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
    
}
