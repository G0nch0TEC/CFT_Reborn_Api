package Reborn_backend.Backend.domain.use_case.pedido;

import Reborn_backend.Backend.domain.dto.request.detalle_pedido.DetallePedidoRequest;
import Reborn_backend.Backend.domain.dto.request.pedido.PedidoRequest;
import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import Reborn_backend.Backend.domain.repository.OrderRepository;
import Reborn_backend.Backend.domain.use_case.clientes.CambiarEstadoClienteCase;
import Reborn_backend.Backend.domain.use_case.detalle_pedido.CrearDetalleCase;
import org.springframework.stereotype.Service;

@Service
public class CrearPedidoCase {
    private final OrderRepository orderRepository;
    private final CrearDetalleCase crearDetalleCase;
    private final CambiarEstadoClienteCase cambiarEstadoClienteCase;

    public CrearPedidoCase(OrderRepository orderRepository,
                           CrearDetalleCase crearDetalleCase,
                           CambiarEstadoClienteCase cambiarEstadoClienteCase) {
        this.orderRepository = orderRepository;
        this.crearDetalleCase = crearDetalleCase;
        this.cambiarEstadoClienteCase = cambiarEstadoClienteCase;
    }

    public Pedido crearPedido(Pedido pedido, PedidoRequest pedidoRequest) {

        // Guardamos el pedido
        Pedido pedidoGuardado = orderRepository.save(pedido);

        // Creamos y guardamos los detalles
        for (DetallePedidoRequest detalleRequest : pedidoRequest.getDetalles()) {
            crearDetalleCase.crearDetalle(detalleRequest, pedidoGuardado);
        }

        cambiarEstadoClienteCase.cambiarEstadoCliente(pedido.getCliente().getId());
        return pedidoGuardado;
    }
}
