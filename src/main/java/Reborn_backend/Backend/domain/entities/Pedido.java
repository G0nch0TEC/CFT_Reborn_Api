package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KyPedido", nullable = false)
    private Integer kypedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientKey", nullable = false)
    private Clientes cliente;

    @Column(name="FechaPedido", updatable = false, nullable = false)
    private LocalDateTime fechapedido;
}
