package org.nsq.base;

import org.nsq.modelo.Producto;

import java.util.List;

public class Pedido {

    private List<Producto> detallesPedido;

    public static double calcularTotalPedido(List<Producto> productos, double descuento) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }

        double subtotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
        if (subtotal <= 0) {
            throw new IllegalArgumentException("Error: monto inválido");
        }
        return subtotal - (subtotal * (descuento / 100));
    }

    //Nuevo
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            //System.err.println("Error: La cantidad a agregar debe ser positiva.");
            //return false;
            if(cantidad <0){
                throw new IllegalArgumentException("Error: precio no puede ser negativo");
            }
        }
        if (detallesPedido == null) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }
        if (detallesPedido.isEmpty()) {
            throw new IllegalArgumentException("Error: lista vacia");
        }

        if (!producto.isEsActivo()) {
            throw new IllegalArgumentException("Error: producto inactivo");
        }

        for (Producto producto1 : detallesPedido) {
            if (producto1.getSku().equals(producto.getSku())) {//a
                throw new IllegalArgumentException("Error: sku duplicado");
                //return false;
            }
        }

        // Busca si el producto ya existe en la lista
        boolean productoYaExiste = detallesPedido.stream()
                .anyMatch(p -> p.getNombre().equals(producto.getNombre()));
        if (productoYaExiste) {
            return false; // Falla porque ya existe
        } else {
        // Creamos una nueva instancia con la cantidad especificada y la añadimos a la lista
            detallesPedido.add(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
            return true;
        }
    }
    public boolean validarStock(Producto producto) {
        if (detallesPedido == null) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }
        if (detallesPedido.isEmpty()) {
            throw new IllegalArgumentException("Error: lista vacia");
        }
        for (Producto producto1 : detallesPedido) {
            if (producto.getCantidad() <= 0) {//a
                throw new IllegalArgumentException("Error: cantidad no puede ser negativo");
                //return false;
            }
        }
        return true;
    }

}