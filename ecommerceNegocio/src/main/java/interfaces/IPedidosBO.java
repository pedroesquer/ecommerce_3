/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.EstadoPedidoDTO;
import dtos.EstadoTransaccionDTO;
import entidades.EstadoPedido;
import dtos.PedidoDTO;
import exception.AgregarPedidoException;
import exception.CambiarEstadoException;
import exception.ObtenerPedidoException;
import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface IPedidosBO {

    public void cambiarEstadoPedido(Long id, EstadoPedidoDTO estado) throws CambiarEstadoException;

    public PedidoDTO obtenerPedidoIndividual(Long id) throws ObtenerPedidoException;

    public List<PedidoDTO> obtenerTodosPedidos() throws ObtenerPedidoException;

    public PedidoDTO agregarPedido(PedidoDTO pedido) throws AgregarPedidoException;
}
