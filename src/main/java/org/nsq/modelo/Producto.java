package org.nsq.modelo;

public class Producto {
    //Atributos
    private String nombre;
    private double precio;
    private int cantidad;
    private String sku;
    private String categoria;
    private boolean esActivo;
    private boolean descuento;

    public Producto(String nombre, double precio, int cantidad, String sku, String categoria, boolean esActivo, boolean descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.sku = sku;
        this.categoria = categoria;
        this.esActivo = esActivo;
        this.descuento = descuento;
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if(precio<0){
            throw new IllegalArgumentException("Error: precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        if(cantidad<0){
            throw new IllegalArgumentException("Error: cantidad no puede ser negativo");
        }
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
