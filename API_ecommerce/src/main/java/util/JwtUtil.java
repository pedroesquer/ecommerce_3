/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.Key;
import dtos.UsuarioDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Clase para crear el token JWT y validarlo
 *
 * @author Juan Heras
 */
public class JwtUtil {

    private static final String SECRET_KEY = "ESTA_CLAVE_DEBE_TENER_MINIMO_32_CARACTERES!!!";

    private static final Key KEY = Keys.hmacShaKeyFor(
            SECRET_KEY.getBytes(StandardCharsets.UTF_8)
    );

    /**
     * Método para generar un token a partir de la sesión del Usuario.
     *
     * @param usuario usuario que ingresa a la aplicación
     * @return
     */
    public static String generarToken(UsuarioDTO usuario) {

        return Jwts.builder()
                .setSubject(String.valueOf(usuario.getId())) // sub = id usuario
                .claim("rol", usuario.getRol().name())
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 60 * 60 * 1000) // 1 hora
                )
                .signWith(KEY,SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Método para validar el token que se creo al iniciar sesión.
     * @param token
     * @return 
     */
    public static Claims validarToken(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
