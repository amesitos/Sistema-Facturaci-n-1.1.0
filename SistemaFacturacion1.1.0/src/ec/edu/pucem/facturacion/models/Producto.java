package ec.edu.pucem.facturacion.models;

public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private double iva;
    private double totalIva;
    private double total;

    public Producto() {}

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
        calcularTotal(); // Recalcula el total cuando se establece la cantidad
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
        this.totalIva = round(this.precio * this.iva, 2);
    }

    // Función para calcular el total del producto
    private void calcularTotal() {
        this.total = round((this.precio + this.totalIva) * this.cantidad, 2);
    }

    // Método para redondear un valor a un número específico de decimales
    private double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
