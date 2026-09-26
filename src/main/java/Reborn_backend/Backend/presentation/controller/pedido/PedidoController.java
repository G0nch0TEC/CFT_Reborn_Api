package Reborn_backend.Backend.presentation.controller.pedido;

import Reborn_backend.Backend.domain.dto.request.pedido.PedidoRequest;
import Reborn_backend.Backend.domain.dto.response.detalle_pedido.DetallePedidoResponse;
import Reborn_backend.Backend.domain.dto.response.pedido.PedidoResponse;
import Reborn_backend.Backend.domain.entities.Clientes;
import Reborn_backend.Backend.domain.entities.Detalle_Pedido;
import Reborn_backend.Backend.domain.entities.Pedido;
import Reborn_backend.Backend.domain.use_case.clientes.BuscarClienteCase;
import Reborn_backend.Backend.domain.use_case.detalle_pedido.GetDetallePorPedidoCase;
import Reborn_backend.Backend.domain.use_case.pedido.CrearPedidoCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/Pedido"})
public class PedidoController {
    private final CrearPedidoCase crearPedidoCase;
    private final BuscarClienteCase buscarClienteCase;
    private final GetDetallePorPedidoCase getDetallePorPedidoCase;

    public PedidoController(CrearPedidoCase crearPedidoCase, BuscarClienteCase buscarClienteCase, GetDetallePorPedidoCase getDetallePorPedidoCase) {
        this.crearPedidoCase = crearPedidoCase;
        this.buscarClienteCase = buscarClienteCase;
        this.getDetallePorPedidoCase = getDetallePorPedidoCase;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> crearPedido(@RequestBody PedidoRequest pedidoRequest) {
        Clientes cliente = buscarClienteCase.buscarCliente(pedidoRequest.getIdCliente());

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        Pedido pedidoGuardado = crearPedidoCase.crearPedido(
                pedido,
                pedidoRequest
        );

        List<Detalle_Pedido> detalles = getDetallePorPedidoCase.getDetallePorPedido(pedidoGuardado.getId());

        List<DetallePedidoResponse> detallesResponse = detalles.stream()
                .map(detalle -> new DetallePedidoResponse(
                        detalle.getId(),
                        detalle.getProducto().getId(),
                        detalle.getCantidad(),
                        detalle.getPreciounitario(),
                        detalle.getSubtotal()
                ))
                .toList();

        PedidoResponse pedidoResponse = new PedidoResponse(
                pedidoGuardado.getId(),
                pedidoGuardado.getCliente().getId(),
                pedidoGuardado.getFechapedido(),
                detallesResponse
        );
        return ResponseEntity.ok(pedidoResponse);
    }
}
