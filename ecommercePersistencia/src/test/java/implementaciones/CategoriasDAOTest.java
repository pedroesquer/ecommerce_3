/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import entidades.Categoria;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class CategoriasDAOTest {
    
    public CategoriasDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of obtenerPorId method, of class CategoriasDAO.
     */
    @Test
    public void testObtenerPorId() throws Exception {
        System.out.println("obtenerPorId");
        Long id = 1L;
        CategoriasDAO instance = new CategoriasDAO();
        Categoria result = instance.obtenerPorId(id);
    }

    /**
     * Test of obtenerCategorias method, of class CategoriasDAO.
     */
    @Test
    public void testObtenerCategorias() throws Exception {
        System.out.println("obtenerCategorias");
        CategoriasDAO instance = new CategoriasDAO();
        List<Categoria> result = instance.obtenerCategorias();
        System.out.println(result);

    }
    
}
