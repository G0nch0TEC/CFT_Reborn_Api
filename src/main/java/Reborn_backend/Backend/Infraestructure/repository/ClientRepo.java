package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ClientRepo implements ClientRepository {
    @PersistenceContext
    private EntityManager em;

    //Guardar cliente
    @Override
    public Clientes save(Clientes clientes){
        if (clientes.getId() == null){
            em.persist(clientes);
            return clientes;
        } else {
            return em.merge(clientes);
        }
    }

    // Mostrar todos los clientes
    @Override
    public List<Clientes> findall() {
        return em.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
    }

    //Buscar por nombre
    @Override
    public List<Clientes> findByNombre(String nombre){
        return em.createQuery("SELECT c FROM Clientes c WHERE c.nombre LIKE :nombre", Clientes.class)
                .setParameter("nombre", "%"+nombre+"%")
                .getResultList();
    }

    //Buscar por estado
    @Override
    public List<Clientes> findByEstado(Integer idEstado){
        return em.createQuery("SELECT c FROM Clientes c WHERE c.estado.id = :id", Clientes.class)
                .setParameter("id", idEstado).getResultList();
    }

    //Eliminar por id
    @Override
    public void deleteById(Integer id){
        Clientes clientes = em.find(Clientes.class, id);
        if (clientes != null){
            em.remove(clientes);
        }
    }
}
