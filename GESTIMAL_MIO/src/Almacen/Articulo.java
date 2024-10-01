package Almacen;

public class Articulo {
    private String codigo;
    private String descripcion;
    private double compra;
    private double venta;
    private int stock;

    public Articulo(String codigo, String descripcion, double compra, double venta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.compra = compra;
        this.venta = venta;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setCompra(double compra) {
        this.compra = compra;
    }


    public void setVenta(double venta) {
        this.venta = venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", compra=" + compra +
                ", venta=" + venta +
                ", stock=" + stock +
                '}';
    }
}
