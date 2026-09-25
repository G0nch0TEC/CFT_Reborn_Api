package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Detalle_Pedido;

import java.util.List;

public interface DetailOrderRepository {

    Detalle_Pedido save(Detalle_Pedido dp);

    List<Detalle_Pedido> findByPedido(Integer idPedido);

    void DeleteById(Detalle_Pedido dp);
}
