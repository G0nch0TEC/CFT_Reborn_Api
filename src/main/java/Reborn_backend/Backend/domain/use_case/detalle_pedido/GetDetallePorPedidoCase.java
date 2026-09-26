package Reborn_backend.Backend.domain.use_case.detalle_pedido;

import Reborn_backend.Backend.domain.entities.Detalle_Pedido;
import Reborn_backend.Backend.domain.repository.DetailOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDetallePorPedidoCase {
    private final DetailOrderRepository detailOrderRepository;

    public GetDetallePorPedidoCase(DetailOrderRepository detailOrderRepository) {
        this.detailOrderRepository = detailOrderRepository;
    }

    public List<Detalle_Pedido> getDetallePorPedido(Integer idPedido){
        return detailOrderRepository.findByPedido(idPedido);
    }
}
