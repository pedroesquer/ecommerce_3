package dtos;


/**
 *
 * @author ramonsebastianzamudioayala
 */
public class DetallesCarritoDTO {
    private Long id;
    private Integer cantidadProductos;
    private ProductoDTO producto;
    private Long idcarrito;

    public DetallesCarritoDTO() {
    }

    public DetallesCarritoDTO(Long id, Integer cantidadProductos, ProductoDTO producto, Long carrito) {
        this.id = id;
        this.cantidadProductos = cantidadProductos;
        this.producto = producto;
        this.idcarrito = carrito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Long getCarrito() {
        return idcarrito;
    }

    public void setCarrito(Long carrito) {
        this.idcarrito = carrito;
    }
    
    
}
