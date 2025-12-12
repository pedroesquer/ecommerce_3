package interfaces;

import dtos.CarritoDTO;
import entidades.Producto;
import exception.CarritoException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface ICarritosBO {
    public List<CarritoDTO> obtenerCarritos() throws CarritoException;
    public CarritoDTO obtenerCarritoUsuario(Long id) throws CarritoException;
    public CarritoDTO agregarProducto(Producto producto, Long idCarrito, Integer cantidad) throws CarritoException;
    public CarritoDTO eliminarProducto(Long idProducto, Long idCarrito) throws CarritoException;
    
}
