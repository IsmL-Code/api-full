package com.ista.api_full.entity;

import jakarta.persistence.*;
import  lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @Column(nullable = false)
    private String nombreUsuario;
    @Column(nullable = false)
    private String contrasenaUsuario;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona_usuario;

    @OneToMany(mappedBy = "usuario_rol", cascade = CascadeType.ALL)
    private List<UsuarioRol> list_roles_user;
}
