/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.EstadoTransaccionDTO;
import entidades.EstadoTransaccion;
import exception.CambiarEstadoException;
import exception.PersistenciaException;
import implementaciones.PedidosDAO;
import interfaces.IPedidosBO;
import interfaces.IPedidosDAO;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class PedidosBO implements IPedidosBO{
    IPedidosDAO pedidoDAO;

    public PedidosBO() {
        pedidoDAO = new PedidosDAO();
    }
    
    @Override
    public void cambiarEstadoPedido(Long id, EstadoTransaccionDTO estado) throws CambiarEstadoException {
        try {
            pedidoDAO.cambiarEstadoPedido(id, EstadoTransaccion.ACEPTADO);
        } catch (PersistenciaException ex) {
            throw new CambiarEstadoException("error al cambiar el estado del pedido");
        }
    }
    
}
