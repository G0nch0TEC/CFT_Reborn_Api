package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="clientes")
public class Clientes {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserKey", nullable = false)
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_Client")
    private Integer cdclient;

    @Column(name = "CL_name", nullable = false, length = 50)
    private String clname;

    @Column(name = "CL_descripcion", length = 150)
    private String cldescripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CL_estado", nullable = false)
    private Estado estado;

    @Column(name="Fecha_create", updatable = false, nullable = false)
    private LocalDateTime fechacreate;

    @Column(name="Fecha_Update", nullable = false)
    private LocalDateTime fechaupdate;
}
