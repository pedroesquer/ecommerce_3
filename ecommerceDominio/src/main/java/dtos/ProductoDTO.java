/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;
    private Boolean disponibilidad;
    private String especificacionesTecnicas;
    private String rutaImagen; 
    private List<ReseñaDTO> reseñas;
    private CategoriaDTO categoria;

    public ProductoDTO() {
    }
    
    

    public ProductoDTO(Long id, String nombre, Double precio, Integer stock, String descripcion, Boolean disponibilidad, String especificacionesTecnicas, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.rutaImagen = rutaImagen;
    }

    
    
    
    
    
    public ProductoDTO(Long id, String nombre, Double precio, Integer stock, String descripcion, Boolean disponibilidad, String especificacionesTecnicas, String rutaImagen, List<ReseñaDTO> reseñas) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.rutaImagen = rutaImagen;
        this.reseñas = reseñas;
    }

    /**
     * Método constructor de productoDTO que recibe todos los parametros excepto el id(generado automáticamente) y la lista de reseñaas.
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param stock stock del producto
     * @param descripcion Descripción 
     * @param disponibilidad Estado del producto
     * @param especificacionesTecnicas Especificaciones tecnicas
     * @param rutaImagen ruta de la imagen del producto
     * @param categoria Categoria a la cual pertenece el producto
     */
    public ProductoDTO(String nombre, Double precio, Integer stock, String descripcion, Boolean disponibilidad, String especificacionesTecnicas, String rutaImagen, CategoriaDTO categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.rutaImagen = rutaImagen;
        this.categoria = categoria;
    }
    
    

    

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
    
    

    public List<ReseñaDTO> getReseñas() {
        return reseñas;
    }

    public void setReseñas(List<ReseñaDTO> reseñas) {
        this.reseñas = reseñas;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }
    
    
    
    
    
    
}
