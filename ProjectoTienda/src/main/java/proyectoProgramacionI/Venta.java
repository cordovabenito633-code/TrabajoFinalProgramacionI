
package proyectoProgramacionI;
import java.util.ArrayList;

public class Venta {
    int idVenta;
    String fecha;
    double total;
    ArrayList <DetalleVenta> detalles;

    //Constructor de la clase venta:
    public Venta(int idVenta, String fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = 0;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleVenta detalle) {
        this.detalles.add(detalle);
        this.total = this.total + detalle.calcularSubtotal();
        detalle.getProducto().reducirStock(detalle.getCantidad());
    }

    public void mostrarTicket() {
        System.out.println("\n=== BOLETA DE VENTA #" + idVenta + " ===");
        System.out.println("Fecha: " + fecha);
        for (DetalleVenta dv : detalles) {
            System.out.println("- " + dv.getProducto().getNombre() + 
                               " x" + dv.getCantidad() + 
                               " | Subtotal: " + dv.calcularSubtotal());
        }
        System.out.println("TOTAL A PAGAR: " + total);
    }
}
