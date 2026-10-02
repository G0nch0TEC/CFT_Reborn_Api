package Reborn_backend.Backend.domain.dto.request.pago;

import Reborn_backend.Backend.domain.repository.PayRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EliminarPagoCase {
    private final PayRepository payRepository;

    public EliminarPagoCase(PayRepository payRepository){
        this.payRepository = payRepository;
    }

    @Transactional
    public void eliminarPago(Integer id){
        payRepository.deleteById(id);
    }
}
