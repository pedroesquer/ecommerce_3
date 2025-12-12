package api;

import bos.CarritosBO;
import dtos.CarritoDTO;
import exception.CarritoException;
import interfaces.ICarritosBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
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
            return carritosBO.obtenerCarritoUsuario(Long.MIN_VALUE);
        } catch (CarritoException e) {
            Logger.getLogger(PedidosResource.class.getName()).log(Level.SEVERE, null, e);
            return null;
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
