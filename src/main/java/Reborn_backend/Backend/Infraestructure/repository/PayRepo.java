package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.entities.Pago;
import Reborn_backend.Backend.domain.repository.PayRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class PayRepo implements PayRepository {
    @PersistenceContext
    private EntityManager em;

    //Guardar un pago
    @Override
    public Pago save(Pago pago){
        if(pago.getId() == null){
            em.persist(pago);
        } else {
            em.merge(pago);
        }
        return pago;
    }

    //Encontrar por cliente
    @Override
    public List<Pago> findByClientId(Integer idClient){
        return em.createQuery("SELECT p FROM Pago p WHERE p.cliente.id = :id",  Pago.class)
                .setParameter("id", idClient).getResultList();
    }

    //Encontrar por id
    @Override
    public Optional<Pago> findById(Integer id){
        Pago pago = em.find(Pago.class, id);
        return Optional.ofNullable(pago);
    }

    //Eliminar por id
    @Override
    public void deleteById(Integer id) {
        Pago pago = em.find(Pago.class, id);
        if (pago != null) {
            em.remove(pago);
        }
    }
}
