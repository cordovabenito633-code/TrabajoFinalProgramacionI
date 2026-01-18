
package proyectoProgramacionI;
import java.util.ArrayList;

public class Venta {
    int idVenta;
    String fecha;
    double total;
    ArrayList <DetalleVenta> detalles;

    //Constructor de la clase venta:
    public Venta(int idVenta, String fecha, double total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
    }
}
