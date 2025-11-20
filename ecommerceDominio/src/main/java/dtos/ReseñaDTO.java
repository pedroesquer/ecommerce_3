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
    private long idProducto;
    private UsuarioDTO usuario;


    public ReseñaDTO(Long id, String comentario, Integer estrellas, LocalDateTime fechaHora, Long idProducto, UsuarioDTO usuario) {
        this.id = id;
        this.comentario = comentario;
        this.estrellas = estrellas;
        this.fechaHora = fechaHora;
        this.idProducto = idProducto;
        this.usuario = usuario;
    }

    /**
     * Método constructor de Reseña que recibe todos los parametros excepto id.
     * @param comentario comentario de la reseña
     * @param estrellas calificación de la reseña
     * @param fechaHora fecha y hora que se publico la reseña
     * @param idProducto
     * @param usuario usuario el cual hizo la reseña

     */
    public ReseñaDTO(String comentario, Integer estrellas, LocalDateTime fechaHora, Long idProducto, UsuarioDTO usuario) {
        this.comentario = comentario;
        this.estrellas = estrellas;
        this.fechaHora = fechaHora;
        this.idProducto = idProducto;
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

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
    
}
