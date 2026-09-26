package Reborn_backend.Backend.domain.use_case.pedido;

import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;


@Service
public class BuscarPedidoCase {
    private final OrderRepository orderRepository;

    public BuscarPedidoCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Pedido buscarPedido(Integer idPedido){
        return orderRepository.findById(idPedido).orElse(null);
    }
}
