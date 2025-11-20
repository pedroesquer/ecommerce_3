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
    @Test
        void testObtenerTodosPedidos_DebeRegresarDos() throws PersistenciaException {
            PedidosDAO pedidosDAO = new PedidosDAO(); 
        // ASUMIMOS que tu BD tiene EXACTAMENTE 2 pedidos insertados manualmente.
        
        List<Pedido> pedidos = pedidosDAO.obtenerTodosPedidos();

        // 1. Verificar que la lista NO es nula
        assertNotNull(pedidos, "La lista de pedidos no debería ser nula.");
        
        // 2. Verificar que la lista contiene el tamaño esperado (2, según tu solicitud)
        // NOTA: Si el tamaño real cambia, esta prueba fallará.
        assertEquals(2, pedidos.size(), "La lista debería contener 2 pedidos (según los inserts de prueba).");
    }
        
   @Test
    void testTraerUnPedido() throws PersistenciaException{
        PedidosDAO pedidosDAO = new PedidosDAO(); 
        Pedido p = pedidosDAO.obtenerPedidoIndividual(13L);
        assertNotNull(p);
    }
    
    @Test
    public void cambiarEstadoPedido() throws PersistenciaException {
        PedidosDAO dao = new PedidosDAO();
        Long idPedido = 13L;

        dao.cambiarEstadoPedido(idPedido, EstadoPedido.ENTREGADO);

        Pedido pedidoActualizado = dao.obtenerPedidoIndividual(idPedido);

        assertEquals(EstadoPedido.ENTREGADO, pedidoActualizado.getEstado(),
            "El estado del pedido debería haberse actualizado.");
    }
    
}
