package com.upc.miskyclothes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedidos")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private Integer tiempo_aprox;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="polos_id")
    private List<Polo> polos;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
   @JoinColumn(name="boleta_id")//
    private Boleta boletas;//
}
