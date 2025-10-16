/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Pedido {
    private String numeroPedido;
    private MetodoPago metodoPago;
    private LocalDateTime fechaHora;
    private EstadoPedido estado;
    private double total;
    private Usuario usuario;
    private List<DetallePedido> productosPedido;

    public Pedido(String numeroPedido, MetodoPago metodoPago, LocalDateTime fechaHora, EstadoPedido estado, double total, Usuario usuario, List<DetallePedido> productosPedido) {
        this.numeroPedido = numeroPedido;
        this.metodoPago = metodoPago;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.total = total;
        this.usuario = usuario;
        this.productosPedido = productosPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetallePedido> getProductosPedido() {
        return productosPedido;
    }

    public void setProductosPedido(List<DetallePedido> productosPedido) {
        this.productosPedido = productosPedido;
    }
    
    
    
}
