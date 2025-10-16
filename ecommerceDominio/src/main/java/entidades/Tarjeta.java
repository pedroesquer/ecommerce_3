
package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Juan Heras
 */
public class Tarjeta extends MetodoPago {
    
    private String numero;
    private LocalDate fechaCaducidad;
    private String nombre;

    public Tarjeta(String numero, LocalDate fechaCaducidad, String nombre, double monto, LocalDateTime fecha, String estado) {
        super(monto, fecha, estado);
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
}
