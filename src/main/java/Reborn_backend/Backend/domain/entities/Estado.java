package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ky_Estado", nullable = false)
    private Integer kyestado;

    @Column(name = "Ky_Nombre", length = 50, nullable = false)
    private String kynombre;

    @Column(name = "estado", nullable = false)
    private Byte estado = 1;

    // Foreign Key
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Clientes> clientes;

    // Getter and setter

    public Integer getKyestado() {return kyestado;}
    public void setKyestado(Integer kyestado) {this.kyestado = kyestado;}

    public String getKynombre() {return kynombre;}
    public void setKynombre(String kynombre) {this.kynombre = kynombre;}

    public Byte getEstado() {return estado;}
    public void setEstado(Byte estado) {this.estado = estado;}

    public List<Clientes> getClientes() {return clientes;}
}