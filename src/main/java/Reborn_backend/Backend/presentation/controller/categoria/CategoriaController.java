package Reborn_backend.Backend.presentation.controller.categoria;

import Reborn_backend.Backend.domain.dto.request.CrearCategoriaRequest;
import Reborn_backend.Backend.domain.dto.response.CrearCategoriaResponse;
import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.use_case.categoria.CrearCategoriaCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CrearCategoriaCase crearCategoriaCase;

    public CategoriaController(CrearCategoriaCase crearCategoriaCase){
        this.crearCategoriaCase = crearCategoriaCase;
    }

    @PostMapping("/crear")
    public ResponseEntity<CrearCategoriaResponse> crearCategoria(@RequestBody CrearCategoriaRequest crearCategoriaRequest) {

        Categoria categoria = new Categoria();
        categoria.setNombre(crearCategoriaRequest.getNombre());

        Categoria crearCategoria = crearCategoriaCase.crearCategoria(categoria);

        CrearCategoriaResponse crearCategoriaResponse = new CrearCategoriaResponse(
                crearCategoria.getNombre()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(crearCategoriaResponse);
    }
}
