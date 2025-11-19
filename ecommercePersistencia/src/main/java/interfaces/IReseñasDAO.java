/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import exception.PersistenciaException;

/**
 *
 * @author gael_
 */
public interface IReseñasDAO {
    public void eliminarReseña(Long id) throws PersistenciaException;
}
