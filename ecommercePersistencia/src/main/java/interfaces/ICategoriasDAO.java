/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Categoria;
import entidades.EstadoPedido;
import exception.PersistenciaException;

/**
 *
 * @author juanpheras
 */
public interface ICategoriasDAO {
    public Categoria obtenerPorId(Long id) throws PersistenciaException;
}
