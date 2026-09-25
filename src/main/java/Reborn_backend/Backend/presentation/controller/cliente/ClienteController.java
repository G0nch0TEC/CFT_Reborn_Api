package Reborn_backend.Backend.presentation.controller.cliente;

import Reborn_backend.Backend.domain.dto.request.cliente.ClienteRequest;
import Reborn_backend.Backend.domain.dto.response.cliente.ClienteResponse;
import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.use_case.clientes.CrearClienteCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    //Dependencia
    private final CrearClienteCase crearClienteCase;

    //Constructor
    public ClienteController(CrearClienteCase crearClienteCase) {
        this.crearClienteCase = crearClienteCase;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse>  crearCliente(@RequestBody ClienteRequest clienteRequest) {

        Clientes clientes = new Clientes();
        clientes.setNombre(clienteRequest.getNombre());
        clientes.setDescripcion(clienteRequest.getDescripcion());

        Clientes createClient = crearClienteCase.CrearCliente(clientes);

        ClienteResponse clienteResponse = new ClienteResponse(
                createClient.getNombre(),
                createClient.getDescripcion()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }
}
