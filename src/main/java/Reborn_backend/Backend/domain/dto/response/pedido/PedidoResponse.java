package Reborn_backend.Backend.domain.dto.response.pedido;

import Reborn_backend.Backend.domain.dto.response.detalle_pedido.DetallePedidoResponse;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponse {
    private Integer idPedido;
    private Integer idCliente;
    private LocalDateTime fechaPedido;
    private List<DetallePedidoResponse> detalles;

    public PedidoResponse() {}

    public PedidoResponse(Integer idPedido, Integer idCliente,
                          LocalDateTime fechaPedido,
                          List<DetallePedidoResponse> detalles) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.fechaPedido = fechaPedido;
        this.detalles = detalles;
    }

    public Integer getIdPedido() {return idPedido;}
    public void setIdPedido(Integer idPedido) {this.idPedido = idPedido;}

    public Integer getIdCliente() {return idCliente;}
    public void setIdCliente(Integer idCliente) {this.idCliente = idCliente;}

    public LocalDateTime getFechaPedido() {return fechaPedido;}
    public void setFechaPedido(LocalDateTime fechaPedido) {this.fechaPedido = fechaPedido;}

    public List<DetallePedidoResponse> getDetalles() {return detalles;}
    public void setDetalles(List<DetallePedidoResponse> detalles) {this.detalles = detalles;}
}