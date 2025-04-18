package org.example.model;

import java.util.List;

public class Caja {


    public double registrar(Registrable registrable) {

        registrable.registrarse();

        return registrable.indicarMonto();
    }

    public double registrar(List<Registrable> registrables) {
        double montoTotal = 0;
        for (Registrable registrable : registrables) {
            montoTotal = registrar(registrable) + montoTotal;
        }
        return montoTotal;
    }
}
