/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.EstadoPedidoDTO;
import dtos.EstadoTransaccionDTO;
import entidades.EstadoPedido;
import exception.CambiarEstadoException;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface IPedidosBO {
    public void cambiarEstadoPedido(Long id, EstadoPedidoDTO estado) throws CambiarEstadoException;
}
