package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Categoria save(Categoria categoria);

    List<Categoria> findAll();

    Optional<Categoria> findById(Integer idcat);

    boolean existsByNombre(String nombre);

    void deleteById(Integer idcat);
}
