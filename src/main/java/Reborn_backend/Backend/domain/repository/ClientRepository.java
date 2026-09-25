package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Clientes;

import java.util.List;

public interface ClientRepository {

    Clientes save(Clientes clientes);

    List<Clientes> findall();

    List<Clientes> findByNombre(String nombre);

    List<Clientes> findByEstado(Integer estado);

    void deleteById(Integer id);
}