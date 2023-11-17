package com.upc.miskyclothes.interfaceservice;

import com.upc.miskyclothes.entities.Boleta;

import java.util.List;

public interface BoletaService {
    public Boleta register(Boleta boleta);
    public List<Boleta>listBoleta();
    public Boleta updateBoleta(Boleta boleta) throws Exception;
    public Boleta deleteBoleta(Long id) throws Exception;


}
