
package bos;

import dtos.EstadoPedidoDTO;
import dtos.EstadoTransaccionDTO;
import dtos.PedidoDTO;
import entidades.Pedido;
import exception.AgregarPedidoException;
import exception.CambiarEstadoException;
import exception.ObtenerPedidoException;
import exception.PersistenciaException;
import implementaciones.PedidosDAO;
import interfaces.IPedidosBO;
import interfaces.IPedidosDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EstadoPedidoMapper;
import mappers.PedidoMapper;



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


    @Override
    public PedidoDTO obtenerPedidoIndividual(Long id) throws ObtenerPedidoException {

        try{
                Pedido pedido = pedidoDAO.obtenerPedidoIndividual(id);

                if (pedido == null) {
                    return null;
                }
                PedidoDTO dto = PedidoMapper.entityToDTO(pedido);
                return dto;


            } catch (PersistenciaException ex){
                throw new ObtenerPedidoException("Error al cargar el pedido");
            }
    
    }

    @Override
    public List<PedidoDTO> obtenerTodosPedidos() throws ObtenerPedidoException {
        try {
            List<Pedido> pedidos = pedidoDAO.obtenerTodosPedidos();
            List<PedidoDTO> pedidosDTO = new ArrayList<>();
            for (Pedido p : pedidos) {
                PedidoDTO pedidoDTO = PedidoMapper.entityToDTO(p);
                pedidosDTO.add(pedidoDTO);
            }
            return pedidosDTO;
        } catch (PersistenciaException ex){
            throw new ObtenerPedidoException("hubo un problema al cargar los pedidos");
        }
    }

    @Override
    public PedidoDTO agregarPedido(PedidoDTO pedido) throws AgregarPedidoException {
        Pedido nuevoPedido = PedidoMapper.dtoToEntity(pedido);
        try {
            pedidoDAO.agregarPedido(nuevoPedido);
            return PedidoMapper.entityToDTO(nuevoPedido);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PedidosBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new AgregarPedidoException("Ocurrió un error al agregar el pedido " + ex.getMessage());
        }
    }

    @Override
    public List<PedidoDTO> obtenerPedidosPorUsuario(Long idUsuario) throws ObtenerPedidoException {
        try {
            List<Pedido> pedidos = pedidoDAO.obtenerPedidosPorUsuario(idUsuario); 
            List<PedidoDTO> pedidosDTO = new ArrayList<>();

            for (Pedido p : pedidos) {
                pedidosDTO.add(PedidoMapper.entityToDTO(p));
            }
            return pedidosDTO;
        } catch (PersistenciaException ex) {
            throw new ObtenerPedidoException("Error al cargar los pedidos del usuario");
        }
    }

}
