
package dtos;

/**
 * DTO para crear el pedido que solo tiene como atributo el tipoPago y la dirección de envio.
 * @author Juan Heras
 */
public class CrearPedidoDTO {
    
    private String tipoPago;
    private String direccionEnvio;

    public CrearPedidoDTO() {
    }

    public CrearPedidoDTO(String tipoPago, String direccionEnvio) {
        this.tipoPago = tipoPago;
        this.direccionEnvio = direccionEnvio;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
    
    
    
    
    
}
