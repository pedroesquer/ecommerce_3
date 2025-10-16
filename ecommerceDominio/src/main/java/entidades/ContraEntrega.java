
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author juanpheras
 */
public class ContraEntrega extends MetodoPago {
    
    private double montoDado;
    private String emisor;

    public ContraEntrega(double montoDado, String emisor, double monto, LocalDateTime fecha, String estado) {
        super(monto, fecha, estado);
        this.montoDado = montoDado;
        this.emisor = emisor;
    }

    public double getMontoDado() {
        return montoDado;
    }

    public void setMontoDado(double montoDado) {
        this.montoDado = montoDado;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    
    
    
    
    
    
    
}
