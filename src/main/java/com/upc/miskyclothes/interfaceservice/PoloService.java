package com.upc.miskyclothes.interfaceservice;

import com.upc.miskyclothes.entities.Polo;

import java.util.List;

public interface PoloService {
public Polo register(Polo polo);
public List<Polo>listPolos();
public Polo updatePolo(Polo polo) throws Exception;
public Polo deletePolo(Long id) throws Exception;

List<Polo>listByName(String prefix);
List<Polo> findByPriceRange(long minPrice, long maxPrice);

List<Polo> findFavoritos();

}
