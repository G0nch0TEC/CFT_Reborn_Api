package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Clientes;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Clientes save(Clientes clientes);

    List<Clientes> findall();

    List<Clientes> findByNombre(String nombre);

    void actualizarEstado(Integer idCliente, Integer idEstado);

    void actualizarCliente(Integer idCliente, String nombre, String descripcion);

    List<Clientes> findByEstado(Integer estado);

    Optional<Clientes> findById(Integer id);

    void deleteById(Integer id);
}