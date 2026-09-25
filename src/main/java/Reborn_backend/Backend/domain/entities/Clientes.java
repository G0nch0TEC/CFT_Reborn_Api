package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Clientes {

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_usr_id", nullable = false)
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id", nullable = false)
    private Integer id;

    @Column(name = "cli_nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "cli_descripcion", length = 150)
    private String descripcion;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cli_estado_id", nullable = false)
    private Estado estado;

    @Column(name = "cli_fecha_creacion", updatable = false, nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "cli_fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    // Foreign Key
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "pago", fetch = FetchType.LAZY)
    private List<Pago>  pagos;

    // Getters y Setters
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Estado getEstado() {return estado;}
    public void setEstado(Estado estado) {this.estado = estado;}

    public LocalDateTime getFechaCreacion() {return fechaCreacion;}
    public LocalDateTime getFechaActualizacion() {return fechaActualizacion;}

    public List<Pedido> getPedidos() {return pedidos;}
    public List<Pago> getPagos() {return pagos;}
}