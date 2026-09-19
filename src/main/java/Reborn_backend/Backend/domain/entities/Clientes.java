package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="clientes")
public class Clientes {

    //Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserKey", nullable = false)
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_Client", nullable = false)
    private Integer cdclient;

    @Column(name = "CL_name", nullable = false, length = 50)
    private String clname;

    @Column(name = "CL_descripcion", length = 150)
    private String cldescripcion;

    //Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CL_estado", nullable = false)
    private Estado estado;

    @Column(name="Fecha_create", updatable = false, nullable = false)
    private LocalDateTime fechacreate;

    @Column(name="Fecha_Update", nullable = false)
    private LocalDateTime fechaupdate;

    //Foreign Key
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    // Getter and setter
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Integer getcdclient() {return cdclient;}
    public void setcdclient(Integer cdclient) {this.cdclient = cdclient;}

    public String getClname() {return clname;}
    public void setClname(String clname) {this.clname = clname;}

    public String getCldescripcion() {return cldescripcion;}
    public void setCldescripcion(String cldescripcion) {this.cldescripcion = cldescripcion;}

    public Estado getEstado() {return estado;}
    public void setEstado(Estado estado) {this.estado = estado;}

    public LocalDateTime getFechacreate() {return fechacreate;}
    public LocalDateTime getFechaupdate() {return fechaupdate;}

    public List<Pedido> getPedidos() {return pedidos;}
}
