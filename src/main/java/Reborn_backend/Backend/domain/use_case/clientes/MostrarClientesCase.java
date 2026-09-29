package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarClientesCase {
    private final ClientRepository clientRepository;

    public MostrarClientesCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Clientes> mostrarClientes(){
        return clientRepository.findall();
    }
}
