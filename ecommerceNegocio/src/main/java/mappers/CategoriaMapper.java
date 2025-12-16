/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dtos.CategoriaDTO;
import dtos.ProductoDTO;
import entidades.Categoria;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public class CategoriaMapper {

    public static CategoriaDTO entityToDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO(categoria.getId(), categoria.getNombre(), categoria.getDescripcion());

        return categoriaDTO;
    }

    public static Categoria DTOToEntity(CategoriaDTO categoria) {
        Categoria categoriaEntity = new Categoria(categoria.getId(), categoria.getNombre(), categoria.getDescripcion());

        return categoriaEntity;
    }
    
    public static List<CategoriaDTO> toDTOList(List<Categoria> categorias){
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();
        for(Categoria categoria : categorias){
            categoriasDTO.add(entityToDTO(categoria));
        }
        return categoriasDTO;
    }
}
