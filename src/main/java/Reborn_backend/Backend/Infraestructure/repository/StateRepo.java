package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateRepo {
    @PersistenceContext
    private EntityManager em;

    //Mostrar Estados
    public List<Estado> findAll() {
        return em.createQuery("SELECT e FROM Estado e", Estado.class).getResultList();
    }
}
