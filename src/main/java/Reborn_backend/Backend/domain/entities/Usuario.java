package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CD_User")
    private Integer cduser;

    @Column(name="Usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name="User_Email", nullable = false, length = 120, unique = true)
    private String correo;

    @Column(name="Password", nullable = false, length = 255)
    private String password;

    @Column(name = "Estado", nullable = false)
    private Byte estado = 1;

    @Column(name="Fecha_create", updatable = false, nullable = false)
    private LocalDateTime fechacreate;

    @Column(name="Fecha_Update", nullable = false)
    private LocalDateTime fechaupdate;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Clientes> clientes;
}
