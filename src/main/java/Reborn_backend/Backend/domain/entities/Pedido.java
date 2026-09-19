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

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientKey", nullable = false)
    private Clientes cliente;

    @Column(name="FechaPedido", updatable = false, nullable = false)
    private LocalDateTime fechapedido;

    // Getter and setter
    public Integer getKypedido() {return kypedido;}
    public void setKypedido(Integer kypedido) {this.kypedido = kypedido;}

    public Clientes getCliente() {return cliente;}
    public void setCliente(Clientes cliente) {this.cliente = cliente;}

    public LocalDateTime getFechapedido() {return fechapedido;}
}
