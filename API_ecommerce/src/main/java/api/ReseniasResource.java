/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import bos.ProductoBO;
import bos.ReseniasBO;
import dtos.ProductoDTO;
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
import jakarta.ws.rs.container.ContainerRequestContext;
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
    //NO SE USA NUNCA XDD
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
    
    //NO SE SI SIRVA ESTE METODO O EL QUE ESTE EN PRODUCTOS RESOURCES
//    @GET
//    @Path("/producto/{idProducto}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response obtenerReseniasPorProducto(@PathParam("idProducto") Long idProducto) {
//        try {
//            // Usamos productosBO porque ahí está implementada la lógica de buscar reseñas por ID de producto
//            List<ReseñaDTO> resenias = productosBO.obtenerReseñas(idProducto);
//            
//            if (resenias != null) {
//                // OPCIONAL: Aquí podrías limpiar datos sensibles del usuario antes de enviar
//                for(ReseñaDTO r : resenias) {
//                    if(r.getUsuario() != null) {
//                        r.getUsuario().setContrasenia(null); // Seguridad básica
//                        r.getUsuario().setCorreo(null);    // Ocultar email si no es necesario
//                    }
//                }
//                return Response.ok(resenias).build();
//            } else {
//                return Response.status(Response.Status.NOT_FOUND)
//                        .entity("No se encontraron reseñas para este producto.")
//                        .build();
//            }
//        } catch (Exception ex) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("Error al obtener reseñas.")
//                    .build();
//        }
//    }


    /**
     * PUT method for updating or creating an instance of ReseniasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ReseñaDTO content) {
    }
    
    //PROBABLEMENTE ESTE METODO DEBERIA DE IR EN PRODUCTOS RESOURCES
    //METODO A MODIFICAR
//    @POST
//    @Path("/agregarResenia")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response agregarResena(@Context ContainerRequestContext ctx, ReseñaDTO dto) {
//        try {
//                Long usuarioId = Long.valueOf(ctx.getProperty("usuarioId").toString());
//                ReseñaDTO creado = reseniasBO.agregarResenia(dto);
//            return Response.status(Response.Status.CREATED).entity(creado).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("Error: " + e.getMessage())
//                    .build();
//        }
//    }
}
