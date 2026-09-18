package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Categoria", nullable = false)
    private Categoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KeyProduct", nullable = false)
    private Integer keyproduct;

    @Column(name = "Nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "Descripcion", length = 150)
    private String descripcion;

    @Column(name = "Precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "estado", nullable = false)
    private Byte estado = 1;
}
