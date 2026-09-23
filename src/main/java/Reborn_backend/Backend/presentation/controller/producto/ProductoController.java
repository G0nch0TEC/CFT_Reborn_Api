package Reborn_backend.Backend.presentation.controller.producto;

import Reborn_backend.Backend.domain.dto.request.producto.ProductoRequest;
import Reborn_backend.Backend.domain.dto.response.producto.ProductoResponse;
import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.use_case.producto.CrearProductoCase;
import Reborn_backend.Backend.domain.use_case.producto.ObtenerProductoCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final CrearProductoCase crearProductoCase;
    private final ObtenerProductoCase obtenerProductoCase;

    public ProductoController(CrearProductoCase crearProductoCase, ObtenerProductoCase obtenerProductoCase){
        this.crearProductoCase = crearProductoCase;
        this.obtenerProductoCase = obtenerProductoCase;
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
    public ResponseEntity<List<ProductoResponse>> obtenerProducto(@PathVariable Integer idcat) {
        List<Producto> productos = obtenerProductoCase.obtenerProductos();

        List<ProductoResponse> productoResponses = productos.stream()
                .map(producto -> new ProductoResponse(producto.getKeyproduct(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(productoResponses);
    }
}
