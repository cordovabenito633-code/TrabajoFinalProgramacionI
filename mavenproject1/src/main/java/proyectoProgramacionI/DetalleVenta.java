package proyectoProgramacionI;

public class DetalleVenta {
    Producto producto;
    int cantidad;
    double subtotal;

    //Constructor de la clase DetalleVenta
    public DetalleVenta(Producto producto, int cantidad, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    //Getters
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    //Setters
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
