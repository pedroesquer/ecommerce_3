/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.ProductoDTO;
import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author gael_
 */
public interface IProductosDAO {
    public void eliminarProducto(Long id) throws PersistenciaException;
    public void agregarProducto(ProductoDTO nuevoProducto) throws PersistenciaException; 
    public void editarProducto(Long id, ProductoDTO nuevoProducto) throws PersistenciaException; 
    public List<Producto> obtenerProductos() throws PersistenciaException;
}
