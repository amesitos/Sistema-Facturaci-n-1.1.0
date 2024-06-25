package ec.edu.pucem.facturacion.models;

public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private double iva;
    private double totalIva;
    private double total;

    public Producto() {
        
    }

    // Getters y setters para producto
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        calcularTotalIva(); // Recalcula el total del IVA cuando se establece el precio
        calcularTotal(); // Recalcula el total cuando se establece el precio
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
        calcularTotalIva(); // Recalcula el total del IVA cuando se establece el IVA
        calcularTotal(); // Recalcula el total cuando se establece el IVA
    }

    public double getTotalIva() {
        return totalIva;
    }

    public double getTotal() {
        return total;
    }

    // Función para calcular el total del iva del producto
    private void calcularTotalIva() {
        this.totalIva = this.precio * this.iva;
    }

    // Función para calcular el total del producto
    private void calcularTotal() {
        this.total = (this.precio + this.totalIva) * this.cantidad;
    }
}
