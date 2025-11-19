/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entidades.Pedido;
import entidades.Producto;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class DetallePedidoDTO {
    private Long id;
    private Integer cantidad;
    private ProductoDTO producto;
    private PedidoDTO pedido;

    public DetallePedidoDTO(Long id, Integer cantidad, ProductoDTO producto, PedidoDTO pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.pedido = pedido;
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

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }
    
    
}
