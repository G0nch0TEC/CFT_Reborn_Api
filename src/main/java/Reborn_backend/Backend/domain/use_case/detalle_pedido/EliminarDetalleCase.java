package Reborn_backend.Backend.domain.use_case.detalle_pedido;

import Reborn_backend.Backend.domain.repository.DetailOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarDetalleCase {
    private final DetailOrderRepository detailOrderRepository;

    public EliminarDetalleCase(DetailOrderRepository detailOrderRepository){
        this.detailOrderRepository = detailOrderRepository;
    }

    public void eliminarDetalle(Integer idCliente){
        detailOrderRepository.deleteById(idCliente);
    }
}
