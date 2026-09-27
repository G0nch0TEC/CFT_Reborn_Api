package Reborn_backend.Backend.domain.use_case.pago;

import Reborn_backend.Backend.domain.entities.Pago;
import Reborn_backend.Backend.domain.repository.PayRepository;
import Reborn_backend.Backend.domain.use_case.clientes.CambiarEstadoClienteCase;
import org.springframework.stereotype.Service;

@Service
public class CrearPagoCase {
    private final PayRepository payRepository;
    private final CambiarEstadoClienteCase cambiarEstadoClienteCase;

    public CrearPagoCase(PayRepository payRepository,  CambiarEstadoClienteCase cambiarEstadoClienteCase) {
        this.payRepository = payRepository;
        this.cambiarEstadoClienteCase = cambiarEstadoClienteCase;
    }

    public Pago crearPago(Pago pago) {
        cambiarEstadoClienteCase.cambiarEstadoCliente(pago.getCliente().getId());
        return payRepository.save(pago);
    }
}
