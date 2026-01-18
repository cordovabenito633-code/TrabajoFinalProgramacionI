
package proyectoProgramacionI;

public class Producto {
    double precio;
    String nombre, marca;
    int stock;
    
    //Constructor de la clase producto:
    public Producto (double precio, String nombre, String marca, int stock){
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
    
    //
}
