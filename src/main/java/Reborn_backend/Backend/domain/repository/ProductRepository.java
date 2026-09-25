package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Producto;

import java.util.List;

public interface ProductRepository {

    Producto save(Producto producto);

    List<Producto> findAll();

    List<Producto> findByCategoria(Integer categoria);

    void deleteById(Integer id);
}
