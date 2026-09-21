package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Usuario;

import java.util.Optional;

public interface UserRepository {

    Usuario save(Usuario usuario);

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

}
