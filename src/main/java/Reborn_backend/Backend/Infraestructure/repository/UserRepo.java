package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.Optional;

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

    // Encontrar por correo
    public Optional<Usuario> findByCorreo(String correo) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo", Usuario.class)
                .setParameter("correo", correo).getResultStream().findFirst();
    }

    // Verificar si correo ya existe
    public boolean existsByCorreo(String correo) {
        Long count = em.createQuery("SELECT count(u) FROM Usuario u WHERE u.correo = :correo", Long.class)
                .setParameter("correo", correo)
                .getSingleResult();
        return count > 0;
    }
}
