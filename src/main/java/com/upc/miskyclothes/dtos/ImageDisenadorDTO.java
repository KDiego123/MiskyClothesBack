package com.upc.miskyclothes.dtos;
import lombok.Data;

@Data
public class ImageDisenadorDTO {
    private Long id;
    private String filename;
    private byte[] imageData; // Datos binarios de la imagen

}
