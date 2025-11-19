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

}
