/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import bos.ProductoBO;
import dtos.ProductoDTO;
import dtos.ReseñaDTO;
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
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

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
     *
     * @return an instance of dtos.ProductoDTO
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProductoDTO> getJson() {
//        try {
//            return productosBO.obtenerProductos();
//        } catch (ObtenerProductosException ex) {
//            return null;
//        }
//    }

    /**
     * Obtiene la lista de productos, opcionalmente filtrada por nombre, categoría o precio.
     * Ejemplo de uso: GET /api/productos?nombre=Aceite&categoriaId=2
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDTO> getProductos(
            @QueryParam("nombre") String nombre,
            @QueryParam("categoriaId") Long categoriaId,
            @QueryParam("precioMin") Double precioMin,
            @QueryParam("precioMax") Double precioMax) {
        
        try {
            // Verificamos si se envió algún parámetro de búsqueda
            boolean hayFiltros = (nombre != null && !nombre.isEmpty()) 
                              || categoriaId != null 
                              || precioMin != null 
                              || precioMax != null;

            if (hayFiltros) {

                return productosBO.buscarProductos(nombre, categoriaId, precioMin, precioMax);
            } else {

                return productosBO.obtenerProductos();
            }
        } catch (Exception ex) {
            ex.printStackTrace(); 
            return null; 
        }
    }
    
    
    @GET
    @Path("/{idproducto}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReseñaDTO> obtenerReseñas(@PathParam("idProducto")Long id){
        try{
            List<ReseñaDTO> reseñas = productosBO.obtenerReseñas(id);
            if(reseñas != null){
                return reseñas;
            }else{
                throw new WebApplicationException("Producto no encontrado", Response.Status.NOT_FOUND);
            }
        }catch(Exception ex){
            throw new WebApplicationException("Error al obtener el producto", Response.Status.INTERNAL_SERVER_ERROR);
        }
    } 
    
    
    
    @GET
    @Path("/{id}")  // La ruta que incluye el ID del producto
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoDTO getProductoById(@PathParam("id") long id) {
        try {
            // Obtener el producto por ID desde el negocio (productosBO)
            ProductoDTO producto = productosBO.obtenerProductoPorId(id);
            if (producto != null) {
                return producto;
            } else {
                // Si no se encuentra el producto, puedes retornar un error 404 o similar
                throw new WebApplicationException("Producto no encontrado", Response.Status.NOT_FOUND);
            }
        } catch (Exception ex) {
            // Manejar excepciones generales
            throw new WebApplicationException("Error al obtener el producto", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @POST
    @Path("/agregarProducto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarProducto(ProductoDTO dto) {
        try {
                ProductoDTO creado = productosBO.agregarProducto(dto);
            return Response.status(Response.Status.CREATED).entity(creado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
    
    // DELETE para eliminar un producto por ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProducto(@PathParam("id") Long id) {
        try {
            boolean eliminado = productosBO.eliminarProducto(id);
            if (eliminado) {
                return Response.status(Response.Status.NO_CONTENT).build();  // No Content 204
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Producto no encontrado")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }
    
    

    /**
     * PUT method for updating or creating an instance of ProductosResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProductoDTO content) {
    }
}
