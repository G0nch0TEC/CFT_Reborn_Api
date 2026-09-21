package Reborn_backend.Backend.domain.repository;

import Reborn_backend.Backend.domain.entities.Estado;

import java.util.List;
import java.util.Optional;

public interface StateRepository {

    List<Estado> findAll();

    Optional<Estado> findById(Integer kyestado);
}
