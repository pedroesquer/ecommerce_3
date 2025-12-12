/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtros;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import util.JwtUtil;

/**
 *
 * @author gael_
 */
@Provider // Esto le dice a Jersey que registre esta clase automáticamente
@Priority(Priorities.AUTHENTICATION)
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path = requestContext.getUriInfo().getPath();

        // 1. Permitir acceso libre a login y registro (públicos)
        if (path.contains("login") || path.contains("registrarUsuario")) {
            return;
        }

        // 2. Obtener la cabecera "Authorization"
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // 3. Validar formato "Bearer <token>"
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Token requerido").build());
            return;
        }

        // 4. Extraer y verificar el token
        String token = authHeader.substring(7); // Quitar "Bearer "
        try {
            DecodedJWT jwt = JwtUtil.verificarToken(token);
            
            // 5. IMPORTANTE: Meter el ID del usuario en la petición para usarlo en el Resource
            Long idUsuario = jwt.getClaim("idUsuario").asLong();
            String rol = jwt.getClaim("rol").asString();
            
            // Guardamos estos datos temporalmente en el contexto de la request
            requestContext.setProperty("idUsuario", idUsuario);
            requestContext.setProperty("rolUsuario", rol);

        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Token inválido o expirado").build());
        }
    }
    
    
}
