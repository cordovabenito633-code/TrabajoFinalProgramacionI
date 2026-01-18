package proyectoProgramacion1;

public class ProductoNacional extends Producto{
    public ProductoNacional(double precio, String nombre, String marca, int stock, boolean estado) {
        super(precio, nombre, marca, stock, estado);
    }

    @Override
    public double calcularPrecioVenta() {
        return this.precio; 
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Nacional (sin recargo)");
    }
}