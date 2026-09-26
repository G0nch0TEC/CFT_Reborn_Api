package Reborn_backend.Backend.domain.dto.request.detalle_pedido;

public class DetallePedidoRequest {
    private Integer idProducto;
    private Integer cantidad;

    public DetallePedidoRequest() {}

    public DetallePedidoRequest(Integer idProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Integer getIdProducto() {return idProducto;}
    public void setIdProducto(Integer idProducto) {this.idProducto = idProducto;}

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
}