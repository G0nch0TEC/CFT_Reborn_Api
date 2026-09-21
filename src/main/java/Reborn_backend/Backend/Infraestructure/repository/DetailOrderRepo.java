package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Detalle_Pedido;
import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.repository.DetailOrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailOrderRepo implements DetailOrderRepository {
    @PersistenceContext
    private EntityManager em;

    //Guardar detalle pedido
    @Override
    public Detalle_Pedido save(Detalle_Pedido dp){
        if (dp.getKydetalle()==null){
            em.persist(dp);
            return dp;
        } else  {
            return em.merge(dp);
        }
    }

    //Encontrar por pedido
    @Override
    public List<Detalle_Pedido> findByCliente(Integer kypedido) {
        return em.createQuery("SELECT dp FROM Detalle_Pedido dp WHERE dp.pedido.kypedido = :kypedido",  Detalle_Pedido.class)
                .setParameter("kypedido", kypedido).getResultList();
    }

    //Eliminar por id
    @Override
    public void DeleteById(Detalle_Pedido dp){
        Detalle_Pedido detalle_pedido = em.find(Detalle_Pedido.class, dp.getKydetalle());
        if (detalle_pedido!=null){
            em.remove(detalle_pedido);
        }
    }
}
