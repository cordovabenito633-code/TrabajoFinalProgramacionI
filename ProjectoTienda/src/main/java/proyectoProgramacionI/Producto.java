
package proyectoProgramacionI;

public abstract class Producto implements Vendible{
    protected double precio;
    protected String nombre, marca;
    protected int stock;
    protected boolean estado;
    
    //Constructor de la clase producto:
    public Producto (double precio, String nombre, String marca, int stock, boolean estado){
        this.precio = precio;
        this.nombre = nombre;
        this.marca = marca;
        this.stock = stock;
        this.estado = estado;
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
            stock = stock + cantidad;
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
    @Override
    public void mostrarDetalles(){
        System.out.println("--- Producto: " + nombre + " ---");
        System.out.println("Marca: " + marca + ".");
        System.out.println("Precio: " + precio + " soles.");
        System.out.println("Stock: " + stock + " unidades.");
        if(estado){
            System.out.println("El producto SI esta disponible.");
        }
        else{
            System.out.println("El producto NO esta disponible.");
        }
    }

    public abstract double calcularPrecioVenta();
}
