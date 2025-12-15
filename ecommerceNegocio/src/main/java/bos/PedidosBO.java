package bos;

import dtos.EstadoPedidoDTO;
import dtos.EstadoTransaccionDTO;
import dtos.PedidoDTO;
import entidades.Carrito;
import entidades.DetallesCarrito;
import entidades.DetallesPedido;
import entidades.EstadoPedido;
import entidades.EstadoTransaccion;
import entidades.MetodoPago;
import entidades.Pedido;
import entidades.TipoMetodoPago;
import exception.AgregarPedidoException;
import exception.CambiarEstadoException;
import exception.ObtenerPedidoException;
import exception.PersistenciaException;
import implementaciones.CarritosDAO;
import implementaciones.PedidosDAO;
import implementaciones.UsuariosDAO;
import interfaces.ICarritosDAO;
import interfaces.IPedidosBO;
import interfaces.IPedidosDAO;
import interfaces.IUsuariosDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EstadoPedidoMapper;
import mappers.PedidoMapper;

/**
 *
 * @author ramonsebastianzamudioayala, juan pablo heras
 */
public class PedidosBO implements IPedidosBO {

    IPedidosDAO pedidoDAO;
    ICarritosDAO carritosDAO;
    IUsuariosDAO usuariosDAO;

    public PedidosBO() {
        this.pedidoDAO = new PedidosDAO();
        this.carritosDAO = new CarritosDAO();
        this.usuariosDAO = new UsuariosDAO();
    }

    /**
     * Método que cambia el estado de un pedido
     *
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

        try {
            Pedido pedido = pedidoDAO.obtenerPedidoIndividual(id);

            if (pedido == null) {
                return null;
            }
            PedidoDTO dto = PedidoMapper.entityToDTO(pedido);
            return dto;

        } catch (PersistenciaException ex) {
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
        } catch (PersistenciaException ex) {
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

    @Override
    public PedidoDTO crearPedido(Long idUsuario, String tipoPago, String direccionEnvio) throws AgregarPedidoException {
        try {
            Carrito carrito = carritosDAO.obtenerCarritoUsuario(idUsuario);
            if (carrito == null || carrito.getDetallesCarrito().isEmpty()) {
                throw new AgregarPedidoException("El carrito está vacío");
            }

            double total = carrito.getDetallesCarrito()
                    .stream()
                    .mapToDouble(DetallesCarrito::getImporte)
                    .sum();

            TipoMetodoPago tipo;

            try {
                tipo = TipoMetodoPago.valueOf(tipoPago.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new AgregarPedidoException("Tipo de pago inválido");
            }
            
            //Se crea el método de pago para el pedido
            MetodoPago metodoPago = new MetodoPago();
            metodoPago.setTipo(tipo);
            metodoPago.setMonto(total);
            metodoPago.setFechaHora(new Date());
            metodoPago.setEstado(EstadoTransaccion.ACEPTADO);

            //CREAMOS EL PEDIDO PARA ENVIAR
            Pedido pedido = new Pedido();
            pedido.setNumeroPedido(generarNumeroPedido());
            pedido.setUsuario(usuariosDAO.buscarPorId(idUsuario));
            pedido.setMetodoPago(metodoPago); // cascade = PERSIST
            pedido.setDireccion(direccionEnvio);
            pedido.setFecha(new Date());
            pedido.setEstado(EstadoPedido.PREPARANDO);
            pedido.setTotal(total);

            //Crear detalles del pedido desde el carrit
            List<DetallesPedido> detallesPedido = new ArrayList<>();

            for (DetallesCarrito dc : carrito.getDetallesCarrito()) {
                DetallesPedido dp = new DetallesPedido();
                dp.setPedido(pedido);          // relación inversa
                dp.setProducto(dc.getProducto());
                dp.setCantidad(dc.getCantidadProducto());

                detallesPedido.add(dp);
            }

            pedido.setDetallesPedido(detallesPedido);

            pedidoDAO.agregarPedido(pedido);
            
            try {
                carritosDAO.limpiarCarrito(carrito.getId());
            } catch (PersistenciaException e) {
                // Loguear error pero no detener el flujo principal, ya que el pedido SÍ se hizo
                Logger.getLogger(PedidosBO.class.getName()).log(Level.SEVERE, "Pedido creado, pero error al limpiar carrito", e);
            }

            return PedidoMapper.entityToDTO(pedido);

        } catch (PersistenciaException ex) {
            Logger.getLogger(PedidosBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new AgregarPedidoException("Error al crear el pedido", ex);

        }
    }

    private String generarNumeroPedido() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int random = ThreadLocalRandom.current().nextInt(1000, 9999);
        return "PED-" + fecha + "-" + random;
    }

}
