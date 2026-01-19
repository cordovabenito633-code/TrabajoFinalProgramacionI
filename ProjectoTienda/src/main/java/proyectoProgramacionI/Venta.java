
package proyectoProgramacionI;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Array;

public class Venta {
    int idVenta;
    String fecha;
    double total;
    ArrayList<DetalleVenta> detalles;

    public static void main(String[] args) {
        Venta ven;
        ArrayList<Producto> arr1;
        ven = new Venta(0, "");
        arr1 = ven.ingresarProductos();
        ven.procesarBoleta(arr1);
    }

    // Constructor de la clase venta:
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

    public boolean preguntarFin() {
        Scanner tec;
        String respuesta;
        boolean estado;
        tec = new Scanner(System.in);
        System.out.println("Desea ingresar mas productos (si o no)");
        respuesta = new String(tec.nextLine());
        if (respuesta.trim().toLowerCase() == "si") {
            estado = true;
        } else {
            estado = false;
        }
        return estado;
    }

    public ArrayList<Producto> ingresarProductos() {
        Scanner tec;
        ProductoNacional p1;
        ProductoImportado p2;
        String nomProducto, marca, tipoProducto;
        boolean estado;
        double precio, impuestos;
        int stock;
        ArrayList<Producto> productosComprados;

        productosComprados = new ArrayList<>();
        tec = new Scanner(System.in);

        do {
            System.out.println("Ingresa el tipo de producto Producto Nacional o Producto Importado");
            tipoProducto = new String(tec.nextLine());
            System.out.println("Ingrese el nombre del producto");
            nomProducto = tec.nextLine();
            System.out.println("Ingrese la marca del producto");
            marca = tec.nextLine();
            System.out.println("Ingrese el precio del producto");
            precio = tec.nextDouble();
            System.out.println("Ingrese la cantidad de productos que quedan");
            stock = tec.nextInt();
            System.out.println("Ingrese si el producto sigue disponible o no (True o False)");
            estado = tec.nextBoolean();

            if (tipoProducto.trim().toLowerCase().equals("producto importado")) {
                impuestos = tec.nextDouble();
                p2 = new ProductoImportado(precio, tipoProducto, marca, stock, estado, impuestos);
                productosComprados.add(p2);
            } else {
                p1 = new ProductoNacional(precio, nomProducto, marca, stock, estado);
                productosComprados.add(p1);
            }

        } while (preguntarFin());
        return productosComprados;
    }

    public void procesarBoleta(ArrayList<Producto> productosComprados) {
        Venta v1;
        int cant, id;
        Scanner tec;
        String fecha;

        tec = new Scanner(System.in);
        System.out.println("Ingrese el ID");
        id = tec.nextInt();
        System.out.println("Ingrese la fecha");
        fecha = tec.nextLine();
        v1 = new Venta(id, "Fecha");
        for (Producto p : productosComprados) {
            System.out.println("Ingrese cuantos " + p.nombre + " va a comprar");
            cant = tec.nextInt();
            v1.agregarDetalle(new DetalleVenta(p, cant));
        }
        v1.mostrarTicket();
    }
}
