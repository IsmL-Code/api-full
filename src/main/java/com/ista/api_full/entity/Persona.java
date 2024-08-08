package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private String correo;

    @OneToMany(mappedBy = "persona_factura", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    @OneToMany(mappedBy = "persona_usuario", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

}
