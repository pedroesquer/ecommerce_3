
package bos;

import dtos.EstadoPedidoDTO;
import dtos.EstadoTransaccionDTO;
import entidades.EstadoPedido;
import exception.CambiarEstadoException;
import exception.PersistenciaException;
import implementaciones.PedidosDAO;
import interfaces.IPedidosBO;
import interfaces.IPedidosDAO;
import mappers.EstadoPedidoMapper;

/**
 *
 * @author ramonsebastianzamudioayala, juan pablo heras
 */
public class PedidosBO implements IPedidosBO{
    IPedidosDAO pedidoDAO;

    public PedidosBO() {
        pedidoDAO = new PedidosDAO();
    }
    
    /**
     * Método que cambia el estado de un pedido
     * @param id identificador del pedido a cambiar
     * @param estado nuevo estado del pedido
     * @throws CambiarEstadoException 
     */
    @Override
    public void cambiarEstadoPedido(Long id, EstadoPedidoDTO estado) throws CambiarEstadoException {
        try {
            pedidoDAO.cambiarEstadoPedido(id, EstadoPedidoMapper.toEntity(estado));
        } catch (PersistenciaException ex) {
            throw new CambiarEstadoException("error al cambiar el estado del pedido");
        }
    }

   
    
}
