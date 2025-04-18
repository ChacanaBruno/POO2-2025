import org.example.model.AgenciaEjemplo;
import org.example.model.Factura;
import org.example.model.Servicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicioTest {
    private Servicio servicio;

    @BeforeEach
    public void setUp() {
        AgenciaEjemplo agencia = new AgenciaEjemplo();

        servicio = new Servicio(agencia,1.0, 3.0);
    }

    @Test
    public void constructorServicio() {

        AgenciaEjemplo agencia = new AgenciaEjemplo();

        Servicio servicioEjemplo = new Servicio(agencia,1.0, 3.0);

        assertEquals(agencia, servicioEjemplo.getAgenciaEjemplo());

        assertEquals(1.0,servicioEjemplo.getCostoPorUnidad());

        assertEquals(3.0, servicioEjemplo.getCantidadConsumida());

    }

    @Test
    public void cuandoUnServicioIndicaSuMontoEsLaMultiplicacionDeSusAtributos() {

        double multiplicacion = servicio.getCantidadConsumida() * servicio.getCostoPorUnidad();

        assertEquals(multiplicacion, servicio.indicarMonto());
    }

    @Test
    public void cuandoUnServicioSeRegistraLaAgenciaTieneUnaFacturaEnSuLista() {
        /*test a modo de ejemplo para verificar que el mensaje llega*/

        AgenciaEjemplo CABA = new AgenciaEjemplo();

        Servicio servicioCaba = new Servicio(CABA,1.0, 3.0);

        servicioCaba.registrarse();

        List<Factura> facturasEjemplo = CABA.getFacturas();

        assertEquals(1, facturasEjemplo.size());
    }
}
