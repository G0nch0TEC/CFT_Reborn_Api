package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    @PersistenceContext
    private EntityManager em;


    // Guardar Usuario
    public Usuario save(Usuario usuario) {
        if (usuario.getcduser() == null){
            em.persist(usuario);
            return usuario;
        } else {
            return em.merge(usuario);
        }
    }
}
