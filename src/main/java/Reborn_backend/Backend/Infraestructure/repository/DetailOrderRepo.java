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
        if (dp.getId()==null){
            em.persist(dp);
            return dp;
        } else  {
            return em.merge(dp);
        }
    }

    //Encontrar por pedido
    @Override
    public List<Detalle_Pedido> findByPedido(Integer idPedido) {
        return em.createQuery("SELECT dp FROM Detalle_Pedido dp WHERE dp.pedido.id = :id",  Detalle_Pedido.class)
                .setParameter("id", idPedido).getResultList();
    }

    //Actualizar Detalle
    public void actualizarDetalle(Integer idDetalle, Integer cantidad){
        em.createQuery("UPDATE Detalle_Pedido dp SET dp.cantidad = :cantidad, dp.subtotal = dp.preciounitario * :cantidad WHERE dp.id = :idDetalle")
                .setParameter("idDetalle", idDetalle)
                .setParameter("cantidad", cantidad)
                .executeUpdate();
    }

    //Eliminar por id
    @Override
    public void DeleteById(Integer id){
        Detalle_Pedido detalle_pedido = em.find(Detalle_Pedido.class, id);
        if (detalle_pedido!=null){
            em.remove(detalle_pedido);
        }
    }
}
