package Reborn_backend.Backend.presentation.controller.cliente;

import Reborn_backend.Backend.domain.dto.request.cliente.ClienteRequest;
import Reborn_backend.Backend.domain.dto.response.SaldoResponse;
import Reborn_backend.Backend.domain.dto.response.cliente.ClienteResponse;
import Reborn_backend.Backend.domain.dto.response.cliente.MostrarClientesPorEstadoResponse;
import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.use_case.clientes.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    //Dependencia
    private final CrearClienteCase crearClienteCase;
    private final CalcularSaldoClienteCase calcularSaldoClienteCase;
    private final BuscarPorNombreCase buscarPorNombreCase;
    private final MostrarClientesCase mostrarClientesCase;
    private final GetClientByEstado getClientByEstado;

    //Constructor
    public ClienteController(CrearClienteCase crearClienteCase,
                             CalcularSaldoClienteCase calcularSaldoClienteCase,
                             BuscarPorNombreCase buscarPorNombreCase,
                             MostrarClientesCase mostrarClientesCase,
                             GetClientByEstado getClientByEstado) {
        this.crearClienteCase = crearClienteCase;
        this.calcularSaldoClienteCase = calcularSaldoClienteCase;
        this.buscarPorNombreCase = buscarPorNombreCase;
        this.mostrarClientesCase = mostrarClientesCase;
        this.getClientByEstado = getClientByEstado;
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

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> mostrarClientes() {
        List<Clientes> clientes = mostrarClientesCase.mostrarClientes();

        List<ClienteResponse> clienteResponse = clientes.stream()
                .map(cliente -> new ClienteResponse(
                        cliente.getNombre(),
                        cliente.getDescripcion()))
                .toList();

        return ResponseEntity.ok(clienteResponse);
    }

    @GetMapping(params = "nombre")
    public ResponseEntity<List<ClienteResponse>>  buscarPorNombre(@RequestParam String nombre) {
        List<Clientes> clientes = buscarPorNombreCase.buscarPorNombre(nombre);

        List<ClienteResponse> clientesResponse = clientes.stream()
                .map(cliente -> new ClienteResponse(
                        cliente.getNombre(),
                        cliente.getDescripcion()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(clientesResponse);
    }

    @GetMapping("/estado/{id}")
    public ResponseEntity<List<MostrarClientesPorEstadoResponse>> mostrarEstadoPorCliente(@PathVariable Integer id) {
        List<Clientes> clientes = getClientByEstado.mostrarClientesPorEstado(id);

        List<MostrarClientesPorEstadoResponse> mostrarClientesPorEstadoResponse = clientes
                .stream()
                .map(cliente -> new MostrarClientesPorEstadoResponse(
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getDescripcion()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(mostrarClientesPorEstadoResponse);
    }

    @GetMapping("/{id}/saldo")
    public ResponseEntity<SaldoResponse>  getSaldoCliente(@PathVariable Integer id){
        BigDecimal saldo = calcularSaldoClienteCase.calcularSaldoCliente(id);

        SaldoResponse saldoResponse = new SaldoResponse(saldo);

        return ResponseEntity.ok(saldoResponse);
    }
}
