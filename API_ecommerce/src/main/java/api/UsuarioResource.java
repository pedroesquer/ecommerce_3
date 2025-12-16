package api;

import bos.UsuariosBO;
import dtos.UsuarioDTO;
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
    public Response editarPerfil(UsuarioDTO usuarioEntrante, @Context ContainerRequestContext ctx) {
        try {
            Object idProp = ctx.getProperty("usuarioId");

            if (idProp == null) {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Token inválido").build();
            }
            Long usuarioId = Long.valueOf(idProp.toString());

            UsuarioDTO usuarioBD = usuariosBO.buscarPorId(usuarioId);

            if (usuarioBD == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            usuarioEntrante.setId(usuarioId);

            usuarioEntrante.setRol(usuarioBD.getRol());
            usuarioEntrante.setContrasenia(usuarioBD.getContrasenia()); 
            usuarioEntrante.setCorreo(usuarioBD.getCorreo()); 

            UsuarioDTO actualizado = usuariosBO.editarUsuario(usuarioEntrante);

            return Response.ok(actualizado).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"" + ex.getMessage() + "\"}")
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        jakarta.ws.rs.core.NewCookie cookie = new jakarta.ws.rs.core.NewCookie.Builder("jwt")
                .value("")
                .path("/")
                .maxAge(0)
                .httpOnly(true)
                .build();

        return Response.ok("{\"mensaje\": \"Sesión cerrada\"}")
                .cookie(cookie)
                .build();
    }
}
