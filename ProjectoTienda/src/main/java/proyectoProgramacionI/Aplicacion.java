package proyectoProgramacionI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion{
  public static void main(String[] args) {
    Aplicacion ap;
    ap=new Aplicacion();
    ArrayList<Producto> arr1;
    arr1=ap.ingresarProducto();
    ap.mostrarVoleta(arr1);
  }

  public boolean preguntarFin(){
    Scanner tec;
    String respuesta;
    boolean estado;
    tec=new Scanner(System.in);
    System.out.println("Desea ingresar mas productos (si o no)");
    respuesta = new String(tec.nextLine());
    if(respuesta.trim().toLowerCase() == "si"){
      estado = true;
    }else{
      estado = false;
    }
    return estado;
  }

  public ArrayList<Producto> ingresarProducto(){
    Scanner tec;
    ProductoNacional p1;
    ProductoImportado p2;
    String nomProducto,marca,tipoProducto;
    boolean estado;
    double precio,impuestos;
    int stock;
    ArrayList<Producto> productosComprados;

    productosComprados = new ArrayList<>();
    tec = new Scanner(System.in);

    do{
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
      if (tipoProducto.trim().toLowerCase() == "producto importado") {
        impuestos = tec.nextDouble();
        p2 = new ProductoImportado(precio, tipoProducto, marca, stock, estado, impuestos);
        productosComprados.add(p2);
      } else {
        p1 = new ProductoNacional(precio, nomProducto, marca, stock, estado); 
        productosComprados.add(p1);
      }
    } while(preguntarFin());
    return productosComprados;
  }

  public void mostrarVoleta(ArrayList<Producto> productosComprados){
    Venta v1;
    int cant, id;
    Scanner tec;
    String fecha;

    tec = new Scanner(System.in);
    System.out.println("Ingrese el ID");
    id = tec.nextInt();
    System.out.println("Ingrese la fecha");
    fecha = tec.nextLine();
    v1 = new Venta(id,"Fecha");
    for (Producto p : productosComprados) {
      System.out.println("Ingrese cuantos "+ p.nombre +" va a comprar");
      cant = tec.nextInt();
      v1.agregarDetalle(new DetalleVenta(p, cant));
    }
    v1.mostrarTicket();
  }
}