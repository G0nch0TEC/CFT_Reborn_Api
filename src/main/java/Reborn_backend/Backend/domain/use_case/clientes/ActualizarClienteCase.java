package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarClienteCase {
    private final ClientRepository clientRepository;

    public ActualizarClienteCase(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public void actualizarCliente(Integer idCliente, String nombre, String descripcion){
        clientRepository.actualizarCliente(idCliente, nombre, descripcion);
    }
}
