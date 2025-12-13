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

//    @GET
//    @Path("/{idusuario}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public CarritoDTO getCarritoPorUsuario(@PathParam("idusuario") long id) {
//        try {
//            return carritosBO.obtenerCarritoUsuario(id);
//        } catch (CarritoException e) {
//            Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, e);
//            return null;
//        }
//    }
    
    @GET
    @Path("/{idusuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarritoPorUsuario(@PathParam("idusuario") long id) {
        try {
            CarritoDTO carrito = carritosBO.obtenerCarritoUsuario(id);

            if (carrito == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Carrito no encontrado")
                        .build();
            }

            // Limpiar datos sensibles antes de enviar
            limpiarDatosSensibles(carrito);

            return Response.ok(carrito).build();

        } catch (CarritoException e) {
            Logger.getLogger(CarritoResource.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener el carrito")
                    .build();
        }
    }

    /**
     * Limpia información sensible del carrito antes de enviarlo al frontend
     */
    private void limpiarDatosSensibles(CarritoDTO carrito) {
        // Limpiar datos del usuario del carrito
        if (carrito.getUsuario() != null) {
            carrito.getUsuario().setContrasenia(null);
            carrito.getUsuario().setCorreo(null);
            carrito.getUsuario().setDireccion(null);
            carrito.getUsuario().setTelefono(null);
            carrito.getUsuario().setReseña(null);
        }

        // Limpiar datos de cada producto en el carrito
        if (carrito.getDetallesCarrito() != null) {
            for (DetallesCarritoDTO detalle : carrito.getDetallesCarrito()) {
                if (detalle.getProducto() != null) {
                    ProductoDTO producto = detalle.getProducto();

                    // Remover reseñas completas (no son necesarias en el carrito)
                    producto.setReseñas(null);

                    // Si decides mantener las reseñas, limpia los datos de usuario
                    /*
                    if (producto.getReseñas() != null) {
                        for (ReseñaDTO reseña : producto.getReseñas()) {
                            if (reseña.getUsuario() != null) {
                                reseña.getUsuario().setContrasenia(null);
                                reseña.getUsuario().setCorreo(null);
                                reseña.getUsuario().setDireccion(null);
                                reseña.getUsuario().setTelefono(null);
                                reseña.getUsuario().setReseña(null);
                            }
                        }
                    }
                    */
                }
            }
        }
    }

    @POST
    @Path("/agregarProductoCarrito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarProducto(@QueryParam("idProducto") Long idProducto, @QueryParam("idCarrito") Long idCarrito,
            @QueryParam("cantidad") Integer cantidad) {
        // Validación de los parámetros
        if (idProducto == null || idCarrito == null || cantidad == null || cantidad <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: 'idProducto', 'idCarrito' y 'cantidad' son obligatorios y la cantidad debe ser mayor que 0.")
                    .build();
        }

        try {
            // Recuperar el producto desde la base de datos usando el ID del producto
            ProductoDTO producto = productosBO.obtenerProductoPorId(idProducto);
            if (producto == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Error: Producto con ID " + idProducto + " no encontrado.")
                        .build();
            }

            // Llamada al negocio para agregar el producto al carrito
            CarritoDTO creado = carritosBO.agregarProducto(producto, idCarrito, cantidad);
            return Response.status(Response.Status.CREATED).entity(creado).build();

        } catch (Exception e) {
            // Manejo de errores más detallado
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
