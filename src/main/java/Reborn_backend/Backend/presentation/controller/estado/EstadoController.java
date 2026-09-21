package Reborn_backend.Backend.presentation.controller.estado;

import Reborn_backend.Backend.domain.dto.response.EstadoResponse;
import Reborn_backend.Backend.domain.entities.Estado;
import Reborn_backend.Backend.domain.use_case.estado.ObtenerEstadosCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/estado")
public class EstadoController {

    private final ObtenerEstadosCase obtenerEstadosCase;

    public EstadoController(ObtenerEstadosCase obtenerEstadosCase) {
        this.obtenerEstadosCase = obtenerEstadosCase;
    }

    @GetMapping
    public ResponseEntity<List<EstadoResponse>> obtenerEstados(){

        List<Estado> estados = obtenerEstadosCase.obtenerEstados();

        List<EstadoResponse> estadosResponse = estados.stream()
                .map(estado -> new EstadoResponse(estado.getKynombre()))
                .toList();

        return ResponseEntity.ok(estadosResponse);
    }
}
