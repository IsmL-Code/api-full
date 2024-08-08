package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;


@Data
@Entity
@Table(name = "itemfactura")
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item_factura;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Double sub_total;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura_item;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto_item;
}
