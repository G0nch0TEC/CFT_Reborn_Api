package Reborn_backend.Backend.presentation.controller.cliente;

import Reborn_backend.Backend.domain.dto.request.CrearClienteRequest;
import Reborn_backend.Backend.domain.dto.response.CrearClienteResponse;
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

    @PostMapping("/crear")
    public ResponseEntity<CrearClienteResponse>  crearCliente(@RequestBody CrearClienteRequest crearClienteRequest) {

        Clientes clientes = new Clientes();
        clientes.setClname(crearClienteRequest.getNombre());
        clientes.setCldescripcion(crearClienteRequest.getDescripcion());

        Clientes createClient = crearClienteCase.CrearCliente(clientes);

        CrearClienteResponse crearClienteResponse = new CrearClienteResponse(
                createClient.getClname(),
                createClient.getCldescripcion()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(crearClienteResponse);
    }
}
