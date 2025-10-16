
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Juan Heras
 */
public class Transferencia extends MetodoPago {
    private String numeroReferencia;
    private String bancoOrigen;
    private String emisor;

    public Transferencia(String numeroReferencia, String bancoOrigen, String emisor, double monto, LocalDateTime fecha, String estado) {
        super(monto, fecha, estado);
        this.numeroReferencia = numeroReferencia;
        this.bancoOrigen = bancoOrigen;
        this.emisor = emisor;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public void setBancoOrigen(String bancoOrigen) {
        this.bancoOrigen = bancoOrigen;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    
    
    
}
