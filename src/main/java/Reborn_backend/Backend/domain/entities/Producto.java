package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Categoria", nullable = false)
    private Categoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KeyProduct", nullable = false)
    private Integer keyproduct;

    @Column(name = "Nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "Descripcion", length = 150)
    private String descripcion;

    @Column(name = "Precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "estado", nullable = false)
    private Byte estado = 1;

    // Foreign Key
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Detalle_Pedido> detalle_pedidos;

    // Getter and setter
    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

    public Integer getKeyproduct() {return keyproduct;}
    public void setKeyproduct(Integer keyproduct) {this.keyproduct = keyproduct;}

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
