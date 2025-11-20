/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.CategoriaDTO;
import entidades.Categoria;
import exception.ObtenerCategoriaPorIDException;
import exception.ObtenerCategoriasException;

import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public interface ICategoriaBO {
        public CategoriaDTO obtenerPorId(Long id) throws ObtenerCategoriaPorIDException;
        public List<CategoriaDTO> obtenerCategorias() throws ObtenerCategoriasException;

}
