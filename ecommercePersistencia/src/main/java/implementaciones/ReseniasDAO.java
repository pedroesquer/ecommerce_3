/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Producto;
import entidades.Reseña;
import exception.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import interfaces.IReseniasDAO;
import java.util.List;

/**
 *
 * @author gael_
 */
public class ReseniasDAO implements IReseniasDAO{

    @Override
    public void eliminarResenia(Long id) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            
            String jpqlQuery = """
                               DELETE FROM Reseña r WHERE r.id = :id
                               """;
            Query query = entityManager.createQuery(jpqlQuery);
            query.setParameter("id", id);
            query.executeUpdate();
            
            entityManager.getTransaction().commit();

        } catch(Exception e) {
            if (entityManager.getTransaction().isActive()) { 
            entityManager.getTransaction().rollback();
        }
        throw new PersistenciaException("Error al eliminar la reseña: " + e.getMessage(), e);
        } finally{
            entityManager.close();
        }
    }

    /**
     * Método para obtener todas las resenias de la base de datos
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<Reseña> obtenerResenias() throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        try {
            // Consulta JPQL CORRECTA
            String jpql = "SELECT r FROM Reseña r";

            List<Reseña> resenias = em.createQuery(jpql, Reseña.class)
                    .getResultList();

            return resenias;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener resenias: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
}
