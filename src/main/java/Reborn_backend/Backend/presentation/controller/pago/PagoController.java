package Reborn_backend.Backend.presentation.controller.pago;

import Reborn_backend.Backend.domain.dto.request.pago.ActualizarPagoRequest;
import Reborn_backend.Backend.domain.dto.request.pago.EliminarPagoCase;
import Reborn_backend.Backend.domain.dto.request.pago.PagoRequest;
import Reborn_backend.Backend.domain.dto.response.pago.PagoResponse;
import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.entities.Pago;
import Reborn_backend.Backend.domain.use_case.clientes.BuscarClienteCase;
import Reborn_backend.Backend.domain.use_case.pago.ActualizarPagoCase;
import Reborn_backend.Backend.domain.use_case.pago.CrearPagoCase;
import Reborn_backend.Backend.domain.use_case.pago.GetPayByClientCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {
    private final CrearPagoCase crearPagoCase;
    private final BuscarClienteCase buscarClienteCase;
    private final GetPayByClientCase getPayByClientCase;
    private final ActualizarPagoCase actualizarPagoCase;
    private final EliminarPagoCase eliminarPagoCase;

    public PagoController(CrearPagoCase crearPagoCase,
                          BuscarClienteCase buscarClienteCase,
                          GetPayByClientCase getPayByClientCase,
                          ActualizarPagoCase actualizarPagoCase,
                          EliminarPagoCase eliminarPagoCase) {
        this.crearPagoCase = crearPagoCase;
        this.buscarClienteCase = buscarClienteCase;
        this.getPayByClientCase = getPayByClientCase;
        this.actualizarPagoCase = actualizarPagoCase;
        this.eliminarPagoCase = eliminarPagoCase;
    }

    @PostMapping
    public ResponseEntity<PagoResponse> crearPago(@RequestBody PagoRequest pagoRequest){

        Clientes clientes = buscarClienteCase.buscarCliente(pagoRequest.getIdCliente());

        Pago pago = new Pago();
        pago.setCliente(clientes);
        pago.setMonto(pagoRequest.getMonto());

        Pago pagoCreado = crearPagoCase.crearPago(pago);

        PagoResponse pagoResponse = new PagoResponse(
                pagoCreado.getMonto(),
                pagoCreado.getFecha()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoResponse);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PagoResponse>> obtenerPagosCliente(@PathVariable Integer id){

        List<Pago> pagos = getPayByClientCase.getPayByClientId(id);

        List<PagoResponse> pagoResponse = pagos.stream()
                .map(pago -> new PagoResponse(
                        pago.getMonto(),
                        pago.getFecha()
                ))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(pagoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> actualizarPago(@PathVariable Integer id, ActualizarPagoRequest request){
        actualizarPagoCase.actualizarPago(
                id,
                request.getMonto()
        );

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Integer id){
        eliminarPagoCase.eliminarPago(id);

        return ResponseEntity.noContent().build();
    }
}
