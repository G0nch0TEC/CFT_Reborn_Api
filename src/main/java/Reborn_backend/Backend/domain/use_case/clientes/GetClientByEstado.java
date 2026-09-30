package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientByEstado {
    private final ClientRepository clientRepository;

    public GetClientByEstado(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Clientes> mostrarClientesPorEstado(Integer idEstado) {
        return clientRepository.findByEstado(idEstado);
    }
}
