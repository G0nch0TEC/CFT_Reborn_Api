package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarClienteCase {
    private final ClientRepository clientRepository;

    public EliminarClienteCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void eliminarCliente(Integer id){
        clientRepository.deleteById(id);
    }
}
