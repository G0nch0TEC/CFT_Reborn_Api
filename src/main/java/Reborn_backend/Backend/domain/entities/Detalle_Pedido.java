package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class Detalle_Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KyDetalle", nullable = false)
    private Integer kydetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PedidoKey")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductKey")
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "Precio_Unit", nullable = false, precision = 10, scale = 2)
    private BigDecimal preciounit;

    @Column(name = "SubTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;
}
