package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Producto save(Producto producto);

    List<Producto> findAll();

    List<Producto> findByCategoria(Integer categoria);

    Optional<Producto> findById(Integer id);

    void actualizarProducto(Integer idProducto, String nombre, BigDecimal precio);

    void deleteById(Integer id);
}
