package com.ista.api_full.entity;

import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;
    @Column(nullable = false)
    private String ruc;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Double descuento;
    @Column(nullable = false)
    private Double total;

    @OneToMany(mappedBy = "factura_item", cascade = CascadeType.ALL)
    private List<ItemFactura> items_factura;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago")
    private TipoPago tipo_pago_factura;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona_factura;
}
