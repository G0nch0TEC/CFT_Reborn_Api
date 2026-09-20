package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {
    @PersistenceContext
    private EntityManager em;

    //Guardar pedido
    public Pedido save(Pedido pedido) {
        if (pedido.getKypedido() == null) {
            em.persist(pedido);
            return pedido;
        } else {
            return em.merge(pedido);
        }
    }

    //Encontrar por id
    public Optional<Pedido> findById(Integer kypedido) {
        Pedido pedido = em.find(Pedido.class, kypedido);
        return Optional.ofNullable(pedido);
    }

    //Encontrar por cliente
    public List<Pedido> findByCliente(Integer cdclient) {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.cliente.cdclient = :cdclient",  Pedido.class)
                .setParameter("cdclient", cdclient).getResultList();
    }
}
