package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.entities.Estado;
import Reborn_backend.Backend.domain.repository.ClientRepository;
import Reborn_backend.Backend.domain.repository.StateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrearClienteCase {

    private final ClientRepository clientRepository;
    private final StateRepository stateRepository;

    public CrearClienteCase(ClientRepository clientRepository,
                            StateRepository stateRepository) {
        this.clientRepository = clientRepository;
        this.stateRepository = stateRepository;
    }

    @Transactional
    public Clientes CrearCliente(Clientes cliente){
        Estado estadoInicial = stateRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        cliente.setEstado(estadoInicial);
        return clientRepository.save(cliente);
    }
}
