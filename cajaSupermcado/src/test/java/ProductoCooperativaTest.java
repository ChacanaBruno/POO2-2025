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

    @Test
    public void testRegistrarse() {

        ProductoCooperativa producto = new ProductoCooperativa(10.0, 3, "Pan",0.10);

        double precioIndicadoAlCliente = producto.registrarse();

        int stockDespuesDeRegistro = producto.getStock();

        assertEquals(9.0, precioIndicadoAlCliente);
        assertEquals(2, stockDespuesDeRegistro);
    }
}
