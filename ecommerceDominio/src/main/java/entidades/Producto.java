/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gael_
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "stock", nullable = false)
    private Integer stock;
    
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
    
    @Column(name = "disponibilidad", nullable = false)
    private Boolean disponibilidad;
    
    @Column(name = "rutaImagen", nullable = false)
    private String rutaImagen;

    @Column(name = "especificaciones_tecnicas", length = 100, nullable = true)
    private String especificacionesTecnicas;
    
    
    @ManyToOne
    @JoinColumn(name = "id_categoia", nullable = false)
    private Categoria categoria;

    
    //reseñas, si el producto bye las reseñas tambien. 
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Reseña> resenias;
    
    //
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallesPedido> detallesPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    

    public List<Reseña> getResenias() {
        return resenias;
    }

    public void setResenias(List<Reseña> resenias) {
        this.resenias = resenias;
    }

    public Producto() {
    }

    public Producto(Long id, String nombre, Double precio, Integer stock, String descripcion, Boolean disponibilidad, String especificacionesTecnicas, List<Reseña> resenias) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.resenias = resenias;
    }

    public Producto(String nombre, Double precio, Integer stock, String descripcion, Boolean disponibilidad, String especificacionesTecnicas, List<Reseña> resenias) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.resenias = resenias;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Producto[ id=" + id + " ]";
    }
    
}
