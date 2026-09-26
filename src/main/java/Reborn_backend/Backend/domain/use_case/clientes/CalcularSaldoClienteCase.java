package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.repository.OrderRepository;
import Reborn_backend.Backend.domain.repository.PayRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalcularSaldoClienteCase {
    private final PayRepository payRepository;
    private final OrderRepository orderRepository;

    public CalcularSaldoClienteCase(PayRepository payRepository, OrderRepository orderRepository) {
        this.payRepository = payRepository;
        this.orderRepository = orderRepository;
    }

    public BigDecimal calcularSaldoCliente(Integer id) {

        BigDecimal totalPedidos = orderRepository.sumSubtotalByClient(id);

        BigDecimal totalPagos = payRepository.sumMontoByClient(id);

        return totalPedidos.subtract(totalPagos);
    }
}
