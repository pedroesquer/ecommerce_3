/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.ProductoDTO;
import exception.AgregarProductoException;
import exception.EditarProductoException;
import exception.EliminarProductoException;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface IProductosBO {
    public void eliminarProducto(Long id) throws EliminarProductoException;
    public void agregarProducto(ProductoDTO nuevoProducto) throws AgregarProductoException; 
    public void editarProducto(Long id, ProductoDTO nuevoProducto) throws EditarProductoException; 
}
