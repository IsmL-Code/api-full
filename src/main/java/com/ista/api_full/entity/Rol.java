package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    @Column(nullable = false)
    private String nombreRol;
    @Column(nullable = false)
    private Boolean estado;


    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<RolCompetencia> roles_competencia_rol;

    @OneToMany(mappedBy = "rol_usuario", cascade = CascadeType.ALL)
    private List<UsuarioRol> list_roles_user;
}
