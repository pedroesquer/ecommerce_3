package api;

import bos.CarritosBO;
import bos.ProductoBO;
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
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
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
    @Path("/{idusuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public CarritoDTO getCarritoPorUsuario(@PathParam("idusuario") long id) {
        try {
            return carritosBO.obtenerCarritoUsuario(id);
        } catch (CarritoException e) {
            Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @POST
    @Path("/agregarProductoCarrito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarProducto(DetallesCarritoDTO detallesCarrito) {
        Long idCarrito = detallesCarrito.getCarrito(); 
        Integer cantidad = detallesCarrito.getCantidadProductos();
        
        Long idProducto = null;
        if (detallesCarrito.getProducto() != null) {
            idProducto = detallesCarrito.getProducto().getId(); 
        }

        if (idProducto == null || idCarrito == null || cantidad == null || cantidad <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Faltan datos o la cantidad es incorrecta.")
                    .build();
        }

        try {
            ProductoDTO producto = productosBO.obtenerProductoPorId(idProducto);
            if (producto == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Error: Producto no encontrado.")
                        .build();
            }

            CarritoDTO creado = carritosBO.agregarProducto(producto, idCarrito, cantidad);
            return Response.status(Response.Status.CREATED).entity(creado).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage())
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
