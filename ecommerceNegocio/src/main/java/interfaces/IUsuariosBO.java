/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.UsuarioDTO;
import entidades.Usuario;
import exception.AdministrarUsuarioException;
import exception.UsuarioInexistenteException;
import exception.UsuarioNoRegistradoException;
import java.util.List;


/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface IUsuariosBO{
    
    public UsuarioDTO iniciarSesion(String correo, String contrasenia) throws UsuarioInexistenteException;
    public UsuarioDTO registrarUsuario(UsuarioDTO nuevoUsuario) throws UsuarioNoRegistradoException;
    
    public List<UsuarioDTO> mostrarUsuarios() throws AdministrarUsuarioException;
    public void eliminarUsuario(Long idUsuario) throws AdministrarUsuarioException ; 
    public void desactivarUsuario(Long idUsuario) throws AdministrarUsuarioException ;
    public void activarUsuario(Long idUsuario) throws AdministrarUsuarioException ;
}
