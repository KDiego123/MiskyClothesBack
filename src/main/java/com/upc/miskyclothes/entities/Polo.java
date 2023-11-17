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
@Table(name="polos")

public class Polo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="modelo",length = 60,nullable = true)
    private String modelo;
    private boolean favorito;
    private String talla;
    private String color;
    private long precio;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Image.class )
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

   @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="stock_id")
    private Stock stocks;

}

