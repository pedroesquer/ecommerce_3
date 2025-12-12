package bos;

import dtos.CarritoDTO;
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
            return CarritoMapper.entityToDTO(carritosDAO.obtenerCarritoUsuario(id));
        } catch (PersistenciaException e) {
            throw new CarritoException("Error al obtener el carrito: " + e.getMessage(), e);
        }
    }

    @Override
    public CarritoDTO agregarProducto(Producto producto, Long idCarrito, Integer cantidad) throws CarritoException {
        try {
            Carrito carritoActualizado = carritosDAO.agregarProducto(producto, idCarrito, cantidad);
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

}
