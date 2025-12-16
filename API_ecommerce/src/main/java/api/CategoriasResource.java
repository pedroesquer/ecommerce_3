/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import bos.CategoriaBO;
import dtos.CategoriaDTO;
import exception.ObtenerCategoriasException;
import interfaces.ICategoriaBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * REST Web Service
 *
 * @author gael_
 */
@Path("categorias")
@RequestScoped
public class CategoriasResource {

    @Context
    private UriInfo context;
    
    private ICategoriaBO categoriasBO = new CategoriaBO();

    /**
     * Creates a new instance of CategoriasResource
     */
    public CategoriasResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaDTO> getJson() {
        try {
            return categoriasBO.obtenerCategorias();
        } catch (ObtenerCategoriasException ex) {
            return null;
        }
    }

    
}
