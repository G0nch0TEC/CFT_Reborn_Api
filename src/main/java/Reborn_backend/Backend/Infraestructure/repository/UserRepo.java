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
        if (usuario.getcduser() == null){
            em.persist(usuario);
            return usuario;
        } else {
            return em.merge(usuario);
        }
    }

    // Encontrar por correo
    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo", Usuario.class)
                .setParameter("correo", correo).getResultStream().findFirst();
    }

    // Verificar si correo ya existe
    @Override
    public boolean existsByCorreo(String correo) {
        Long count = em.createQuery("SELECT count(u) FROM Usuario u WHERE u.correo = :correo", Long.class)
                .setParameter("correo", correo)
                .getSingleResult();
        return count > 0;
    }
}
