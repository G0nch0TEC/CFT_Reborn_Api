package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ky_Estado")
    private Integer kyestado;

    @Column(name = "Ky_Nombre", length = 50)
    private String kynombre;

    @Column(name = "estado", nullable = false)
    private Byte estado = 1;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Clientes> clientes;
}