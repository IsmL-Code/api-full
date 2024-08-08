package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "tipopago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_pago;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipo_pago_factura", cascade = CascadeType.ALL)
    private List<Factura> facturas;

}
