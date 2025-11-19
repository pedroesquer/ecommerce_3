/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.UsuarioDTO;
import entidades.Usuario;
import exception.UsuarioInexistenteException;
import exception.UsuarioNoRegistradoException;


/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface IUsuariosBO{
    
    public UsuarioDTO iniciarSesion(String correo, String contrasenia) throws UsuarioInexistenteException;
    public UsuarioDTO registrarUsuario(UsuarioDTO nuevoUsuario) throws UsuarioNoRegistradoException;
}
