import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CajaTest {

    private Caja caja;

    private ProductoEmpresa cereal;

    private ProductoCooperativa pan;

    private Impuesto impuestoLuz;

    private Servicio servicioNetflix;

    private Agencia agencia;
    @BeforeEach
    public void setUp() {
        caja = new Caja();
        cereal = new ProductoEmpresa(10, 5, "Cereal");
        pan = new ProductoCooperativa(15, 4,"Pan", 0.10);

        agencia = new AgenciaEjemplo();
        impuestoLuz = new Impuesto(agencia,120);
        servicioNetflix = new Servicio(agencia, 2,5);

        List<Registrable> comprasEjemplo = new ArrayList<>();

        comprasEjemplo.add(cereal);
        comprasEjemplo.add(pan);
        comprasEjemplo.add(impuestoLuz);
        comprasEjemplo.add(servicioNetflix);
    }

    @Test
    public void registrarUnRegistrableEnCajaIndicaSuMonto() {

        assertEquals(10, caja.registrar(cereal));
    }

    @Test
    public void registrarUnProductoCooperativaeEnCajaIndicaSuMonto() {

        double montoConDescuento = pan.precioConDescuento();

        assertEquals(montoConDescuento, caja.registrar(pan));
    }

    @Test
    public void registrarVariosProductosEnCajaIndicaSuMonto() {

        double precioBase = cereal.indicarMonto();

        double montoConDescuento = pan.precioConDescuento();

        double montoEsperado = precioBase + montoConDescuento;

        List<Registrable> productos = new ArrayList<>();

        productos.add(cereal);
        productos.add(pan);

        assertEquals(montoEsperado, caja.registrar(productos));
    }

    @Test
    public void registrarUnVariosRegistrablesEnCajaIndicaSuMonto() {

        double precioCerial = cereal.indicarMonto();
        double precioPan = pan.indicarMonto();
        double precioLuz = impuestoLuz.indicarMonto();
        double precioNetflix = servicioNetflix.indicarMonto();

        double montoEsperado = precioCerial + precioPan + precioLuz + precioNetflix;

        List<Registrable> registrables = new ArrayList<>();

        registrables.add(cereal);
        registrables.add(pan);
        registrables.add(impuestoLuz);
        registrables.add(servicioNetflix);

        assertEquals(montoEsperado, caja.registrar(registrables));
    }

    @Test
    public void registrarUnProductoEnCajaDisminuyeSuStock() {

        List<Registrable> productos = new ArrayList<>();

        productos.add(cereal);
        productos.add(pan);

        double monto = caja.registrar(productos);

        assertEquals(4, cereal.getStock());
        assertEquals(3, pan.getStock());
    }


    @Test
    public void registrarEnCajaDisminuyeSuStock() {

        double precioCerial = cereal.indicarMonto();
        double precioPan = pan.indicarMonto();
        double precioLuz = impuestoLuz.indicarMonto();
        double precioNetflix = servicioNetflix.indicarMonto();

        double montoEsperado = precioCerial + precioPan + precioLuz + precioNetflix;

        List<Registrable> registrables = new ArrayList<>();

        registrables.add(cereal);
        registrables.add(pan);
        registrables.add(impuestoLuz);
        registrables.add(servicioNetflix);

        assertEquals(montoEsperado, caja.registrar(registrables));

        assertEquals(4, cereal.getStock());
        assertEquals(3, pan.getStock());
    }


}
