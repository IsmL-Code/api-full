package com.ista.api_full.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario_rol;
    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario_rol;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol_usuario;
}
