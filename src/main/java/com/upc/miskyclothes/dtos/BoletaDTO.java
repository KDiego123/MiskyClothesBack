package com.upc.miskyclothes.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class BoletaDTO {
    private Long id;
    private Date fecha_pedido;
    private String direccion;
}
