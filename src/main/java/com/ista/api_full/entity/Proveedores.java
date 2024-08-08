package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id_proveedor;
    @Column(nullable = false)
    private String ruc;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String moneda;


    @OneToMany(mappedBy = "proveedor_producto", cascade = CascadeType.ALL)
    private List<Producto> productos;
}
