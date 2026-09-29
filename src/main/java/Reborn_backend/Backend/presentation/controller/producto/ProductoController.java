package Reborn_backend.Backend.presentation.controller.producto;

import Reborn_backend.Backend.domain.dto.request.producto.ActualizarProductoRequest;
import Reborn_backend.Backend.domain.dto.request.producto.ProductoRequest;
import Reborn_backend.Backend.domain.dto.response.producto.ProductoResponse;
import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.use_case.producto.ActualizarProductoCase;
import Reborn_backend.Backend.domain.use_case.producto.CrearProductoCase;
import Reborn_backend.Backend.domain.use_case.producto.EliminarProductoCase;
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
    private final ActualizarProductoCase actualizarProductoCase;
    private final EliminarProductoCase eliminarProductoCase;

    public ProductoController(CrearProductoCase crearProductoCase,
                              GetProductByCatalogCase getProductByCatalogCase,
                              ActualizarProductoCase actualizarProductoCase,
                              EliminarProductoCase eliminarProductoCase){
        this.crearProductoCase = crearProductoCase;
        this.getProductByCatalogCase = getProductByCatalogCase;
        this.actualizarProductoCase = actualizarProductoCase;
        this.eliminarProductoCase = eliminarProductoCase;
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@RequestBody ProductoRequest productoRequest){

        Producto producto = new Producto();
        producto.setNombre(productoRequest.getNombre());
        producto.setPrecio(productoRequest.getPrecio());

        Producto productoGuardado = crearProductoCase.crearProducto(producto, productoRequest.getIdCategoria());

        ProductoResponse productoResponse = new ProductoResponse(
                productoGuardado.getId(),
                productoGuardado.getNombre(),
                productoGuardado.getPrecio()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(productoResponse);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProductoResponse>> obtenerProductosPorCategoria(@PathVariable Integer id) {
        List<Producto> productos = getProductByCatalogCase.getProductByCatalog(id);

        List<ProductoResponse> productoResponses = productos.stream()
                .map(producto -> new ProductoResponse(producto.getId(), producto.getNombre(), producto.getPrecio()))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(productoResponses);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> actualizarProducto(@PathVariable Integer id,
                                                   @RequestBody ActualizarProductoRequest request){
        actualizarProductoCase.actualizarProducto(
                id,
                request.getNombre(),
                request.getPrecio()
        );

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id){
        eliminarProductoCase.eliminarProducto(id);

        return ResponseEntity.noContent().build();
    }
}
