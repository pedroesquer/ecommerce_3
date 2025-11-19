/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.ProductoDTO;
import exception.AgregarProductoException;
import exception.EditarProductoException;
import exception.EliminarProductoException;
import exception.PersistenciaException;
import interfaces.IProductosBO;
import implementaciones.ProductoDAO;
import interfaces.IProductosDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class ProductoBO implements IProductosBO{
    IProductosDAO productosDAO;
    public ProductoBO() {
        productosDAO = new ProductoDAO();
    }
    
    @Override
    public void eliminarProducto(Long id) throws EliminarProductoException {
        try {
            productosDAO.eliminarProducto(id);
        } catch (PersistenciaException ex) {
            throw new EliminarProductoException("hubo un error al eliminar el producto");
        }
    }

    @Override
    public void agregarProducto(ProductoDTO nuevoProducto) throws AgregarProductoException {
        try {
            productosDAO.agregarProducto(nuevoProducto);
        } catch (PersistenciaException ex) {
            throw new AgregarProductoException("hubo un error al agregar un producto");
        }
    }
    @Override
    public void editarProducto(Long id, ProductoDTO nuevoProducto) throws EditarProductoException {
        try {
            productosDAO.editarProducto(id, nuevoProducto);
        } catch (PersistenciaException ex) {
            throw new EditarProductoException("hubo un problema al editar el perfil");
        }
    }
    
}
