package Reborn_backend.Backend.presentation.controller.producto;

import Reborn_backend.Backend.domain.dto.request.producto.ProductoRequest;
import Reborn_backend.Backend.domain.dto.response.producto.ProductoResponse;
import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.use_case.producto.CrearProductoCase;
import Reborn_backend.Backend.domain.use_case.producto.GetProductByCatalogCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final CrearProductoCase crearProductoCase;
    private final GetProductByCatalogCase getProductByCatalogCase;

    public ProductoController(CrearProductoCase crearProductoCase, GetProductByCatalogCase getProductByCatalogCase){
        this.crearProductoCase = crearProductoCase;
        this.getProductByCatalogCase = getProductByCatalogCase;
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@RequestBody ProductoRequest productoRequest){

        Producto producto = new Producto();
        producto.setNombre(productoRequest.getNombre());
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());

        Producto productoGuardado = crearProductoCase.crearProducto(producto, productoRequest.getIdCategoria());

        ProductoResponse productoResponse = new ProductoResponse(
                productoGuardado.getKeyproduct(),
                productoGuardado.getNombre(),
                productoGuardado.getDescripcion(),
                productoGuardado.getPrecio()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(productoResponse);
    }

    @GetMapping("/categoria/{idcat}")
    public ResponseEntity<List<ProductoResponse>> obtenerProductosPorCategoria(@PathVariable Integer idcat) {
        List<Producto> productos = getProductByCatalogCase.getProductByCatalog(idcat);

        List<ProductoResponse> productoResponses = productos.stream()
                .map(producto -> new ProductoResponse(producto.getKeyproduct(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(productoResponses);
    }
}
