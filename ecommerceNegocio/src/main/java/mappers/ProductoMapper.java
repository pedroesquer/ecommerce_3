package mappers;

import dtos.ProductoDTO;
import dtos.ReseñaDTO;
import entidades.Producto;
import entidades.Reseña;
import java.util.List;

/**
 *
 * @author pedro
 */
public class ProductoMapper {
    public static ProductoDTO entityToDTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO(producto.getId(), 
                                                  producto.getNombre(), 
                                                  producto.getPrecio(), 
                                                  producto.getStock(), 
                                                  producto.getDescripcion(), 
                                                  producto.getDisponibilidad(), 
                                                  producto.getEspecificacionesTecnicas(), 
                                                  producto.getRutaImagen(), 
                                                  ReseñaMapper.entityListToDTOList(producto.getResenias()));
        
        return productoDTO;
    }

}
