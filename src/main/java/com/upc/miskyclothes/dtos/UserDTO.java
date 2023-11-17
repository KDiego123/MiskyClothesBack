package com.upc.miskyclothes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class UserDTO {
private Long id;
private Long dni;
private String nombre;
private String apellido;
private String correo;
private Long telefono;
private String clave;

}
