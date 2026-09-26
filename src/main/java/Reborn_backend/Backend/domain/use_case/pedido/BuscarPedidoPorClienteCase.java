package Reborn_backend.Backend.domain.use_case.pedido;

import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarPedidoPorClienteCase {
    private final OrderRepository orderRepository;

    public BuscarPedidoPorClienteCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Pedido> BuscarPedidoPorCliente(Integer idCliente) {
        return orderRepository.findByCliente(idCliente);
    }
}
