/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class MetodoDePagoDTO {
    private Long id;
    private EstadoTransaccionDTO estado;
    private Double monto;
    private Date fechaHora;
    private TipoMetodoPagoDTO tipo;

    public MetodoDePagoDTO() {
    }
    
    

    public MetodoDePagoDTO(Long id, EstadoTransaccionDTO estado, Double monto, Date fechaHora, TipoMetodoPagoDTO tipo) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoTransaccionDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccionDTO estado) {
        this.estado = estado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public TipoMetodoPagoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoMetodoPagoDTO tipo) {
        this.tipo = tipo;
    }
    
    
}
