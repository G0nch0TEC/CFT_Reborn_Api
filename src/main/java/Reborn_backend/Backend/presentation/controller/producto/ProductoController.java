package Reborn_backend.Backend.presentation.controller.producto;

import Reborn_backend.Backend.domain.dto.request.producto.ProductoRequest;
import Reborn_backend.Backend.domain.dto.response.producto.ProductoResponse;
import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.use_case.producto.CrearProductoCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final CrearProductoCase crearProductoCase;

    public ProductoController(CrearProductoCase crearProductoCase){
        this.crearProductoCase = crearProductoCase;
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
}
