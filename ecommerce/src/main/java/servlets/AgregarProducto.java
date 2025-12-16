/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import bos.CategoriaBO;
import bos.ProductoBO;
import dtos.CategoriaDTO;
import dtos.ProductoDTO;
import exception.ObtenerCategoriasException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramonsebastianzamudioayala
 */
@MultipartConfig    
@WebServlet(name = "AgregarProducto", urlPatterns = {"/AgregarProducto"})
public class AgregarProducto extends HttpServlet {
    private CategoriaBO categoriaBO = new CategoriaBO();
    private ProductoBO productoBO = new ProductoBO();
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
            out.println("<title>Servlet AgregarProducto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarProducto at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CategoriaDTO> categorias;
        try {
            categorias = categoriaBO.obtenerCategorias();
            request.setAttribute("categorias", categorias);
            request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
        } catch (ObtenerCategoriasException ex) {
            Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        try {
            String nombre = request.getParameter("nombre");
            String desc = request.getParameter("desc");
            Double precio = Double.valueOf(request.getParameter("precio"));
            Integer stock = Integer.valueOf(request.getParameter("stock"));
            Long categoriaId = Long.valueOf(request.getParameter("categoria"));
            
            Part filePart = request.getPart("imagen");
            String rutaImagenBD = ""; 

            if (filePart != null && filePart.getSize() > 0) {
                String uploadPath = request.getServletContext().getRealPath("") + File.separator + "imagenes_productos";
                
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
                String fullPath = uploadPath + File.separator + uniqueFileName;
                filePart.write(fullPath);
                rutaImagenBD = "imagenes_productos/" + uniqueFileName;
            } else {
                rutaImagenBD = "imgs/default-product.png";
            }
            CategoriaDTO categoria = categoriaBO.obtenerPorId(categoriaId);
            ProductoDTO producto = new ProductoDTO(
                nombre, precio, stock, desc, 
                true, desc, 
                rutaImagenBD,
                categoria
            );
            productoBO.agregarProducto(producto);

            response.sendRedirect("AgregarProducto");
        } catch (Exception ex) {
            Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "No se pudo guardar el producto");
            List<CategoriaDTO> categorias;
            try {
                categorias = categoriaBO.obtenerCategorias();
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
            } catch (ObtenerCategoriasException ex1) {
                Logger.getLogger(AgregarProducto.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
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
