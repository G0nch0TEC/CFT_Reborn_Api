package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Pago;

import java.util.List;
import java.util.Optional;

public interface PayRepository {

    public Pago save(Pago pago);

    public List<Pago> findByClientId(Integer idClient);

    public Optional<Pago> findById(Integer id);

    public void deleteById(Integer id);
}
