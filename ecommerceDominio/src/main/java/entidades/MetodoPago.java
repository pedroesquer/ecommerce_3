/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gael_
 */
@Entity
@Table(name = "metodo_pago")
public class MetodoPago implements Serializable {

    @Id
    @Column(name = "id_metodo_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTransaccion estado;
    
    @Column(name = "monto", nullable = false)
    private Double monto;
    
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
    
    @Column(name="tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMetodoPago tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public TipoMetodoPago getTipo() {
        return tipo;
    }

    public void setTipo(TipoMetodoPago tipo) {
        this.tipo = tipo;
    }

    public MetodoPago() {
    }

    public MetodoPago(EstadoTransaccion estado, Double monto, LocalDateTime fechaHora, TipoMetodoPago tipo) {
        this.estado = estado;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MetodoPago[ id=" + id + " ]";
    }
    
}
