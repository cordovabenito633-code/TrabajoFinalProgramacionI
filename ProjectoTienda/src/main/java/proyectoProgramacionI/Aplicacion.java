package proyectoProgramacionI;
public class Aplicacion {
  public static void main(String[] args) {
    // 1. Crear productos (Polimorfismo: referencia Producto, instancia Hija)
    Producto p1 = new ProductoNacional(100.0, "Zapatillas", "Tigre", 10, true);
      
    // Laptop cuesta 2000, pero tiene 10% de impuesto por ser importada
    Producto p2 = new ProductoImportado(2000.0, "Laptop Gamer", "Asus", 5, true, 0.10); 

    // 2. Crear Venta
    Venta miVenta = new Venta(1, "18/01/2026");

    // 3. Vender
    // Compramos 2 pares de zapatillas (100 * 2 = 200)
    miVenta.agregarDetalle(new DetalleVenta(p1, 2));
      
    // Compramos 1 laptop (2000 + 10% = 2200)
    miVenta.agregarDetalle(new DetalleVenta(p2, 1));

    // 4. Imprimir
    miVenta.mostrarTicket();
      
    // Total debería ser: 200 + 2200 = 2400
  }
}
