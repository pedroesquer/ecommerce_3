package bos;

import dtos.CarritoDTO;
import dtos.ProductoDTO;
import entidades.Carrito;
import entidades.Producto;
import exception.CarritoException;
import exception.PersistenciaException;
import implementaciones.CarritosDAO;
import interfaces.ICarritosBO;
import interfaces.ICarritosDAO;
import java.util.List;
import java.util.logging.Logger;
import mappers.CarritoMapper;
import mappers.ProductoMapper;

/**
 *
 * @author pedro
 */
public class CarritosBO implements ICarritosBO {

    private ICarritosDAO carritosDAO;

    public CarritosBO() {
        this.carritosDAO = new CarritosDAO();
    }

    @Override
    public List<CarritoDTO> obtenerCarritos() throws CarritoException {
        try {
            return CarritoMapper.listEntityToDTO(carritosDAO.obtenerCarritos());
        } catch (PersistenciaException e) {
            throw new CarritoException("Error al obtener los carritos: " + e.getMessage(), e);
        }
    }

    @Override
    public CarritoDTO obtenerCarritoUsuario(Long id) throws CarritoException {
        try {
            Carrito carrito = carritosDAO.obtenerCarritoUsuario(id);

            if (carrito != null) {
                return CarritoMapper.entityToDTO(carrito);
            }

            return null;

        } catch (PersistenciaException e) {
            throw new CarritoException("Error al obtener el carrito: " + e.getMessage(), e);
        }
    }

    @Override
    public CarritoDTO agregarProducto(ProductoDTO producto, Long idCarrito, Integer cantidad) throws CarritoException {
        try {
            Producto productoConv = ProductoMapper.DTOToEntity(producto);
            Carrito carritoActualizado = carritosDAO.agregarProducto(productoConv, idCarrito, cantidad);
            return CarritoMapper.entityToDTO(carritoActualizado);
        } catch (PersistenciaException e) {
            throw new CarritoException("Error al agregar el producto al carrito: " + e.getMessage(), e);
        }
    }

    @Override
    public CarritoDTO eliminarProducto(Long idProducto, Long idCarrito) throws CarritoException {
        try {
            Carrito carritoActualizado = carritosDAO.eliminarProducto(idProducto, idCarrito);
            return CarritoMapper.entityToDTO(carritoActualizado);
        } catch (PersistenciaException e) {
            throw new CarritoException("Error al eliminar el producto del carrito: " + e.getMessage(), e);
        }
    }

    @Override
    public CarritoDTO modificarCantidadProducto(Long carritoId, Long productoId, Integer nuevaCantidad) throws CarritoException {
        try {
            Carrito carritoActualizado = carritosDAO.modificarCantidadProducto(carritoId, productoId, nuevaCantidad);
            return CarritoMapper.entityToDTO(carritoActualizado);
        } catch (PersistenciaException e) {
            throw new CarritoException("Error al modificar la cantidad del producto en el carrito: " + e.getMessage(), e);
        }
    }

}
