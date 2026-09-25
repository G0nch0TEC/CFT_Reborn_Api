package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id", nullable = false)
    private Integer id;

    @Column(name = "est_nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "est_estado", nullable = false)
    private Byte estado = 1;

    // Foreign Key
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Clientes> clientes;

    // Getter and setter


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Byte getEstado() {return estado;}
    public void setEstado(Byte estado) {this.estado = estado;}

    public List<Clientes> getClientes() {return clientes;}
}