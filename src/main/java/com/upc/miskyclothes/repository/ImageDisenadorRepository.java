package com.upc.miskyclothes.repository;

import com.upc.miskyclothes.entities.Image;
import com.upc.miskyclothes.entities.ImageDisenador;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface ImageDisenadorRepository extends JpaRepository<ImageDisenador, Long> {
    public ImageDisenador findImageById(Long id);
}
