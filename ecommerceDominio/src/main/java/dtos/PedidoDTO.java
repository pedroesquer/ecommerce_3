/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class PedidoDTO {

    private Long id;
    private String numeroPedido;
    private EstadoTransaccionDTO estado;
    private Double total;
    private LocalDateTime fechaHora;
    private MetodoDePagoDTO metodoPago;
    private List<DetallePedidoDTO> detallesPedido;
    private String direccion;
    private UsuarioDTO usuario;

    public PedidoDTO(Long id, String numeroPedido, EstadoTransaccionDTO estado, Double total, LocalDateTime fechaHora, MetodoDePagoDTO metodoPago, List<DetallePedidoDTO> detallesPedido, String direccion, UsuarioDTO usuario) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.estado = estado;
        this.total = total;
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.detallesPedido = detallesPedido;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public EstadoTransaccionDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccionDTO estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MetodoDePagoDTO getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoDePagoDTO metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<DetallePedidoDTO> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedidoDTO> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    
    
}
