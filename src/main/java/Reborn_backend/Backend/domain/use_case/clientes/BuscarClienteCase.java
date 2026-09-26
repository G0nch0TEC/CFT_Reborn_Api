package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarClienteCase {
    private final ClientRepository clientRepository;

    public BuscarClienteCase(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Clientes buscarCliente(Integer id){
        return clientRepository.findById(id).orElse(null);
    }
}
