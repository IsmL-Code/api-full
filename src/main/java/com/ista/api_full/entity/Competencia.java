package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;


@Data
@Entity
@Table(name = "competencia")
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_competencia;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "competencia", cascade = CascadeType.ALL)
    private List<RolCompetencia> roles_competencia;


}
