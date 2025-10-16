/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author pedro
 */
public class Producto {
    private int stock;
    private String imagen;
    private String nombre;
    private double precio;
    private String descripcion;
    private List<Categoria> categorias;
    private int valoracion;
    private Disponibilidad disponibilidad;
    private List<ReseniaProducto> valoraciones;
    private List<String> especificaciones;

    public Producto(int stock, String imagen, String nombre, double precio, String descripcion, List<Categoria> categorias, int valoracion, Disponibilidad disponibilidad, List<ReseniaProducto> valoraciones, List<String> especificaciones) {
        this.stock = stock;
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.valoracion = valoracion;
        this.disponibilidad = disponibilidad;
        this.valoraciones = valoraciones;
        this.especificaciones = especificaciones;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<ReseniaProducto> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<ReseniaProducto> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public List<String> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(List<String> especificaciones) {
        this.especificaciones = especificaciones;
    }
    
    
    
}
