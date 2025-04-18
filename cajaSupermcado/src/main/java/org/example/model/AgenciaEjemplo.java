package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class AgenciaEjemplo implements Agencia {

    private List<Factura> facturas;
    /* clase creada solo a modo de ejemplo para los test*/

    public AgenciaEjemplo() {
        facturas = new ArrayList<Factura>();
    }
    @Override
    public void registrarPago(Factura factura) {
        facturas.add(factura);
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}
