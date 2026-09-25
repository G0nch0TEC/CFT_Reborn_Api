package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Estado;
import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StateRepo implements StateRepository {
    @PersistenceContext
    private EntityManager em;

    //Mostrar Estados
    @Override
    public List<Estado> findAll() {
        return em.createQuery("SELECT e FROM Estado e", Estado.class).getResultList();
    }

    //Buscar por id
    public Optional<Estado> findById(Integer id) {
        Estado estado = em.find(Estado.class, id);
        return Optional.ofNullable(estado);
    }
}
