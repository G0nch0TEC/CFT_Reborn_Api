package Reborn_backend.Backend.domain.use_case.detalle_pedido;

import Reborn_backend.Backend.domain.repository.DetailOrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ActualizarDetalleCase {
    private final DetailOrderRepository detailOrderRepository;
    
    public ActualizarDetalleCase(DetailOrderRepository detailOrderRepository){
        this.detailOrderRepository = detailOrderRepository;
    }
    
    public void actualizarDetalle(Integer idDetalle, Integer cantidad){

        if (cantidad == null || cantidad <= 0){
            throw new RuntimeException("La cantidad no puede ser menor a 0");
        }

        detailOrderRepository.actualizarDetalle(idDetalle, cantidad);
    }
}
