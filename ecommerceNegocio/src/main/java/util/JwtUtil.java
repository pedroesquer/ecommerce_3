/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dtos.UsuarioDTO;
import java.util.Date;

/**
 *
 * @author gael_
 */
public class JwtUtil {
    // CLAVE SECRETA: En un entorno real, esto va en variables de entorno, no en código.
    private static final String SECRET_KEY = "mi_super_secreto_ecommerce_123";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    // 1. Método para CREAR el token cuando el usuario hace login
    public static String generarToken(UsuarioDTO usuario) {
        return JWT.create()
                .withIssuer("ecommerce-api")
                .withSubject(usuario.getCorreo()) // Identificador principal
                .withClaim("idUsuario", usuario.getId()) // Guardamos el ID para usarlo después
                .withClaim("rol", usuario.getRol() != null ? usuario.getRol().toString() : "CLIENTE")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // Expira en 1 hora
                .sign(ALGORITHM);
    }

    // 2. Método para VERIFICAR que el token es real y devolver sus datos
    public static DecodedJWT verificarToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(ALGORITHM)
                .withIssuer("ecommerce-api")
                .build();
        return verifier.verify(token);
    }
}
