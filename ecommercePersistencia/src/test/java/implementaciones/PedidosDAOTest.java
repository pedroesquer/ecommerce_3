/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import entidades.EstadoPedido;
import entidades.Pedido;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gael_
 */
public class PedidosDAOTest {
    
    public PedidosDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of cambiarEstadoPedido method, of class PedidosDAO.
     */
//    @Test
//        void testObtenerTodosPedidos_DebeRegresarDos() throws PersistenciaException {
//            PedidosDAO pedidosDAO = new PedidosDAO(); 
//      
//            List<Pedido> pedidos = pedidosDAO.obtenerTodosPedidos();
//
//            assertNotNull(pedidos, "La lista de pedidos no debería ser nula.");
//
//            assertEquals(2, pedidos.size(), "La lista debería contener 2 pedidos (según los inserts de prueba).");
//    }
//        
//   @Test
//    void testTraerUnPedido() throws PersistenciaException{
//        PedidosDAO pedidosDAO = new PedidosDAO(); 
//        Pedido p = pedidosDAO.obtenerPedidoIndividual(1L);
//        assertNotNull(p);
//    }
//    
//    @Test
//    public void cambiarEstadoPedido() throws PersistenciaException {
//        PedidosDAO dao = new PedidosDAO();
//        Long idPedido = 1L;
//
//        dao.cambiarEstadoPedido(idPedido, EstadoPedido.ENTREGADO);
//
//        Pedido pedidoActualizado = dao.obtenerPedidoIndividual(idPedido);
//
//        assertEquals(EstadoPedido.ENTREGADO, pedidoActualizado.getEstado(),
//            "El estado del pedido debería haberse actualizado.");
//    }
    
}
