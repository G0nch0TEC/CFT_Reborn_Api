package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_cat_id", nullable = false)
    private Categoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id", nullable = false)
    private Integer id;

    @Column(name = "prod_nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "prod_descripcion", length = 150)
    private String descripcion;

    @Column(name = "prod_precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "prod_estado", nullable = false)
    private Byte estado = 1;

    // Foreign Key
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Detalle_Pedido> detalle_pedidos;

    // Getter and setter
    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public BigDecimal getPrecio() {return precio;}
    public void setPrecio(BigDecimal precio) {this.precio = precio;}

    public Byte getEstado() {return estado;}
    public void setEstado(Byte estado) {this.estado = estado;}

    public List<Detalle_Pedido> getDetalle_pedidos() {return detalle_pedidos;}
}
