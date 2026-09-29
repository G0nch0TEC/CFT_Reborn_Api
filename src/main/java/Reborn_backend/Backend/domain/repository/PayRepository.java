package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Pago;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PayRepository {

     Pago save(Pago pago);

     List<Pago> findByClientId(Integer idClient);

     Optional<Pago> findById(Integer id);

     void deleteById(Integer id);

     void actualizarPago(Integer idPago, BigDecimal monto);

     BigDecimal sumMontoByClient(Integer idCliente);
}
