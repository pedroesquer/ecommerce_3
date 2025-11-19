/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.UsuarioDTO;
import entidades.Usuario;
import exception.PersistenciaException;

/**
 *
 * @author gael_
 */
public interface IUsuariosDAO {
    public Usuario iniciarSesion(String nombre, String contrasenia) throws PersistenciaException;
    public Usuario registrarUsuario(Usuario usuarioNuevo) throws PersistenciaException;
    public Usuario buscarPorCorreo(String correo) throws PersistenciaException;
    
    // no es parte del avance 3
    //public void eliminarCliente(); 
    //public void desactivarCliente();
}
