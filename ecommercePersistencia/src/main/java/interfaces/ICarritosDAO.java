/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Carrito;
import entidades.Producto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface ICarritosDAO {
    public List<Carrito> obtenerCarritos() throws PersistenciaException;
    
    public Carrito obtenerCarritoUsuario(Long idUsuario) throws PersistenciaException;
    
    public Carrito agregarProducto(Long carritoId, Producto producto, Integer cantidad);
}