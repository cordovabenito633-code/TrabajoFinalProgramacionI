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
    ap.Vendiendo(arr1);
  }

  boolean preguntarProductos(){
    Scanner tec;
    tec=new Scanner(System.in);
    String pregunta;
    boolean estado;
    System.out.println("Desea Ingresar mas productos"+ " Si"+ " O" + " No");
    pregunta=tec.nextLine();
    if(pregunta=="Si"){
      estado=true;
    }else{
      estado=false;
    }
    return estado;
  }


  ArrayList<Producto> ingresarProducto(){
    Scanner tec;
    ProductoNacional p1;
    ProductoImportado p2;
    String nomProducto,marca,tipoProducto;
    boolean estado;
    double precio,impuestos;
    int stock;
    ArrayList<Producto> arr;
    arr=new ArrayList<>();
    tec=new Scanner(System.in);
    do{
      System.out.println("Ingresa el tipo de producto Producto Nacional o Producto Importado");
      tipoProducto=tec.nextLine();
      System.out.println("Ingrese el nombre del producto");
      nomProducto=tec.nextLine();
      System.out.println("Ingrese la marca del producto");
      marca=tec.nextLine();
      System.out.println("Ingrese el precio del producto");
      precio=tec.nextDouble();
      System.out.println("Ingrese la cantidad de productos que quedan");
      stock=tec.nextInt();
      System.out.println("Ingrese si el producto sigue disponible o no"+ " True o False");
      estado=tec.nextBoolean();
      if (tipoProducto=="Producto Importado") {
        impuestos=tec.nextDouble();
        p2=new ProductoImportado(precio, tipoProducto, marca, stock, estado, impuestos);
        arr.add(p2);
      }else{
        p1=new ProductoNacional(precio,nomProducto,marca,stock,estado); 
        arr.add(p1);
      }
    }while(preguntarProductos()==true);
    return arr;
  }

  ArrayList<ProductoImportado> ingresarProductoImportado(){
    Scanner tec;
    ProductoImportado p1;
    String nomProducto,marca;
    boolean estado;
    double precio,impuesto;
    int stock;
    ArrayList<ProductoImportado> arr;
    arr=new ArrayList<>();
    tec=new Scanner(System.in);
    do{
      nomProducto=tec.nextLine();
      marca=tec.nextLine();
      precio=tec.nextDouble();
      stock=tec.nextInt();
      estado=tec.nextBoolean();
      impuesto=tec.nextDouble();
      p1=new ProductoImportado(precio,nomProducto,marca,stock,estado,impuesto); 
      arr.add(p1);
    }while(preguntarProductos());
    return arr;
  }

  void Vendiendo(ArrayList<Producto> arr){
    Venta V1;
    int n,Id;
    Scanner tec;
    String fecha;
    tec=new Scanner(System.in);
    System.out.println("Ingrese el ID");
    Id=tec.nextInt();
    System.out.println("Ingrese la fecha");
    fecha=tec.nextLine();
    V1=new Venta(Id,"Fecha");
    for (int i=0;i<arr.size();i++) {
      System.out.println("Ingrese cuantos "+ arr.get(i).nombre +"Va a comprar");
      n=tec.nextInt();
      V1.agregarDetalle(new DetalleVenta(arr.get(i), n));
    }
    V1.mostrarTicket();
  }
}