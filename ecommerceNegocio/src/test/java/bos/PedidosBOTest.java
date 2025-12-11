///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package bos;
//
//import dtos.EstadoPedidoDTO;
//import dtos.PedidoDTO;
//import entidades.EstadoPedido;
//import entidades.EstadoTransaccion;
//import entidades.MetodoPago;
//import entidades.Pedido;
//import entidades.TipoMetodoPago;
//import entidades.Usuario;
//import exception.ObtenerPedidoException;
//import interfaces.IPedidosBO;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import mappers.PedidoMapper;
//import mappers.UsuarioMapper;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author pedro
// */
//public class PedidosBOTest {
//    
//    PedidosBO bo = new PedidosBO();
//    
//    public PedidosBOTest() {
//    }
//
//    /**
//     * Test of cambiarEstadoPedido method, of class PedidosBO.
//     */
//    @Test
//    public void testCambiarEstadoPedido() throws Exception {
//    }
//
//    /**
//     * Test of obtenerPedidoIndividual method, of class PedidosBO.
//     */
//    @Test
//    public void testObtenerPedidoIndividual() throws Exception {
//    }
//
//    /**
//     * Test of obtenerTodosPedidos method, of class PedidosBO.
//     */
//    @Test
//    public void testObtenerTodosPedidos() throws Exception {
//    }
//
//    /**
//     * Test of agregarPedido method, of class PedidosBO.
//     */
//    @Test
//    public void testAgregarPedido() throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setId(2l);
//        Date fecha = new Date();
//        MetodoPago pago = new MetodoPago(EstadoTransaccion.ACEPTADO, 2500.0, LocalDateTime.now(), TipoMetodoPago.TARJETA);
//        Pedido pedido =  new Pedido("USA43542", EstadoPedido.ENVIADO, 2500.0, fecha, "Hollywood Arts #3233", usuario, pago);
//        PedidoDTO pedidoBD = bo.agregarPedido(PedidoMapper.entityToDTO(pedido));
//        assertEquals(pedido.getNumeroPedido(), pedidoBD.getNumeroPedido());
////    }
//    }
//
//    /**
//     * Test of obtenerTodosPedidos method, of class PedidosBO.
//     */
////    @Test
////    public void testObtenerTodosPedidosOk() throws Exception {
////        IPedidosBO pedidosBO = new PedidosBO();
////        List<PedidoDTO> listaPedidos = pedidosBO.obtenerTodosPedidos();
////        assertNotNull(listaPedidos);
////        assertEquals(2, listaPedidos.size(), "La lista debería contener 2 pedidos (según los inserts de prueba).");
////        
////    }
////    
////    @Test
////    void testTraerUnPedido() throws ObtenerPedidoException{
////        IPedidosBO pedidosBO = new PedidosBO();
////        PedidoDTO p = pedidosBO.obtenerPedidoIndividual(1L);
////        assertNotNull(p);
////    }
////    
//}
