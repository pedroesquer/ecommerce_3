/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bos;

import dtos.PedidoDTO;
import interfaces.IPedidosBO;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pedro
 */
public class PedidosBOTest {
    
    public PedidosBOTest() {
    }

    /**
     * Test of cambiarEstadoPedido method, of class PedidosBO.
     */
    @Test
    public void testCambiarEstadoPedido() throws Exception {
    }

    /**
     * Test of obtenerPedidoIndividual method, of class PedidosBO.
     */
    @Test
    public void testObtenerPedidoIndividual() throws Exception {
    }

    /**
     * Test of obtenerTodosPedidos method, of class PedidosBO.
     */
    @Test
    public void testObtenerTodosPedidosOk() throws Exception {
        IPedidosBO pedidosBO = new PedidosBO();
        List<PedidoDTO> listaPedidos = pedidosBO.obtenerTodosPedidos();
        for (PedidoDTO listaPedido : listaPedidos) {
            System.out.println(listaPedido.getId());
        }
        
    }
    
}
