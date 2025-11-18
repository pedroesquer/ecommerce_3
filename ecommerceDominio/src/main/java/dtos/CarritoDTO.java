/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import entidades.DetallesCarrito;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class CarritoDTO {
    private Long id;

    private Double total;
    
    private List<DetallesCarrito> detallesCarrito;

    private Usuario usuario;

    public CarritoDTO(Long id, Double total, List<DetallesCarrito> detallesCarrito, Usuario usuario) {
        this.id = id;
        this.total = total;
        this.detallesCarrito = detallesCarrito;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetallesCarrito> getDetallesCarrito() {
        return detallesCarrito;
    }

    public void setDetallesCarrito(List<DetallesCarrito> detallesCarrito) {
        this.detallesCarrito = detallesCarrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
