/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.ProductoDTO;
import entidades.Producto;
import entidades.Reseña;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author gael_
 */
public interface IProductosDAO {

    public boolean eliminarProducto(Long id) throws PersistenciaException;

    public Producto agregarProducto(Producto nuevoProducto) throws PersistenciaException;

    public void editarProducto(Long id, ProductoDTO nuevoProducto) throws PersistenciaException;

    public List<Producto> obtenerProductos() throws PersistenciaException;

    public Producto obtenerProductoPorId(Long id) throws PersistenciaException;
    
    public List<Producto> buscarProductosDinamico(String nombre, Long categoriaId, Double precioMin, Double precioMax) throws PersistenciaException;
    
    public List<Reseña> obtenerReseñas(Long id) throws PersistenciaException;
    
    public boolean verificarCompraUsuario(Long idUsuario, Long idProducto) throws PersistenciaException;
}
