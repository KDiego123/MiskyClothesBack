package com.upc.miskyclothes.service;

import org.springframework.stereotype.Service;

@Service
public class CalcularIGvImpl {

    private static final double TASA_IGV = 0.18;

    public double calcularIGV(double precioBase) {
        return precioBase * TASA_IGV;
    }

    public double calcularPrecioConIGV(double precioBase) {
        return precioBase + calcularIGV(precioBase);
    }
}
