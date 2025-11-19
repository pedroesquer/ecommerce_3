/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bos;

import dtos.ProductoDTO;
import dtos.ReseñaDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pedro
 */
public class ProductoBOTest {

    public ProductoBOTest() {
    }

    /**
     * Test of eliminarProducto method, of class ProductoBO.
     */
    @org.junit.jupiter.api.Test
    public void testEliminarProducto() throws Exception {
    }

    /**
     * Test of agregarProducto method, of class ProductoBO.
     */
    @org.junit.jupiter.api.Test
    public void testAgregarProducto() throws Exception {
        ProductoBO productoPrueba = new ProductoBO();
        ProductoDTO nuevoProducto = new ProductoDTO(1l, "Chupones de manguera", 30d, 9, "Chingones chupones de manguera a domicilio a la verga", true, "Manguerita bien fria", "imgs/aceite1.png");
        productoPrueba.agregarProducto(nuevoProducto);
    }

    /**
     * Test of editarProducto method, of class ProductoBO.
     */
    @org.junit.jupiter.api.Test
    public void testEditarProducto() throws Exception {
    }

    @org.junit.jupiter.api.Test
    public void testObtenerProductos() throws Exception {
        ProductoBO productosPrueba = new ProductoBO();
        productosPrueba.
    }

}
