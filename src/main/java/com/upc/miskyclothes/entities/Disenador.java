package com.upc.miskyclothes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disenador")
public class Disenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private int calificacion;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ImageDisenador.class )
    @JoinColumn(name = "imagedisenador_id", referencedColumnName = "id")
    private ImageDisenador imagedisenador;


}
