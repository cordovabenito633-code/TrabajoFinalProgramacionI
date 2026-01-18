
package proyectoProgramacionI;
import java.util.ArrayList;

public class Venta {
    int idVenta;
    String fecha;
    double total;
    ArrayList <DetalleVenta> detalles;

    //Constructor de la clase venta:
    public Venta(int idVenta, String fecha, double total, ArrayList <DetalleVenta> detalles) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.detalles = detalles;
    }

    //Setters
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDetalles(ArrayList <DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    //Getters
    public int getIdVenta() {
        return idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList <DetalleVenta> getDetalles() {
        return detalles;
    }

    //Metodos
    
}
