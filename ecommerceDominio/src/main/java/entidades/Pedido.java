/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author gael_
 */
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero_pedido",  nullable = false)
    private String numeroPedido;
    
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTransaccion estado;
    
    @Column(name = "total", length = 50, nullable = false)
    private Double total;
    
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
    
    @OneToOne
    @JoinColumn(name="id_metodo_pago", nullable=false)
    private MetodoPago metodoPago;
    
    //un pedido tiene muchos detallePedido, si pedido camina detallespedido tambien. 
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallesPedido> detallesPedido;

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

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
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

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<DetallesPedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallesPedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public Pedido() {
    }

    public Pedido(Long id, String numeroPedido, EstadoTransaccion estado, Double total, LocalDateTime fechaHora, MetodoPago metodoPago, List<DetallesPedido> detallesPedido) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.estado = estado;
        this.total = total;
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.detallesPedido = detallesPedido;
    }

    public Pedido(String numeroPedido, EstadoTransaccion estado, Double total, LocalDateTime fechaHora, MetodoPago metodoPago, List<DetallesPedido> detallesPedido) {
        this.numeroPedido = numeroPedido;
        this.estado = estado;
        this.total = total;
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.detallesPedido = detallesPedido;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pedido[ id=" + id + " ]";
    }
    
}
