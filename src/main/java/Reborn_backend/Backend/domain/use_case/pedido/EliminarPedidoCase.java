package Reborn_backend.Backend.domain.use_case.pedido;

import Reborn_backend.Backend.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarPedidoCase {
    private final OrderRepository orderRepository;

    public EliminarPedidoCase(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void eliminarPedido(Integer id){
        orderRepository.deleteById(id);
    }
}
