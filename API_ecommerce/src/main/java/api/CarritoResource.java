package api;

import dtos.CarritoDTO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author pedro
 */
@Path("Carrito")
@RequestScoped
public class CarritoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarritoResource
     */
    public CarritoResource() {
    }

    /**
     * Retrieves representation of an instance of api.CarritoResource
     * @return an instance of dtos.CarritoDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CarritoDTO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CarritoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(CarritoDTO content) {
    }
}
