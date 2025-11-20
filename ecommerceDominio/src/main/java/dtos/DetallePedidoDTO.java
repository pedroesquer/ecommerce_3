/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class DetallePedidoDTO {
    private Long id;
    private Integer cantidad;
    private ProductoDTO producto;

    public DetallePedidoDTO(Long id, Integer cantidad, ProductoDTO producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public DetallePedidoDTO(Integer cantidad, ProductoDTO producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    
    
}
