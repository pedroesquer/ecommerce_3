/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dtos.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author pedro
 */
public class UsuarioMapper {

    public static UsuarioDTO entityToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(),
                usuario.getNombre(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCorreo(),
                usuario.getContrasenia(),
                usuario.getEsActivo(),
                RolUsuarioMapper.toDTO(usuario.getRol()));
        return usuarioDTO;
    }

    public static Usuario DTOToEntity(UsuarioDTO userDTO) {
        Usuario usuario = new Usuario(
                userDTO.getNombre(),
                userDTO.getTelefono(),
                userDTO.getDireccion(),
                userDTO.getCorreo(),
                userDTO.getContrasenia(),
                userDTO.getEsActivo(),
                RolUsuarioMapper.toEntity(userDTO.getRol()));
        
        usuario.setId(userDTO.getId());
        return usuario;
    }
}
