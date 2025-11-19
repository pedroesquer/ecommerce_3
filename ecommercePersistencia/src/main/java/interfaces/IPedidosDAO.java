/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.EstadoTransaccion;
import exception.PersistenciaException;

/**
 *
 * @author gael_
 */
public interface IPedidosDAO {
    public void cambiarEstadoPedido(Long id, EstadoTransaccion estado) throws PersistenciaException;
}
