/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import exception.PersistenciaException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import interfaces.IReseniasDAO;

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
    
}
