package com.upc.miskyclothes.dtos;


import com.upc.miskyclothes.entities.Image;
import lombok.Data;

@Data
public class PoloDTO {
    private Long id;
    private String modelo;
    private boolean favorito;
    private String talla;
    private String color;
    private long precio;
    private ImageDTO image;
}
