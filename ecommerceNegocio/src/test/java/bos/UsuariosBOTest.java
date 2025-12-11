
import bos.UsuariosBO;
import dtos.RolUsuarioDTO;
import dtos.UsuarioDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



/**
 *
 * @author juanpheras
 */
public class UsuariosBOTest {

    
    private UsuariosBO usuariosBO;
    
    public UsuariosBOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.usuariosBO = new UsuariosBO();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of iniciarSesion method, of class UsuariosBO.
     */
    @Test
    public void testIniciarSesion() throws Exception {
    }

    /**
     * Test of registrarUsuario method, of class UsuariosBO.
     */
    @Test
    public void testRegistrarUsuarioOK() throws Exception {
        UsuarioDTO usuario = new UsuarioDTO("Pedro Zamudio", 
                "Real del arco #208", 
                "0123456789", 
                "zamudio@potros.com", 
                "admin123", 
                Boolean.TRUE, 
                RolUsuarioDTO.ADMINISTRADOR);
        
        
        UsuarioDTO usuarioRegistar = usuariosBO.registrarUsuario(usuario);
        
        assertEquals(usuario.getNombre(), usuarioRegistar.getNombre());
        assertEquals(usuario.getCorreo(), usuarioRegistar.getCorreo());
        assertEquals(usuario.getTelefono(), usuarioRegistar.getTelefono());
    }
    

}
