package com.mycompany.api_ecommerce;

import api.CarritoResource;
import api.CategoriasResource;
import api.PedidosResource;
import api.ProductosResource;
import api.ReseniasResource;
import api.UsuarioResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        
        classes.add(ProductosResource.class);
        classes.add(PedidosResource.class);
        classes.add(UsuarioResource.class);
        classes.add(ReseniasResource.class);
        classes.add(CarritoResource.class);
        classes.add(CategoriasResource.class);
        return classes;
    }
    
}
