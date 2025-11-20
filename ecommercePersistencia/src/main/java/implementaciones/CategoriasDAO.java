/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Categoria;
import exception.PersistenciaException;
import interfaces.ICategoriasDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author juanpheras
 */
public class CategoriasDAO implements ICategoriasDAO{

    @Override
    public Categoria obtenerPorId(Long id) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            String jpql = "SELECT c FROM Categoria c WHERE c.id = :id";
            TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
            query.setParameter("id", id);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al encontrar la categoria", e);
        }
    }
    public List<Categoria> obtenerCategorias() throws PersistenciaException{
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class)
                     .getResultList();
        } finally {
            entityManager.close();
        }
    }
}
