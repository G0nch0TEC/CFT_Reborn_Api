package Reborn_backend.Backend.presentation.controller.categoria;

import Reborn_backend.Backend.domain.dto.request.categoria.CategoriaRequest;
import Reborn_backend.Backend.domain.dto.response.categoria.CategoriaResponse;
import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.use_case.categoria.CrearCategoriaCase;
import Reborn_backend.Backend.domain.use_case.categoria.ObtenerCategoriaCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CrearCategoriaCase crearCategoriaCase;
    private final ObtenerCategoriaCase obtenerCategoriaCase;

    public CategoriaController(CrearCategoriaCase crearCategoriaCase, ObtenerCategoriaCase obtenerCategoriaCase){
        this.crearCategoriaCase = crearCategoriaCase;
        this.obtenerCategoriaCase = obtenerCategoriaCase;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> crearCategoria(@RequestBody CategoriaRequest categoriaRequest) {

        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequest.getNombre());

        Categoria crearCategoria = crearCategoriaCase.crearCategoria(categoria);

        CategoriaResponse categoriaResponse = new CategoriaResponse(
                crearCategoria.getId(),
                crearCategoria.getNombre()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponse);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listarCategoria() {
        List<Categoria> categorias = obtenerCategoriaCase.obtenerCategorias();

        List<CategoriaResponse> categoriasResponse = categorias.stream()
                .map(categoria -> new CategoriaResponse(categoria.getId(), categoria.getNombre()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(categoriasResponse);
    }
}
