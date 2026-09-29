package Reborn_backend.Backend.presentation.controller.detalle_pedido;

import Reborn_backend.Backend.domain.dto.request.detalle_pedido.ActualizarDetalleRequest;
import Reborn_backend.Backend.domain.use_case.detalle_pedido.ActualizarDetalleCase;
import Reborn_backend.Backend.domain.use_case.detalle_pedido.EliminarDetalleCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Detalle")
public class DetallePedidoController {
    private final ActualizarDetalleCase actualizarDetalleCase;
    private final EliminarDetalleCase eliminarDetalleCase;

    public DetallePedidoController(ActualizarDetalleCase actualizarDetalleCase,
                                   EliminarDetalleCase eliminarDetalleCase){
        this.actualizarDetalleCase = actualizarDetalleCase;
        this.eliminarDetalleCase = eliminarDetalleCase;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> actualizarDetallePedido(@PathVariable Integer id,
                                                        @RequestBody ActualizarDetalleRequest request){
        actualizarDetalleCase.actualizarDetalle(
                id,
                request.getCantidad()
        );

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetallePedido(@PathVariable Integer id){
        eliminarDetalleCase.eliminarDetalle(id);

        return ResponseEntity.noContent().build();
    }
}
