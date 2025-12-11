/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;



/**
 *
 * @author ramonsebastianzamudioayala
 */
public class DetallesCarritoDTO {
    private Long id;
    private Integer cantidadProductos;
    private Float importe;
    private ProductoDTO producto;
    private CarritoDTO carrito;

    public DetallesCarritoDTO(Long id, Integer cantidadProductos, Float importe, ProductoDTO producto, CarritoDTO carrito) {
        this.id = id;
        this.cantidadProductos = cantidadProductos;
        this.importe = importe;
        this.producto = producto;
        this.carrito = carrito;
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

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public CarritoDTO getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDTO carrito) {
        this.carrito = carrito;
    }
    
    
}
