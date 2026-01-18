package proyectoProgramacion1;

public class ProductoImportado extends Producto{
    private double impuesto;

    public ProductoImportado(double precio, String nombre, String marca, int stock, boolean estado, double impuesto) {
        super(precio, nombre, marca, stock, estado);
        this.impuesto = impuesto;
    }

    @Override
    public double calcularPrecioVenta() {
        double precioVenta;
        precioVenta = this.precio + (this.precio * impuesto);
        return precioVenta;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Importado (incluye impuesto del " + (impuesto * 100) + "%)");
    }
}
