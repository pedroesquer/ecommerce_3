/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dtos.ReseñaDTO;
import entidades.Reseña;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author pedro
 */
public class ReseñaMapper {

    public static ReseñaDTO entityToDTO(Reseña reseña) {
        ReseñaDTO reseñaDTO = new ReseñaDTO(reseña.getId(),
                reseña.getComentario(),
                reseña.getEstrellas(),
                reseña.getFechaHora(),
                ProductoMapper.entityToDTO(reseña.getProducto()),
                UsuarioMapper.entityToDTO(reseña.getUsuario()));
        return reseñaDTO;
    }
    
    public static Reseña DTOToEntity(ReseñaDTO reseña) {
        Reseña reseñaEntity = new Reseña(reseña.getId(),
                reseña.getComentario(),
                reseña.getEstrellas(),
                reseña.getFechaHora(),
                ProductoMapper.DTOToEntity(reseña.getProducto()),
                UsuarioMapper.DTOToEntity(reseña.getUsuario()));
        return reseñaEntity;
    }

    public static List<ReseñaDTO> entityListToDTOList(List<Reseña> reseñas) {
        if (reseñas == null) {
            return null;
        }

        return reseñas.stream()
                .map(ReseñaMapper::entityToDTO)
                .toList();
    }
    
    public static List<Reseña> DTOListToEntityList(List<ReseñaDTO> reseñasDTO) {
        if (reseñasDTO == null) {
            return null;
        }

        return reseñasDTO.stream()
                .map(ReseñaMapper::DTOToEntity)
                .toList();
    }

}
