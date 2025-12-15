package api;

import bos.UsuariosBO;
import dtos.UsuarioDTO;
import exception.EditarUsuarioException;
import interfaces.IUsuariosBO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author gael_
 */
@Path("usuarios")
@RequestScoped
public class UsuarioResource {

    @Context
    private HttpServletRequest request;

    private IUsuariosBO usuariosBO = new UsuariosBO();

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }


    /**
     * Obtiene el perfil del usuario logueado. GET /api/usuarios/perfil
     */
    @GET
    @Path("perfil")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPerfil(@Context ContainerRequestContext ctx) {
        try {
            Long usuarioId = Long.valueOf(
                    ctx.getProperty("usuarioId").toString()
            );

            UsuarioDTO usuario = usuariosBO.buscarPorId(usuarioId);

            return Response.ok(usuario).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener perfil")
                    .build();
        }
    }

    /**
     * Actualiza el perfil del usuario logueado. PUT /api/usuarios/perfil
     */
     @PUT
    @Path("perfil")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarPerfil(UsuarioDTO usuarioEditado, @Context ContainerRequestContext ctx) {
        try {
            Long usuarioId = Long.valueOf(ctx.getProperty("usuarioId").toString());

            UsuarioDTO usuarioSesion = usuariosBO.buscarPorId(usuarioId);

            usuarioEditado.setId(usuarioSesion.getId());

            usuarioEditado.setRol(usuarioSesion.getRol());
            usuarioEditado.setEsActivo(usuarioSesion.getEsActivo());

            if (usuarioEditado.getContrasenia() == null || usuarioEditado.getContrasenia().isEmpty()) {
                usuarioEditado.setContrasenia(usuarioSesion.getContrasenia());
            }

            UsuarioDTO actualizado = usuariosBO.editarUsuario(usuarioEditado);


            return Response.ok(actualizado).build();

        } catch (EditarUsuarioException ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"" + ex.getMessage() + "\"}")
                    .build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Error al actualizar perfil\"}")
                    .build();
        }
    }

    @POST
    @Path("/registrarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(UsuarioDTO dto) {
        try {
            UsuarioDTO creado = usuariosBO.registrarUsuario(dto);
            return Response.status(Response.Status.CREATED).entity(creado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cerrarSesion() {
        // 1. Invalidar la sesión (Para el ADMIN)
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // 2. Matar la cookie JWT (Para el CLIENTE y limpieza general)
        // Es CRUCIAL que el path coincida con el de creación ("/" usualmente)
        jakarta.ws.rs.core.NewCookie cookie = new jakarta.ws.rs.core.NewCookie.Builder("jwt")
                .value("") // Valor vacío
                .path("/") // El mismo path que usaste al crearla
                .maxAge(0) // 0 = Borrar inmediatamente
                .httpOnly(true)
                .build();

        return Response.ok("{\"mensaje\": \"Sesión cerrada\"}")
                .cookie(cookie) // Adjuntamos la orden de borrado
                .build();
    }
}
