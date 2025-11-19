/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class ReseñaDTO {
    private Long id;
    private String comentario; 
    private Integer estrellas;
    private LocalDateTime fechaHora;
    private ProductoDTO producto;
    private UsuarioDTO usuario;

    public ReseñaDTO(Long id, String comentario, Integer estrellas, LocalDateTime fechaHora, ProductoDTO producto, UsuarioDTO usuario) {
        this.id = id;
        this.comentario = comentario;
        this.estrellas = estrellas;
        this.fechaHora = fechaHora;
        this.producto = producto;
        this.usuario = usuario;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
    
}
