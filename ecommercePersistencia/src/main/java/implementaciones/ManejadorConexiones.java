/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gael_
 */


//PRUEBA PARA GENERAR LA BASE DE DATOS EN MYSQL
public class ManejadorConexiones {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO GENERACIÓN DE ESQUEMA JPA ---");
        
       
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ecommercePersistencia_jar_1.0-SNAPSHOTPU");
            
            System.out.println("¡Esquema generado exitosamente! Tablas creadas en MySQL.");
            
            if (emf != null) {
                emf.close();
            }
            
        } catch (Exception e) {
            System.err.println("¡ERROR! Falló la inicialización de la base de datos.");
            System.err.println("Revisa tu URL, usuario, contraseña o si la base de datos 'ecommerce3' existe en MySQL.");
            e.printStackTrace();
        }
    }
}
