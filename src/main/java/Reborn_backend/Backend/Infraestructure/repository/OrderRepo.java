package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Detalle_Pedido;
import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    //Guardar pedido
    @Override
    public Pedido save(Pedido pedido) {
        if (pedido.getId() == null) {
            em.persist(pedido);
            return pedido;
        } else {
            return em.merge(pedido);
        }
    }

    //Encontrar por id
    @Override
    public Optional<Pedido> findById(Integer id) {
        Pedido pedido = em.find(Pedido.class, id);
        return Optional.ofNullable(pedido);
    }

    //Encontrar por cliente
    @Override
    public List<Pedido> findByCliente(Integer idCliente) {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.cliente.id = :id",  Pedido.class)
                .setParameter("id", idCliente).getResultList();
    }

    // Sumar sub total por cliente
    @Override
    public BigDecimal sumSubtotalByClient(Integer idCliente) {
        return em.createQuery("SELECT COALESCE(SUM(dp.subtotal), 0) FROM Detalle_Pedido dp WHERE dp.pedido.cliente.id = :idCliente", BigDecimal.class)
                .setParameter("idCliente", idCliente).getSingleResult();
    }

    //Eliminar por id
    @Override
    public void DeleteById(Pedido p){
        Pedido pedido = em.find(Pedido.class, p.getId());
        if (pedido!=null){
            em.remove(pedido);
        }
    }
}
