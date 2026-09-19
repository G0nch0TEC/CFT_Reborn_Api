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
    @Column(name="CD_User", nullable = false)
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

    // Foreign Key
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Clientes> clientes;


    // Getter and Setter
    public Integer getcduser() {return cduser;}
    public void setcduser(Integer cduser) {this.cduser = cduser;}

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Byte getEstado() {return estado;}
    public void setEstado(Byte estado) {this.estado = estado;}

    public LocalDateTime getFechacreate() {return fechacreate;}
    public LocalDateTime getFechaupdate() {return fechaupdate;}

    public List<Clientes> getClientes() {return clientes;}
}
