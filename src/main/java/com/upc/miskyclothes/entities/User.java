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
@Table(name="usuarios")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String tipo;

    @Column(name="dni",length = 8,nullable = false,unique = true)
    private Long  dni;

    @Column(name = "telefono", length = 9, nullable = false, unique = true)
    private Long telefono;

    @Column(name = "clave", nullable = false, unique = true)
    private String clave;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuarios_id")
    private List<Pedido> pedidos;

}
