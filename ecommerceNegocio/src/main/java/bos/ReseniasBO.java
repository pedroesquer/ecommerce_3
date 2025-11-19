/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import exception.EliminarReseñaException;
import interfaces.IReseniasBO;

/**
 *
 * @author ramonsebastianzamudioayala
 */
public class ReseniasBO implements IReseniasBO{
    IReseniasBO reseniaDAO;

    public ReseniasBO() {
        reseniaDAO = new ReseniasBO();
    }
    
    @Override
    public void eliminarResenia() throws EliminarReseñaException {
        reseniaDAO.eliminarResenia();
    }
    
}
