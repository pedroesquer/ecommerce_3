/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.ReseñaDTO;
import exception.EliminarReseñaException;
import exception.ObtenerReseniasException;
import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface IReseniasBO {
     public void eliminarResenia(long id) throws EliminarReseñaException;
     public List<ReseñaDTO> obtenerResenias() throws ObtenerReseniasException;
}
