package Reborn_backend.Backend.domain.use_case.clientes;

import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.repository.ClientRepository;

import java.util.List;

public class BuscarPorNombreCase {
    private final ClientRepository clientRepository;

    public BuscarPorNombreCase(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Clientes> buscarPorNombre(String nombre){
        return clientRepository.findByNombre(nombre);
    }
}
