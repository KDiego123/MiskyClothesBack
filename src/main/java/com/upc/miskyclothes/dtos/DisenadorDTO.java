package com.upc.miskyclothes.dtos;
import lombok.Data;
@Data
public class DisenadorDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private int calificacion;
    private ImageDisenadorDTO imagedisenador;
}
