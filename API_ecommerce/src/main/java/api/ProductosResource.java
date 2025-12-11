/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import bos.ProductoBO;
import dtos.ProductoDTO;
import exception.ObtenerProductosException;
import interfaces.IProductosBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author juanpheras
 */
@Path("productos")
@RequestScoped
public class ProductosResource {

    @Context
    private UriInfo context;
    
    private IProductosBO productosBO = new ProductoBO();

    /**
     * Creates a new instance of ProductosResource
     */
    public ProductosResource() {
    }

    /**
     * Retrieves representation of an instance of api.ProductosResource
     * @return an instance of dtos.ProductoDTO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> getJson() {
        try {
            return productosBO.obtenerProductos();
        } catch (ObtenerProductosException ex) {
            return null;
        }
    }

    /**
     * PUT method for updating or creating an instance of ProductosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProductoDTO content) {
    }
}
