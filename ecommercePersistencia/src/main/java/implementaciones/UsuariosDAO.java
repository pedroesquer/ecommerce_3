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
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public Usuario iniciarSesion(String correo, String contrasenia) throws PersistenciaException {
        EntityManager em = ManejadorConexiones.getEntityManager();

        try {
            String contraseniaEncriptadaIngresada;
            try {
                contraseniaEncriptadaIngresada = encriptarContrasenia(contrasenia);
            } catch (NoSuchAlgorithmException e) {
                throw new PersistenciaException("Error de seguridad: Algoritmo de hashing no disponible.", e);
            }

            String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("correo", correo);

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
                System.err.println("Contraseña incorrecta para el usuario: " + correo);
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
    public Usuario registrarUsuario(Usuario usuarioNuevo) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            usuarioNuevo.setContrasenia(encriptarContrasenia(usuarioNuevo.getContrasenia()));
            entityManager.persist(usuarioNuevo);
            entityManager.getTransaction().commit();

            return usuarioNuevo;
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

    @Override
    public Usuario buscarPorCorreo(String correo) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo";
            TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
            query.setParameter("correo", correo);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar por correo", e);
        }
    }

}
