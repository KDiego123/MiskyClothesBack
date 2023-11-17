package com.upc.miskyclothes.repository;
import com.upc.miskyclothes.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
@Transactional
public interface ImageRepository extends JpaRepository<Image, Long> {
    public Image findImageById(Long id);
}
