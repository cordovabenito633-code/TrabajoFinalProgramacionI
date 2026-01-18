
package proyectoProgramacionI;

public class Producto {
    double precio;
    String nombre, marca;
    int stock;
    boolean estado;
    
    //Constructor de la clase producto:
    public Producto (double precio, String nombre, String marca, int stock, boolean estado){
        this.precio = precio;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
    }
    
    //Métodos getters:
    public double getPrecio(){
        return precio;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public int getStock(){
        return stock;
    }
    
    //Métodos setters:
    public void setPrecio(double precio){
        if(precio>0){
            this.precio = precio;
        }   
    }
    
    public void setStock(int stock){
        if(stock>0){
            this.stock = stock;
        }
    }
    
    //Metodos del Negocio:
    public void aumentarStock(int cantidad){
        if(cantidad>0){
            stock = stock+cantidad;
        }
    }
    
    public void reducirStock(int cantidad){
        if(cantidad>0 && stock>=cantidad){
            stock = stock - cantidad;
        }
    }
    
    //Cambio de estado de un producto
    public void activar(){
        estado = true;
    }
    
    public void desactivar(){
        estado = false;
    }
    
    //Mostrar el producto y sus atributos:
    public void mostrar(){
        System.out.println("Nombre del producto: "+nombre);
        System.out.println("Marca del producto: "+marca);
        System.out.println("Precio del producto: "+precio+" soles.");
        System.out.println("Stock del producto: "+stock+" unidades.");
        if(estado==true){
            System.out.println("El producto SI se vende actualmente.");
        }
        else{
            System.out.println("El producto NO se vende actualmente.");
        }
    }
}
