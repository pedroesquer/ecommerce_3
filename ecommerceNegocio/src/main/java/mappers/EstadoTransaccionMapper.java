/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dtos.EstadoTransaccionDTO;
import entidades.EstadoTransaccion;


/**
 *
 * @author juanpheras
 */

/**
 *
 * @author gael_
 */
public class EstadoTransaccionMapper {
    public static EstadoTransaccion dtoToEntity(EstadoTransaccionDTO estadoDTO) {
        if (estadoDTO == null) {
            return null;
        }
        
        return EstadoTransaccion.valueOf(estadoDTO.name()); 
    }
    
    public static EstadoTransaccionDTO entityToDto(EstadoTransaccion estado) {
        if (estado == null) {
            return null;
        }

        return EstadoTransaccionDTO.valueOf(estado.name()); 
    }

}
