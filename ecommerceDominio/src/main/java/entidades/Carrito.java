
package entidades;

import java.util.List;

/**
 *
 * @author Juan Heras
 */
public class Carrito {
    private List<Producto> productos;
    private double total;
    private Usuario usuario;

    public Carrito(List<Producto> productos, double total, Usuario usuario) {
        this.productos = productos;
        this.total = total;
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
