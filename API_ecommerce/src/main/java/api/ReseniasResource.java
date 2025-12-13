/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import bos.ProductoBO;
import bos.ReseniasBO;
import dtos.ReseñaDTO;
import exception.ObtenerReseniasException;
import interfaces.IProductosBO;
import interfaces.IReseniasBO;
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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author juanpheras
 */
@Path("resenias")
@RequestScoped
public class ReseniasResource {

    @Context
    private UriInfo context;
    
    private IReseniasBO reseniasBO = new ReseniasBO();
    private IProductosBO productosBO = new ProductoBO();

    /**
     * Creates a new instance of ReseniasResource
     */
    public ReseniasResource() {
    }

    /**
     * Retrieves representation of an instance of api.ReseniasResource
     * @return an instance of dtos.ReseñaDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReseñaDTO> getJson() {
        try {
            //TODO return proper representation object
            return reseniasBO.obtenerResenias();
        } catch (ObtenerReseniasException ex) {
            Logger.getLogger(ReseniasResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    /**
     * PUT method for updating or creating an instance of ReseniasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ReseñaDTO content) {
    }
    
    
    @POST
    @Path("/agregarResenia")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarProducto(ReseñaDTO dto) {
        try {
                ReseñaDTO creado = reseniasBO.agregarResenia(dto);
            return Response.status(Response.Status.CREATED).entity(creado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
}
