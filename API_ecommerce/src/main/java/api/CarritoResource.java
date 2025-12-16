package api;

import bos.CarritosBO;
import bos.ProductoBO;
import dtos.AgregarProductoCarritoDTO;
import dtos.CarritoDTO;
import dtos.DetallesCarritoDTO;
import dtos.ProductoDTO;
import exception.CarritoException;
import interfaces.ICarritosBO;
import interfaces.IProductosBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author pedro
 */
@Path("carrito")
@RequestScoped
public class CarritoResource {

    ICarritosBO carritosBO = new CarritosBO();
    IProductosBO productosBO = new ProductoBO();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarritoResource
     */
    public CarritoResource() {
    }

    /**
     * Retrieves representation of an instance of api.CarritoResource
     *
     * @return an instance of dtos.CarritoDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarritoDTO> getCarritos() {
        try {
            return carritosBO.obtenerCarritos();
        } catch (CarritoException e) {
            Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @GET
    @Path("/mi-carrito")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerMiCarrito(@Context ContainerRequestContext ctx) {
        try {
            Object idObj = ctx.getProperty("usuarioId");

            if (idObj == null) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

            Long idUsuario = Long.valueOf(idObj.toString());

            CarritoDTO carrito = carritosBO.obtenerCarritoUsuario(idUsuario);

            if (carrito == null) {

                return Response.status(Response.Status.NOT_FOUND).entity("No hay carrito").build();
            }

            return Response.ok(carrito).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener carrito: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/agregarProductoCarrito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarProducto(AgregarProductoCarritoDTO dto,
            @Context ContainerRequestContext ctx) {

        Object idObj = ctx.getProperty("usuarioId");
        if (idObj == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        if (dto.getIdProducto() == null || dto.getCantidad() == null || dto.getCantidad() <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Long idUsuario = Long.valueOf(idObj.toString());
        try {
            CarritoDTO carrito
                    = carritosBO.agregarProducto(idUsuario, dto.getIdProducto(), dto.getCantidad());
            return Response.status(Response.Status.CREATED).entity(carrito).build();

        } catch (CarritoException ex) {
            Logger.getLogger(CarritoResource.class.getName()).log(Level.SEVERE, null, ex);
             return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + ex.getMessage())
                    .build();
        }
        
    }

    @DELETE
    @Path("/eliminarProductoCarrito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProducto(DetallesCarritoDTO detallesCarrito) {
        Long idCarrito = detallesCarrito.getCarrito();

        Long idProducto = null;
        if (detallesCarrito.getProducto() != null) {
            idProducto = detallesCarrito.getProducto().getId();
        }

        if (idProducto == null || idCarrito == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Faltan datos para eliminar el producto del carrito.")
                    .build();
        }

        try {
            CarritoDTO carritoActualizado
                    = carritosBO.eliminarProducto(idProducto, idCarrito);

            if (carritoActualizado == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Error: El producto no existe en el carrito.")
                        .build();
            }

            return Response.ok(carritoActualizado).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/modificarCantidadProducto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarCantidadProducto(DetallesCarritoDTO detallesCarrito) {
        if (detallesCarrito == null
                || detallesCarrito.getCarrito() == null
                || detallesCarrito.getProducto() == null
                || detallesCarrito.getProducto().getId() == null
                || detallesCarrito.getCantidadProductos() == null
                || detallesCarrito.getCantidadProductos() <= 0) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos inválidos para modificar la cantidad del producto")
                    .build();
        }

        Long idCarrito = detallesCarrito.getCarrito();
        Long idProducto = detallesCarrito.getProducto().getId();
        Integer nuevaCantidad = detallesCarrito.getCantidadProductos();

        try {
            CarritoDTO carritoActualizado
                    = carritosBO.modificarCantidadProducto(
                            idCarrito,
                            idProducto,
                            nuevaCantidad);

            return Response.ok(carritoActualizado).build();

        } catch (CarritoException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error interno del servidor")
                    .build();
        }
    }

    /**
     * PUT method for updating or creating an instance of CarritoResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(CarritoDTO content) {
    }
}
