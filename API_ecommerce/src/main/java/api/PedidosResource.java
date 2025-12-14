package api;

import bos.PedidosBO;
import dtos.DetallePedidoDTO;
import dtos.PedidoDTO;
import exception.AgregarPedidoException;
import exception.ObtenerPedidoException;
import interfaces.IPedidosBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author Juan Pablo Heras
 */
@Path("pedidos")
@RequestScoped
public class PedidosResource {

    @Context
    private UriInfo context;

    private IPedidosBO pedidosBO = new PedidosBO();

    /**
     * Creates a new instance of PedidosResource
     */
    public PedidosResource() {
    }

    /**
     * Retrieves representation of an instance of api.PedidosResource
     *
     * @return an instance of dtos.PedidoDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoDTO> getJson() {

        try {
            List<PedidoDTO> pedidos = pedidosBO.obtenerTodosPedidos();
            if(pedidos != null){
                for(PedidoDTO p : pedidos){
                    if (p.getUsuario() != null) {
                        p.getUsuario().setContrasenia(null); // Ocultar password
                        p.getUsuario().setTelefono(null);    // Ocultar otros datos si quieres
                    }
                }
            }
            return pedidos;
        } catch (ObtenerPedidoException ex) {
            Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    @GET
    @Path("/usuario/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoDTO> obtenerPedidosUsuario(@PathParam("idUsuario") Long idUsuario) {
        try {
            List<PedidoDTO> pedidos = pedidosBO.obtenerPedidosPorUsuario(idUsuario);
            
            // --- OCULTAR DATOS SENSIBLES ---
            if (pedidos != null) {
                for (PedidoDTO p : pedidos) {
                    if (p.getUsuario() != null) {
                        p.getUsuario().setContrasenia(null); // Ocultar password
                        p.getUsuario().setTelefono(null);    // Ocultar otros datos si quieres
                    }
                }
                return pedidos;
            } else {
                throw new WebApplicationException("Pedidos no encontrados", Response.Status.NOT_FOUND);
            }
        } catch (Exception ex) {
            throw new WebApplicationException("Error al obtener los pedidos del usuario", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
        @GET
        @Path("/mis-pedidos")  
        @Produces(MediaType.APPLICATION_JSON)
        public Response obtenerMisPedidos(@Context ContainerRequestContext ctx) {
            try {
                // Obtener el ID del usuario desde el JWT
                Long usuarioId = Long.valueOf(ctx.getProperty("usuarioId").toString());

                List<PedidoDTO> pedidos = pedidosBO.obtenerPedidosPorUsuario(usuarioId);

                if (pedidos == null || pedidos.isEmpty()) {
                    return Response.ok(new ArrayList<>()).build(); 
                }

                // Limpiar datos sensibles
                for (PedidoDTO p : pedidos) {
                    if (p.getUsuario() != null) {
                        p.getUsuario().setContrasenia(null);

                    }

                    // Limpiar productos si tienen reseñas
                    if (p.getDetallesPedido() != null) {
                        for (DetallePedidoDTO detalle : p.getDetallesPedido()) {
                            if (detalle.getProducto() != null) {
                                detalle.getProducto().setReseñas(null);
                            }
                        }
                    }
                }

                return Response.ok(pedidos).build();

            } catch (Exception ex) {
                Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, ex);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("{\"error\": \"Error al obtener pedidos\"}")
                        .build();
            }
        }

//    @GET
//    @Path("/{id}")  // La ruta que incluye el ID del producto
//    @Produces(MediaType.APPLICATION_JSON)
//    public PedidoDTO getPedidoById(@PathParam("id") long id) {
//        try {
//            // Obtener el producto por ID desde el negocio (productosBO)
//            PedidoDTO pedido = pedidosBO.obtenerPedidoIndividual(id);
//            if (pedido != null) {
//                pedido.getUsuario().setContrasenia(null);
//                return pedido;
//            } else {
//                // Si no se encuentra el producto, puedes retornar un error 404 o similar
//                throw new WebApplicationException("Producto no encontrado", Response.Status.NOT_FOUND);
//            }
//        } catch (Exception ex) {
//            // Manejar excepciones generales
//            throw new WebApplicationException("Error al obtener el producto", Response.Status.INTERNAL_SERVER_ERROR);
//        }
//    }
        
    @GET
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoDTO getPedidoById(@PathParam("id") long id) {
        try {
            PedidoDTO pedido = pedidosBO.obtenerPedidoIndividual(id);
            if (pedido != null) {
                pedido.getUsuario().setContrasenia(null);
                return pedido;
            } else {
                throw new WebApplicationException("Producto no encontrado", Response.Status.NOT_FOUND);
            }
        } catch (Exception ex) {

            throw new WebApplicationException("Error al obtener el producto", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearPedido(PedidoDTO pedidoDTO) {

        try {
            PedidoDTO nuevoPedido = pedidosBO.agregarPedido(pedidoDTO);

            return Response.status(Response.Status.CREATED)
                    .entity(nuevoPedido) 
                    .build();
        } catch (AgregarPedidoException ex) {
            Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, ex);

            
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al registrar el pedido: " + ex.getMessage()) 
                    .build();
        }

    }

    /**
     * PUT method for updating or creating an instance of PedidosResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(PedidoDTO content) {
    }
}
