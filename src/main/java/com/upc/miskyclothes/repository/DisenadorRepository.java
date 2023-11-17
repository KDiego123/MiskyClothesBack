package com.upc.miskyclothes.repository;

import com.upc.miskyclothes.entities.Disenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisenadorRepository extends JpaRepository<Disenador,Long> {
    @Query("SELECT d FROM Disenador d ORDER BY d.calificacion DESC")
    List<Disenador> encontrarDisenadorConMayorCalificacion();
    @Query("select d from Disenador d where d.nombre like %:prefix%")
    public List<Disenador> findByNameDisenadorStartingWith(String prefix);
}
