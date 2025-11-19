/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.UsuarioDTO;
import entidades.Usuario;
import exception.IniciarSesionException;
import exception.PersistenciaException;
import exception.RegistrarUsuarioException;
import exception.UsuarioInexistenteException;
import exception.UsuarioNoRegistradoException;
import implementaciones.UsuariosDAO;
import interfaces.IUsuariosBO;
import interfaces.IUsuariosDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.UsuarioMapper;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class UsuariosBO implements IUsuariosBO{
    IUsuariosDAO usuariosDAO;

    public UsuariosBO() {
        this.usuariosDAO = new UsuariosDAO();
    }
    
    
    

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasenia) throws UsuarioInexistenteException {
        try {
            Usuario usuario= usuariosDAO.iniciarSesion(correo, contrasenia);
            if(usuario != null){
                return UsuarioMapper.entityToDTO(usuario);
            }
            return null;
        } catch (PersistenciaException ex) {
            throw new UsuarioInexistenteException("No hay un usuario que coincida con ese correo y contrasenia ");
        }
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO nuevoUsuario) throws UsuarioNoRegistradoException {
        try{
            Usuario usuarioExistente = usuariosDAO.buscarPorCorreo(nuevoUsuario.getCorreo());
            
            if (usuarioExistente != null ){
                throw new UsuarioNoRegistradoException("El correo ya se encuentra registrado");
            }
            
            
            
            Usuario usuarioRegistrado = usuariosDAO.registrarUsuario(UsuarioMapper.DTOToEntity(nuevoUsuario));
            
            return UsuarioMapper.entityToDTO(usuarioRegistrado);
            
        } catch (PersistenciaException e){
            throw new UsuarioNoRegistradoException("No se pudo registrar al usuario " + e.getMessage(), e);
        }
    }
}
