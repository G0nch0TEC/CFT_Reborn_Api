package Reborn_backend.Backend.domain.use_case.pago;

import Reborn_backend.Backend.domain.repository.PayRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ActualizarPagoCase {
    private final PayRepository payRepository;

    public ActualizarPagoCase(PayRepository payRepository){
        this.payRepository = payRepository;
    }

    public void actualizarPago(Integer idPago, BigDecimal nuevoPago){

        if (nuevoPago == null || nuevoPago.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("El nuevo pago no puede ser menor a 0");
        }

        payRepository.actualizarPago(idPago, nuevoPago);
    }
}
