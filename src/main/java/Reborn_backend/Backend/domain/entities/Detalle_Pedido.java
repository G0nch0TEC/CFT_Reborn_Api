package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class Detalle_Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id", nullable = false)
    private Integer id;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "det_ped_id", nullable = false)
    private Pedido pedido;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "det_prod_id", nullable = false)
    private Producto producto;

    @Column(name = "det_cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "det_precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal preciounitario;

    @Column(name = "det_subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    // Getter and setter
    public Integer getId() {return id;}
    public void setId(Integer kydetalle) {this.id = id;}

    public Pedido getPedido() {return pedido;}
    public void setPedido(Pedido pedido) {this.pedido = pedido;}

    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}

    public BigDecimal getPreciounitario() {return preciounitario;}
    public void setPreciounitario(BigDecimal preciounitario) {this.preciounitario = preciounitario;}

    public BigDecimal getSubtotal() {return subtotal;}
    public void setSubtotal(BigDecimal subtotal) {this.subtotal = subtotal;}
}
