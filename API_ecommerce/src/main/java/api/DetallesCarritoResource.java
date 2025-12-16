/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dtos.DetallesCarritoDTO;
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
@Path("DetallesCarrito")
@RequestScoped
public class DetallesCarritoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DetallesCarritoResource
     */
    public DetallesCarritoResource() {
    }

    /**
     * Retrieves representation of an instance of api.DetallesCarritoResource
     * @return an instance of dtos.DetallesCarritoDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DetallesCarritoDTO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of DetallesCarritoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(DetallesCarritoDTO content) {
    }
}
