package com.ista.api_full.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol_compentencia")
public class RolCompetencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol_competencia;
    @Column(nullable = false)
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
