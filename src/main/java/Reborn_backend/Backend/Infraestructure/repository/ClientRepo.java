package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Clientes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

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

    // Mostrar todos los clientes
    public List<Clientes> findall() {
        return em.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
    }

    //Buscar por nombre
    public List<Clientes> findByNombre(String nombre){
        return em.createQuery("SELECT c FROM Clientes c WHERE c.clname LIKE :clname", Clientes.class)
                .setParameter("clname", "%"+nombre+"%")
                .getResultList();
    }

    //Buscar por estado
    public List<Clientes> findByEstado(Integer kyestado){
        return em.createQuery("SELECT c FROM Clientes c WHERE c.estado.kyestado = :kyestado", Clientes.class)
                .setParameter("kyestado", kyestado).getResultList();
    }

    //Eliminar por id
    public void deleteById(Integer cdclient){
        Clientes clientes = em.find(Clientes.class, cdclient);
        if (clientes != null){
            em.remove(clientes);
        }
    }
}
