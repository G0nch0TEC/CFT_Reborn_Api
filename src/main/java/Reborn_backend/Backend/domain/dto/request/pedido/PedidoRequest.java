package Reborn_backend.Backend.domain.dto.request.pedido;

import Reborn_backend.Backend.domain.dto.request.detalle_pedido.DetallePedidoRequest;
import Reborn_backend.Backend.domain.entities.Detalle_Pedido;

import java.util.List;

public class PedidoRequest {
    private Integer idCliente;
    private List<DetallePedidoRequest> detalles;

    public PedidoRequest() {}

    public PedidoRequest(Integer idCliente, List<DetallePedidoRequest> detalles) {
        this.idCliente = idCliente;
        this.detalles = detalles;
    }

    public Integer getIdCliente() {return idCliente;}
    public void setIdCliente(Integer idCliente) {this.idCliente = idCliente;}

    public List<DetallePedidoRequest> getDetalles() {return detalles;}
    public void setDetalles(List<DetallePedidoRequest> detalles) {this.detalles = detalles;}
}
