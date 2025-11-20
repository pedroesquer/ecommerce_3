package servlets;

import bos.CategoriaBO;
import bos.ProductoBO;
import dtos.CategoriaDTO;
import dtos.ProductoDTO; // Asegúrate de importar esto
import exception.ObtenerCategoriasException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig; // Importante para subir archivos
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part; // Importante
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EditarProducto", urlPatterns = {"/EditarProducto"})
@MultipartConfig
public class EditarProducto extends HttpServlet {

    private CategoriaBO categoriaBO = new CategoriaBO();
    private ProductoBO productoBO = new ProductoBO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        
        if(idStr == null || idStr.isEmpty()){
            response.sendRedirect("administrarProductos.html");
            return;
        }

        try {
            Long idProducto = Long.valueOf(idStr);

            ProductoDTO producto = productoBO.obtenerProductoPorId(idProducto); 
            List<CategoriaDTO> categorias = categoriaBO.obtenerCategorias();

            request.setAttribute("producto", producto);
            request.setAttribute("categorias", categorias);

            request.getRequestDispatcher("editarProducto.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(EditarProducto.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("error.jsp"); // Manejo básico de error
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Long id = Long.valueOf(request.getParameter("id")); 
            String nombre = request.getParameter("nombre");
            String desc = request.getParameter("desc");
            Double precio = Double.valueOf(request.getParameter("precio"));
            Integer stock = Integer.valueOf(request.getParameter("stock"));
            Long categoriaId = Long.valueOf(request.getParameter("categoria"));
            String rutaImagenActual = request.getParameter("rutaImagenActual"); 

            Part filePart = request.getPart("imagen");
            String rutaImagenBD = rutaImagenActual; 

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
            }

            CategoriaDTO categoria = categoriaBO.obtenerPorId(categoriaId);
            
            ProductoDTO producto = new ProductoDTO();
            producto.setId(id); 
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setDescripcion(desc);
            producto.setRutaImagen(rutaImagenBD);
            producto.setCategoria(categoria);
            producto.setDisponibilidad(true); 

            productoBO.editarProducto(producto.getId(), producto); 

            response.sendRedirect("administrarProductos.jsp");

        } catch (Exception ex) {
            Logger.getLogger(EditarProducto.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "No se pudo actualizar el producto");
            doGet(request, response); 
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para editar productos";
    }
}