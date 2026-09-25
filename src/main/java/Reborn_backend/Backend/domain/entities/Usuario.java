package Reborn_backend.Backend.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usr_id", nullable = false)
    private Integer id;

    @Column(name="usr_nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name="usr_email", nullable = false, length = 120, unique = true)
    private String email;

    @Column(name="usr_password", nullable = false, length = 255)
    private String password;

    @Column(name = "usr_estado", nullable = false)
    private Byte estado = 1;

    @Column(name="usr_fecha_creacion", updatable = false, nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name="usr_fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    // Foreign Key
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Clientes> clientes;


    // Getter and Setter
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String usuario) {this.nombre = nombre;}

    public String getEmail() {return email;}
    public void setEmail(String correo) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Byte getEstado() {return estado;}
    public void setEstado(Byte estado) {this.estado = estado;}

    public LocalDateTime getFechaCreacion() {return fechaCreacion;}
    public LocalDateTime getFechaActualizacion() {return fechaActualizacion;}

    public List<Clientes> getClientes() {return clientes;}
}
