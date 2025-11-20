/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dtos.EstadoTransaccionDTO;
import dtos.MetodoDePagoDTO;
import dtos.TipoMetodoPagoDTO;
import entidades.MetodoPago;

/**
 *
 * @author gael_
 */
public class MetodoPagoMapper {
    public static MetodoDePagoDTO entityToDTO(MetodoPago metodo) {
        if (metodo == null) {
            return null;
        }

        EstadoTransaccionDTO estadoDTO = EstadoTransaccionMapper.entityToDto(metodo.getEstado());
        
        TipoMetodoPagoDTO tipoDTO = TipoMetodoPagoMapper.entityToDTO(metodo.getTipo());
        

        return new MetodoDePagoDTO(
                metodo.getId(),
                estadoDTO,
                metodo.getMonto(),
                metodo.getFechaHora(),
                tipoDTO
        );
    }
    
    public static MetodoPago dtoToEntity(MetodoDePagoDTO metodoDTO) {
        if (metodoDTO == null) {
            return null;
        }

        MetodoPago metodo = new MetodoPago();

        metodo.setId(metodoDTO.getId());
        metodo.setMonto(metodoDTO.getMonto());
        metodo.setFechaHora(metodoDTO.getFechaHora());

        if (metodoDTO.getEstado() != null) {
            metodo.setEstado(EstadoTransaccionMapper.dtoToEntity(metodoDTO.getEstado()));
        }

        if (metodoDTO.getTipo() != null) {
            metodo.setTipo(TipoMetodoPagoMapper.dtoToEntity(metodoDTO.getTipo()));
        }

        return metodo;
    }

}
