/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bos;

import dtos.EstadoPedidoDTO;
import dtos.PedidoDTO;
import entidades.EstadoPedido;
import entidades.EstadoTransaccion;
import entidades.MetodoPago;
import entidades.Pedido;
import entidades.TipoMetodoPago;
import entidades.Usuario;
import exception.ObtenerPedidoException;
import interfaces.IPedidosBO;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import mappers.PedidoMapper;
import mappers.UsuarioMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pedro
 */
public class PedidosBOTest {
    
    PedidosBO bo = new PedidosBO();
    
    public PedidosBOTest() {
    }

//    @Test
//    public void testObtenerPedidosPorUsuarioId1() {
//        System.out.println("=== Prueba: obtenerPedidosPorUsuario con ID = 1 ===");
//        
//        // Arrange (Preparar)
//        IPedidosBO pedidosBO = new PedidosBO();
//        Long idUsuario = 1L;
//        
//        try {
//            // Act (Actuar)
//            List<PedidoDTO> resultado = pedidosBO.obtenerPedidosPorUsuario(idUsuario);
//            
//            // Assert (Verificar)
//            assertNotNull(resultado);
//            assertFalse(resultado.isEmpty());
//            assertEquals(2, resultado.size());
//
//        } catch (ObtenerPedidoException ex) {
//            fail("No debería lanzar excepción: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }

}
