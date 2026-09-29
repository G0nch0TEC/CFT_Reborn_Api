package Reborn_backend.Backend.domain.dto.request.pago;

import Reborn_backend.Backend.domain.repository.PayRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarPagoCase {
    private final PayRepository payRepository;

    public EliminarPagoCase(PayRepository payRepository){
        this.payRepository = payRepository;
    }

    public void eliminarPago(Integer id){
        payRepository.deleteById(id);
    }
}
