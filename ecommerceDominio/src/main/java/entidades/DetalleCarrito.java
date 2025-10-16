
package entidades;

/**
 *
 * @author Juan Heras
 */
public class DetalleCarrito {
    private Producto producto;
    private Carrito carrito;
    private int cantidad;
    private double importe;

    public DetalleCarrito(Producto producto, Carrito carrito) {
        this.producto = producto;
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
    
}
