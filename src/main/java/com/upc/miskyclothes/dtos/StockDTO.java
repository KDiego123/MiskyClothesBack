package com.upc.miskyclothes.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StockDTO {
    private Long id;
    private boolean disponibilidad;
    private Integer cantidad_disponible;
}
