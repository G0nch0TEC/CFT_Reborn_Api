package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Pedido save(Pedido pedido);

    Optional<Pedido> findById(Integer id);

    List<Pedido> findByCliente(Integer idClient);

    BigDecimal sumSubtotalByClient(Integer idCliente);

    void DeleteById(Pedido p);
}
