import org.example.model.ProductoEmpresa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoEmpresaTest {
    private ProductoEmpresa productoEmpresa;

    @BeforeEach
    public void setUp() {
        productoEmpresa = new ProductoEmpresa(10.0,2,"Cereal");
    }

    @Test
    public void crearProductoEmpresa() {

        assertEquals("Cereal", productoEmpresa.getNombre());
        assertEquals(10.0, productoEmpresa.getPrecio());
        assertEquals(2, productoEmpresa.getStock());
    }

    @Test
    public void disminuirStock() {

        productoEmpresa.disminuirStock();

        assertEquals(1.0, productoEmpresa.getStock() );
    }

    @Test
    void cuandoUnProductoSeRegistraDisminuyeSuStock() {
        ProductoEmpresa productoRegistra = new ProductoEmpresa(5.0,2,"Pan");

        productoRegistra.registrarse();

        assertEquals(1, productoRegistra.getStock() );
    }

    @Test void cuandoUnProductoEmpresaIndicaSuMontoEsIgualASuPrecioBase() {

        assertEquals(productoEmpresa.getPrecio(), productoEmpresa.indicarMonto());

    }
}
