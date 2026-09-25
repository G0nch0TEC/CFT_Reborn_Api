package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @Column(name = "cat_nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "cat_estado", nullable = false)
    private Byte estado = 1;

    // Foreign Key
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Producto> productos;

    // Getter and setter

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Byte getEstado() {return estado;}
    public void setEstado(Byte estado) {this.estado = estado;}

    public List<Producto> getProductos() {return productos;}
}
