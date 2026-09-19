package Reborn_backend.Backend.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class Detalle_Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KyDetalle", nullable = false)
    private Integer kydetalle;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PedidoKey")
    private Pedido pedido;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductKey")
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "Precio_Unit", nullable = false, precision = 10, scale = 2)
    private BigDecimal preciounit;

    @Column(name = "SubTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    // Getter and setter
    public Integer getKydetalle() {return kydetalle;}
    public void setKydetalle(Integer kydetalle) {this.kydetalle = kydetalle;}

    public Pedido getPedido() {return pedido;}
    public void setPedido(Pedido pedido) {this.pedido = pedido;}

    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}

    public BigDecimal getPreciounit() {return preciounit;}
    public void setPreciounit(BigDecimal preciounit) {this.preciounit = preciounit;}

    public BigDecimal getSubtotal() {return subtotal;}
    public void setSubtotal(BigDecimal subtotal) {this.subtotal = subtotal;}
}
