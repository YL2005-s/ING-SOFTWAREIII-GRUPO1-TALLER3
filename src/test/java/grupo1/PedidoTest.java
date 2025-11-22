package grupo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nsq.base.Pedido;
import org.nsq.modelo.Producto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @BeforeEach
    void setUp() {
        List<Producto> detallespedidos = List.of(
                new Producto("Laptop", 2500, 1, "123","ti", true,true),
                new Producto("Mini Pc", 2500, 1, "123","ti", true,true),
                new Producto("Telefono", 2500, 1, "123","ti", true,true),
                new Producto("Mouse", 100, 2)
        );
    }

    @Test
    void testListaVacia() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> Pedido.calcularTotalPedido(List.of(), 10));
        assertEquals("Error: no hay productos en el pedido", ex.getMessage());
    }

    @Test
    void testListaNula() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> Pedido.calcularTotalPedido(null, 10));
        assertEquals("Error: no hay productos en el pedido", ex.getMessage());
    }

    @Test
    void testSubtotalCero() {
        List<Producto> productos = List.of(new Producto("Libro", 0, 1));
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> Pedido.calcularTotalPedido(productos, 10));
        assertEquals("Error: monto inválido", ex.getMessage());
    }

    @Test
    void testDescuentoValido() {
        List<Producto> productos = List.of(new Producto("Galletita", 100, 2));
        double total = Pedido.calcularTotalPedido(productos, 10);
        assertEquals(180.0, total);
    }

    @Test
    void testDescuentoCero() {
        List<Producto> productos = List.of(new Producto("Galletota", 100, 2));
        double total = Pedido.calcularTotalPedido(productos, 0);
        assertEquals(200.0, total);
    }

    @Test
    void testMultiplesProductos() {
        List<Producto> productos = List.of(
                new Producto("Leche", 50, 2),
                new Producto("Harina", 100, 1)
        );
        double total = Pedido.calcularTotalPedido(productos, 10);
        assertEquals(180.0, total);
    }

    @Test
    void testSkuDuplicado() {
        List<Producto> detallespedidos = List.of(
                new Producto("Laptop", 2500, 1, "123","ti", true,true),
                new Producto("Mini Pc", 2500, 1, "123","ti", true,true),
                new Producto("Telefono", 2500, 1, "123","ti", true,true),
                new Producto("Mouse", 100, 2)
        );
        assertThrows(IllegalArgumentException.class, () -> Pedido.agregarProducto((Producto) detallespedidos, 10));
    }
}
