package com.upc.miskyclothes.service;

import com.upc.miskyclothes.entities.Disenador;
import com.upc.miskyclothes.interfaceservice.DisenadorService;
import com.upc.miskyclothes.repository.DisenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisenadorServiceImpl implements DisenadorService{
     @Autowired
    private DisenadorRepository disenadorRepository;
     public Disenador register(Disenador disenador){return disenadorRepository.save(disenador);}
     public List<Disenador> listDisenador() {return disenadorRepository.findAll();}
    @Override
    public List<Disenador> listByName(String prefix) {
        return disenadorRepository.findByNameDisenadorStartingWith(prefix);
    }
}
