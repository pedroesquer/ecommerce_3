/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.ReseñaDTO;
import entidades.Reseña;
import exception.EliminarReseñaException;
import exception.ObtenerReseniasException;
import exception.PersistenciaException;
import exception.ReseniaException;
import implementaciones.ReseniasDAO;
import interfaces.IReseniasBO;
import interfaces.IReseniasDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ReseñaMapper;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class ReseniasBO implements IReseniasBO {

    IReseniasDAO reseniaDAO;

    public ReseniasBO() {
        reseniaDAO = new ReseniasDAO();
    }

    /**
     * Método para eliminar una reseña por su id.
     * @param id id de la reseña a eliminar.
     * @throws EliminarReseñaException 
     */
    @Override
    public void eliminarResenia(long id) throws EliminarReseñaException {
        try {
            reseniaDAO.eliminarResenia(id);
        } catch (PersistenciaException ex) {
            throw new EliminarReseñaException("La reseña a elimimnar no existe");
        }
    }

    /**
     * Método de negocio que obtiene todas las reseñas registradas y las
     * convierte en DTO para mandarlas.
     *
     * @return la lista de las reseñas en DTO.
     * @throws ObtenerReseniasException
     */
    @Override
    public List<ReseñaDTO> obtenerResenias() throws ObtenerReseniasException {

        try {
            List<Reseña> resenias = reseniaDAO.obtenerResenias();

            List<ReseñaDTO> reseniasDTO = new ArrayList<>();

            for (Reseña resenia : resenias) {
                ReseñaDTO reseniaDTO = ReseñaMapper.entityToDTO(resenia);
                reseniasDTO.add(reseniaDTO);
            }

            return reseniasDTO;
        } catch (PersistenciaException ex) {
            throw new ObtenerReseniasException("No se pudieron obtener las reseñas");
        }

    }

    @Override
    public void agregarResenia(ReseñaDTO nuevaResenia) throws ReseniaException {
        if (nuevaResenia == null) {
            throw new ReseniaException("La reseña recibida es nula.");
        }
        
        if (nuevaResenia.getEstrellas() == null || nuevaResenia.getEstrellas() < 1 || nuevaResenia.getEstrellas() > 5) {
            throw new ReseniaException("La calificación debe ser entre 1 y 5 estrellas.");
        }
        
        if (nuevaResenia.getComentario() == null || nuevaResenia.getComentario().trim().isEmpty()) {
            throw new ReseniaException("El comentario de la reseña no puede estar vacío.");
        }

        if (nuevaResenia.getUsuario() == null) {
            throw new ReseniaException("La reseña debe estar asociada a un usuario.");
        }

        try {
            reseniaDAO.agregarResenia(nuevaResenia);
        } catch (PersistenciaException ex) {
            throw new ReseniaException("Error al intentar guardar la reseña: " + ex.getMessage(), ex);
        }
    }

}
