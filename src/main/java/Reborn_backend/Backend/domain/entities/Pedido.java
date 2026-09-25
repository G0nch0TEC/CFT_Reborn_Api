package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id", nullable = false)
    private Integer id;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ped_cli_id", nullable = false)
    private Clientes cliente;

    @Column(name="ped_fecha", updatable = false, nullable = false)
    private LocalDateTime fechapedido;

    // Getter and setter
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Clientes getCliente() {return cliente;}
    public void setCliente(Clientes cliente) {this.cliente = cliente;}

    public LocalDateTime getFechapedido() {return fechapedido;}
}
