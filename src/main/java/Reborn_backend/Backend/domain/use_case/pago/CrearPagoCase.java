package Reborn_backend.Backend.domain.use_case.pago;

import Reborn_backend.Backend.domain.entities.Pago;
import Reborn_backend.Backend.domain.repository.PayRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearPagoCase {
    private final PayRepository payRepository;

    public CrearPagoCase(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    public Pago crearPago(Pago pago) {
        return payRepository.save(pago);
    }
}
