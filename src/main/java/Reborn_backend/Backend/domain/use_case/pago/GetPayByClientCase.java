package Reborn_backend.Backend.domain.use_case.pago;

import Reborn_backend.Backend.domain.entities.Pago;
import Reborn_backend.Backend.domain.repository.PayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPayByClientCase {
    private final PayRepository payRepository;

    public GetPayByClientCase(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    public List<Pago> getPayByClientId(Integer idClient) {
        return payRepository.findByClientId(idClient);
    }
}
