package com.upc.miskyclothes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Opinon")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private int calificacion;
    @ManyToOne(targetEntity = Polo.class) //se une a usuario
    @JoinColumn(name = "polo_id", referencedColumnName = "id")
    private Polo polo;
}
