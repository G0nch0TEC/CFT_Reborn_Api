package Reborn_backend.Backend.presentation.controller.cliente;

import Reborn_backend.Backend.domain.dto.request.cliente.ClienteRequest;
import Reborn_backend.Backend.domain.dto.response.SaldoResponse;
import Reborn_backend.Backend.domain.dto.response.cliente.ClienteResponse;
import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.use_case.clientes.CalcularSaldoClienteCase;
import Reborn_backend.Backend.domain.use_case.clientes.CrearClienteCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    //Dependencia
    private final CrearClienteCase crearClienteCase;
    private final CalcularSaldoClienteCase calcularSaldoClienteCase;

    //Constructor
    public ClienteController(CrearClienteCase crearClienteCase,
                             CalcularSaldoClienteCase calcularSaldoClienteCase) {
        this.crearClienteCase = crearClienteCase;
        this.calcularSaldoClienteCase = calcularSaldoClienteCase;
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

    @GetMapping("/{id}/saldo")
    public ResponseEntity<SaldoResponse>  saldoCliente(@PathVariable Integer id){
        BigDecimal saldo = calcularSaldoClienteCase.calcularSaldoCliente(id);

        SaldoResponse saldoResponse = new SaldoResponse(saldo);

        return ResponseEntity.ok(saldoResponse);
    }
}
