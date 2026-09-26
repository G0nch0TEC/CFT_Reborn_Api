package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Producto save(Producto producto);

    List<Producto> findAll();

    List<Producto> findByCategoria(Integer categoria);

    public Optional<Producto> findById(Integer id);

    void deleteById(Integer id);
}
