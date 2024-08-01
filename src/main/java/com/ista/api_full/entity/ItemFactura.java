package com.ista.api_full.entity;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "itemfactura")
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
