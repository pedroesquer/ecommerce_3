/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author juanpheras
 */
public class FiltroAutorización implements Filter {

    String[] paginasPublicas = { 
        "index.jsp",
        "inicioSesion.jsp",
        "registro.jsp",
        "prodcuto.jsp",
        "productos.jsp"
    };
    
    String[] paginasAdmin = {
        "menuadministrador.jsp",
        "administrarPedidoIndividual",
        "administrarPedidos",
        "administrarProductos",
        "administrarResenias",
        "administrarUsuarios",
        "agregarProducto",
        "editarProducto",
        "editarUsuario",
    };
    
    
    private String getPathSolicitado(HttpServletRequest request){
        String uriSolicitada = request.getRequestURI();
        String path = uriSolicitada.substring(request.getContextPath().length());
        return path;
    }
    
    /**
     * Método para verificar si la página que se quiere acceder es o no pública
     * @param path ruta a la cual se desea acceder
     * @return true si es página admin, false si no.
     */
    private boolean isURLPrivate(String path){
        for (String url : paginasPublicas) {
            if (path.startsWith("/" + url)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Método para verificar si la página que se quiere acceder es o no del administrador
     * @param path ruta a la cual se desea acceder
     * @return true si es página admin, false si no.
     */
    private boolean isURLAdmin(String path){
        for (String url : paginasAdmin) {
            if (path.startsWith("/" + url)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isLoggedIn(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        boolean logged = (session != null && session.getAttribute("usuario") != null);
        return logged;
    }
    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest peticion = (HttpServletRequest) sr;
        String path = this.getPathSolicitado(peticion);
        
        boolean isPrivate = this.isURLPrivate(path);
        boolean isAdminURL = this.isURLAdmin(path);
        boolean logged = this.isLoggedIn(peticion);
        
        
        HttpSession session = peticion.getSession(false);
        String rol  = (session != null) ? (String) session.getAttribute("rolUsuario"): null;
        
        
        if(isPrivate && !logged) {
            sr.getRequestDispatcher("/index.jsp").forward(sr, sr1);
            return;
        } else if (isAdminURL  && !"ADMINISTRADOR".equals(rol)){
            sr.getRequestDispatcher("/index.jsp").forward(sr, sr1);
            //AQUI PODIAMOS REDIRIGIR A UNA PAGINA 
            return;
        }
        
        fc.doFilter(sr, sr1);
    }
    
}
