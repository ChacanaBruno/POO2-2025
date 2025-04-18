import org.example.model.ProductoCooperativa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoCooperativaTest {
    private ProductoCooperativa productoCooperativa;

    @BeforeEach
    public void setUp() {
        productoCooperativa = new ProductoCooperativa(10.0, 5, "Pan",0.10);
    }

    @Test
    public void testProductoCooperativa() {
        assertEquals(10.0, productoCooperativa.getPrecio());
        assertEquals(5, productoCooperativa.getStock());
        assertEquals(0.10, productoCooperativa.getDescuento());
    }

    @Test
    public void testPrecioConDescuento() {
        assertEquals(9.0, productoCooperativa.precioConDescuento());
    }

    @Test void cuandoUnProductoCooperativaIndicaSuMontoEsIgualASuPrecioConDescuento() {
        assertEquals(productoCooperativa.precioConDescuento(), productoCooperativa.indicarMonto());
    }

}
