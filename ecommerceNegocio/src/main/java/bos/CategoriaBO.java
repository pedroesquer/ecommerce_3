/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.CategoriaDTO;
import entidades.Categoria;
import exception.ObtenerCategoriaPorIDException;
import exception.ObtenerCategoriasException;
import exception.PersistenciaException;
import implementaciones.CategoriasDAO;
import interfaces.ICategoriaBO;
import interfaces.ICategoriasDAO;
import java.util.List;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class CategoriaBO implements ICategoriaBO{
    private ICategoriasDAO categoriaDao;

    public CategoriaBO() {
        categoriaDao = new CategoriasDAO();
    }

    @Override
    public CategoriaDTO obtenerPorId(Long id) throws ObtenerCategoriaPorIDException {
        try {
            return mappers.CategoriaMapper.entityToDTO(categoriaDao.obtenerPorId(id));
        } catch (PersistenciaException ex) {
            throw new ObtenerCategoriaPorIDException("Error al obtener la categoria");
        }
    }

    @Override
    public List<CategoriaDTO> obtenerCategorias() throws ObtenerCategoriasException {
        List<CategoriaDTO> categorias;
        try {
            categorias = mappers.CategoriaMapper.toDTOList(categoriaDao.obtenerCategorias());
            return categorias;
        } catch (PersistenciaException ex) {
            throw new ObtenerCategoriasException("error al obtener las categorias");
        }
    }
    
    
    
}
