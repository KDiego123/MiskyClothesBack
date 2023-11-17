package com.upc.miskyclothes.service;

import com.upc.miskyclothes.entities.Polo;
import com.upc.miskyclothes.interfaceservice.PoloService;
import com.upc.miskyclothes.repository.PoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoloServiceImpl implements PoloService {
    @Autowired
    private PoloRepository poloRepository;

    public Polo register(Polo polo) {
        return poloRepository.save(polo);
    }

    public List<Polo> listPolos() {
        return poloRepository.findAll();
    }

    public Polo updatePolo(Polo polo) throws Exception {
        poloRepository.findById(polo.getId()).orElseThrow(() -> new Exception("No se encontró entidad"));
        return poloRepository.save(polo);
    }

    public Polo deletePolo(Long id) throws Exception {
        Polo polo = poloRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        poloRepository.delete(polo);
        return polo;
    }

    @Override
    public List<Polo> listByName(String prefix) {
        return poloRepository.findByNamePoloStartingWith(prefix);
    }

    @Override
    public List<Polo> findByPriceRange(long minPrice, long maxPrice) {
        return poloRepository.findByPriceRange(minPrice, maxPrice);
    }

    public List<Polo> findFavoritos() {
        return poloRepository.findByFavoritoTrue();}
}
