package com.upc.miskyclothes.repository;

import com.upc.miskyclothes.entities.Polo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoloRepository extends JpaRepository<Polo,Long> {
    @Query("select p from Polo p where p.modelo like %:prefix%")
    public List<Polo> findByNamePoloStartingWith(String prefix);

    List<Polo> findByModelo(String modelo);
    List<Polo> findByTalla(String talla);
    List<Polo> findByColor(String color);
    List<Polo> findByPrecio(long precio);
    @Query("select p from Polo p where p.precio between :minPrice and :maxPrice")
    List<Polo> findByPriceRange(long minPrice, long maxPrice);

    List<Polo> findByFavoritoTrue();

}
