package Reborn_backend.Backend.domain.use_case.estado;

import Reborn_backend.Backend.domain.entities.Estado;
import Reborn_backend.Backend.domain.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerEstadosCase {

    private final StateRepository stateRepository;

    public ObtenerEstadosCase(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<Estado> obtenerEstados() {
        return stateRepository.findAll();
    }
}
