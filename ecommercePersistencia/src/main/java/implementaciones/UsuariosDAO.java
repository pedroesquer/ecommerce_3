/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dtos.UsuarioDTO;
import entidades.Producto;
import entidades.Usuario;
import exception.PersistenciaException;
import interfaces.IUsuariosDAO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author gael_
 */
public class UsuariosDAO implements IUsuariosDAO{

    @Override
    public Usuario iniciarSesion(String nombre, String contrasenia) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();

        try {
            String contraseniaEncriptadaIngresada;
            try {
                contraseniaEncriptadaIngresada = encriptarContrasenia(contrasenia);
            } catch (NoSuchAlgorithmException e) {
                throw new PersistenciaException("Error de seguridad: Algoritmo de hashing no disponible.", e);
            }

            String jpql = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("nombre", nombre);

            Usuario usuario;
            try {
                usuario = query.getSingleResult();
            } catch (NoResultException e) {

                System.err.println("Usuario no encontrado.");
                return null;
            }

            String contraseniaBD = usuario.getContrasenia();

            if (contraseniaBD.equals(contraseniaEncriptadaIngresada)) {
                return usuario;
            } else {
                System.err.println("Contraseña incorrecta para el usuario: " + nombre);
                return null; 
            }

        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {

            throw new PersistenciaException("Error de persistencia durante el inicio de sesión: " + e.getMessage(), e);
        } finally {

            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Usuario registrarUsuario(UsuarioDTO usuarioNuevo) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Usuario usuario = new Usuario();
            usuario.setNombre(usuarioNuevo.getNombre());
            usuario.setTelefono(usuarioNuevo.getTelefono());
            usuario.setCorreo(usuarioNuevo.getCorreo());
            usuario.setDireccion(usuarioNuevo.getDireccion());
            usuario.setContrasenia(encriptarContrasenia(usuarioNuevo.getContrasenia()));
            usuario.setEsActivo(Boolean.TRUE);


            entityManager.persist(usuario);
            entityManager.getTransaction().commit();

            return usuario;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new PersistenciaException("Error al registrarse : " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }
    
    /**
     * Metodo para encriptar la contrasenia utilizando SHA-256
     *
     * @param contrasenia Contrasenia a encriptar
     * @return Regresa la contrasenia encriptada (o hasheada)
     * @throws NoSuchAlgorithmException
     */
    private static String encriptarContrasenia(String contrasenia) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Se usa el algorimto SHA-256
        byte[] hashBytes = digest.digest(contrasenia.getBytes(StandardCharsets.UTF_8)); // Realiza el hash
        return bytesAHex(hashBytes);
    }

    /**
     * Metodo que convierte un arreglo de bytes a una cadena hexadecimal
     *
     * @param bytes Arreglo de bytes a convertir
     * @return Cadena de Hexadecimal
     */
    private static String bytesAHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


}
