package Reborn_backend.Backend.domain.dto.request.detalle_pedido;

public class ActualizarDetalleRequest {
    private Integer cantidad;

    public ActualizarDetalleRequest() {}

    public ActualizarDetalleRequest(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}
}
