package filtrosAPI;

import io.jsonwebtoken.Claims;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import util.JwtUtil;

/**
 * Clase de filtro que valida el token y settea los atributos de la api.
 *
 * @author Juan Heras
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        System.out.println(">>> JwtFilter ejecutándose <<<");

        String auth = requestContext.getHeaderString("Authorization");
        System.out.println("Authorization header: " + auth);

        if (auth == null || !auth.startsWith("Bearer ")) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).build()
            );
            return;
        }

        String token = auth.substring("Bearer ".length());

        try {
            Claims claims = JwtUtil.validarToken(token);

            requestContext.setProperty("usuarioId", claims.getSubject());
            requestContext.setProperty("rol", claims.get("rol"));

        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).build()
            );
        }
    }
}
