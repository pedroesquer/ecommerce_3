/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import bos.UsuariosBO;
import dtos.UsuarioDTO;
import interfaces.IUsuariosBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.JwtUtil;

/**
 *
 * @author pedro
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    IUsuariosBO usuariosBO = new UsuariosBO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/inicioSesion.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String contrasenia = request.getParameter("contrasenia");

        try {
            UsuarioDTO usuario = usuariosBO.iniciarSesion(correo, contrasenia);

            if (usuario == null) {
                request.setAttribute("mensaje", "Credenciales incorrectas");
                request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
                return;
            }

            String token = JwtUtil.generarToken(usuario);

            Cookie jwtCookie = new Cookie("jwt", token);
            jwtCookie.setHttpOnly(true);
            jwtCookie.setPath("/");       
            jwtCookie.setMaxAge(60 * 60); // 1 hora
            response.addCookie(jwtCookie);


            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioActual", usuario);
            session.setAttribute("rol", usuario.getRol().name());

            if (usuario.getRol().name().equals("ADMINISTRADOR")) {
                response.sendRedirect(request.getContextPath() + "/menuadministrador.jsp");
            } 
            else if (usuario.getRol().name().equals("CLIENTE")) {
                response.sendRedirect("index.jsp");
            }

        } catch (Exception e) {
            request.setAttribute("mensaje", "Error: " + e.getMessage());
            request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
