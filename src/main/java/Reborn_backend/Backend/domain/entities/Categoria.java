package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAT", nullable = false)
    private Integer idcat;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Byte estado = 1;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Producto> productos;
}
