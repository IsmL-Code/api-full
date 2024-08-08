package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private Double precio_unitario;
    @Column(nullable = false)
    private String unidad;
    @Column(nullable = false)
    private Boolean iva;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion")
    private Clasificacion clasificacion_producto;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedor_producto;

    @OneToMany(mappedBy = "producto_item", cascade = CascadeType.ALL)
    private List<ItemFactura> items_factura;

}
