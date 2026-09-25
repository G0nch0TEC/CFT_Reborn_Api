package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pago_id", nullable = false)
    private Integer id;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pago_cli_id", nullable = false)
    private Clientes cliente;

    @Column(name = "pago_monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "pago_fecha", nullable = false)
    private LocalDateTime fecha;

    // Getters y Setters

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Clientes getCliente() {return cliente;}
    public void setCliente(Clientes cliente) {this.cliente = cliente;}

    public BigDecimal getMonto() {return monto;}
    public void setMonto(BigDecimal monto) {this.monto = monto;}

    public LocalDateTime getFecha() {return fecha;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
}