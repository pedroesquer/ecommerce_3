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
public class ReseñaDTO {
    private Long id;
    private String comentario; 
    private Integer estrellas;
    private LocalDateTime fechaHora;
    private ProductoDTO producto;
    private UsuarioDTO usuario;
    private List<ProductoDTO> productos;

    public ReseñaDTO(Long id, String comentario, Integer estrellas, LocalDateTime fechaHora, ProductoDTO producto, UsuarioDTO usuario) {
        this.id = id;
        this.comentario = comentario;
        this.estrellas = estrellas;
        this.fechaHora = fechaHora;
        this.producto = producto;
        this.usuario = usuario;
    }

    /**
     * Método constructor de Reseña que recibe todos los parametros excepto id.
     * @param comentario comentario de la reseña
     * @param estrellas calificación de la reseña
     * @param fechaHora fecha y hora que se publico la reseña
     * @param producto producto al cual pertenece la reseña
     * @param usuario usuario el cual hizo la reseña
     * @param reseñas lista de reseñas
     */
    public ReseñaDTO(String comentario, Integer estrellas, LocalDateTime fechaHora, ProductoDTO producto, UsuarioDTO usuario, List<ProductoDTO> reseñas) {
        this.comentario = comentario;
        this.estrellas = estrellas;
        this.fechaHora = fechaHora;
        this.producto = producto;
        this.usuario = usuario;
        this.productos = reseñas;
    }
    
    /**
     * Método constructor de Reseña que recibe todos los parametros excepto id y la lista de productos.
     * @param comentario comentario de la reseña
     * @param estrellas calificación de la reseña
     * @param fechaHora fecha y hora que se publico la reseña
     * @param producto producto al cual pertenece la reseña
     * @param usuario usuario el cual hizo la reseña
     */
    public ReseñaDTO(String comentario, Integer estrellas, LocalDateTime fechaHora, ProductoDTO producto, UsuarioDTO usuario) {
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
