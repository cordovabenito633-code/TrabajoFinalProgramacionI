package proyectoProgramacion1;

public class DetalleVenta {
    Producto producto;
    int cantidad;

    //Constructor de la clase DetalleVenta
    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    //Getters
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    //Setters
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Metodos
    public double calcularSubtotal() {
        double subTotal;
        subTotal = cantidad * producto.calcularPrecioVenta();
        return subTotal;
    }
}
