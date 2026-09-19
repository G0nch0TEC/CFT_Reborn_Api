package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Clientes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepo {
    @PersistenceContext
    private EntityManager em;

    //Guardar cliente
    public Clientes save(Clientes clientes){
        if (clientes.getcdclient() == null){
            em.persist(clientes);
            return clientes;
        } else {
            return em.merge(clientes);
        }
    }

    // Encontrar por id
    @Transactional(readOnly = true)
    public Optional<Clientes> findbyid(Integer cdclient){
        Clientes clientes = em.find(Clientes.class, cdclient);
        return Optional.ofNullable(clientes);
    }

    // Mostrar todos los clientes
    @Transactional(readOnly = true)
    public List<Clientes> findall() {
        return em.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
    }

    // Eliminar por id
    public void deletebyid(Integer cdclient){
        Clientes clientes = em.find(Clientes.class, cdclient);
        if (clientes != null){
            em.remove(clientes);
        }
    }
}
