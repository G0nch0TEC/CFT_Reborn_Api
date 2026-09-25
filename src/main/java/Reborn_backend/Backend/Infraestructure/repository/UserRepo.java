package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Usuario;
import Reborn_backend.Backend.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public class UserRepo implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    // Guardar Usuario
    @Override
    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null){
            em.persist(usuario);
            return usuario;
        } else {
            return em.merge(usuario);
        }
    }

    // Encontrar por correo
    @Override
    public Optional<Usuario> findByEmail(String email) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                .setParameter("email", email).getResultStream().findFirst();
    }

    // Verificar si correo ya existe
    @Override
    public boolean existsByEmail(String email) {
        Long count = em.createQuery("SELECT count(u) FROM Usuario u WHERE u.email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }
}
