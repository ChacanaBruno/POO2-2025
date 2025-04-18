
import org.example.model.AgenciaEjemplo;
import org.example.model.Impuesto;
import org.example.model.Servicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImpuestoTest {
    private Impuesto impuesto;
    private AgenciaEjemplo agencia;

    @BeforeEach
    public void setUp() {
        agencia = new AgenciaEjemplo();

    }

    @Test
    public void constructorImpuesto() {

        impuesto = new Impuesto(agencia, 10.0);

        assertEquals(10.0, impuesto.getTasaDeServicio());
    }
}
