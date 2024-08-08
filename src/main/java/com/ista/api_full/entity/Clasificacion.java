package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clasificacion;
    @Column(nullable = false)
    private String grupo;

    @OneToMany(mappedBy = "clasificacion_producto", cascade = CascadeType.ALL)
    private List<Producto> productos;

}
