/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
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

    //NO SE QUE PEDO CON ESTO A L V
//    @GET
//    @Path("perfil")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response obtenerPerfil() {
//        try {
//            // 1. Recuperamos el ID que el JwtFilter guardó en la request tras verificar el token
//            // El filtro usó: requestContext.setProperty("idUsuario", idUsuario);
//            // En JAX-RS, las properties del contexto pasan a attributes del request
//            Long idUsuario = (Long) request.getAttribute("idUsuario");
//
//            if (idUsuario == null) {
//                 return Response.status(Response.Status.UNAUTHORIZED)
//                        .entity("{\"error\": \"Token inválido o no procesado\"}").build();
//            }
//
//            // 2. Usamos el BO para buscar los datos frescos de la BD usando ese ID
//            UsuarioDTO usuarioLogueado = usuariosBO.buscarPorId(idUsuario); 
//
//            // 3. Retornar los datos (sin contraseña por seguridad)
//            if (usuarioLogueado != null) {
//                usuarioLogueado.setContrasenia(null); 
//                return Response.ok(usuarioLogueado).build();
//            } else {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//
//        } catch (Exception ex) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("Error al obtener perfil: " + ex.getMessage()).build();
//        }
//    }
//    
//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response login(UsuarioDTO credenciales) {
//        try {
//            // 1. Validar usuario y contraseña con tu BO (Lógica de negocio)
//            // OJO: Aquí asumo que tienes un método que verifica credenciales y retorna el UsuarioDTO completo
//            UsuarioDTO usuarioValido = usuariosBO.iniciarSesion(credenciales.getCorreo(), credenciales.getContrasenia());
//
//            if (usuarioValido != null) {
//                // 2. Si es válido, GENERAR TOKEN
//                String token = JwtUtil.generarToken(usuarioValido);
//
//                // 3. Devolver el token al cliente (frontend)
//                return Response.ok("{\"token\":\"" + token + "\"}").build();
//            } else {
//                return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales incorrectas").build();
//            }
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }
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
    public Response editarPerfil(UsuarioDTO usuarioEditado) {
        try {
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("usuarioActual") == null) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

            // Obtener el usuario original de la sesión
            UsuarioDTO usuarioSesion = (UsuarioDTO) session.getAttribute("usuarioActual");

            // SEGURIDAD: Usar el ID de la sesión, no el que venga en el JSON
            usuarioEditado.setId(usuarioSesion.getId());
            // Aseguramos que no cambie su rol ni otros datos sensibles si no debe
            usuarioEditado.setRol(usuarioSesion.getRol());

            // Llamar al negocio
            UsuarioDTO actualizado = usuariosBO.editarUsuario(usuarioEditado);

            // IMPORTANTE: Actualizar la sesión con los nuevos datos
            session.setAttribute("usuarioActual", actualizado);

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
}
