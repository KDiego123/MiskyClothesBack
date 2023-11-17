package com.upc.miskyclothes.service;

import com.upc.miskyclothes.entities.Boleta;
import com.upc.miskyclothes.interfaceservice.BoletaService;
import com.upc.miskyclothes.repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaServiceImpl implements BoletaService {
    @Autowired
    private BoletaRepository boletaRepository;
    public Boleta register(Boleta boleta){return boletaRepository.save(boleta);}
    public List<Boleta> listBoleta(){return boletaRepository.findAll();}
    public Boleta updateBoleta(Boleta boleta) throws Exception{
        boletaRepository.findById(boleta.getId()).orElseThrow(()->new Exception("No se pudo encontrar usuario"));
        return boletaRepository.save(boleta);
    }
    public Boleta deleteBoleta(Long id) throws Exception{
        Boleta boleta=boletaRepository.findById(id).orElseThrow(()->new  Exception("No se pudo encontrar usuario"));
        boletaRepository.delete(boleta);
        return boleta;
    }



}
