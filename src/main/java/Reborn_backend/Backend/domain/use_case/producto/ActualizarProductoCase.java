package Reborn_backend.Backend.domain.use_case.producto;

import Reborn_backend.Backend.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ActualizarProductoCase {
    private final ProductRepository productRepository;

    public ActualizarProductoCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public void actualizarProducto(Integer idProducto, String nuevoNombre, BigDecimal nuevoPrecio){

        if (nuevoNombre.length() > 80){
            throw new RuntimeException("El nombre no puede tener mas de 80 caracteres");
        } else if (nuevoNombre.isBlank()) {
            throw new RuntimeException("El producto necesita un nombre");
        }

        if (nuevoPrecio == null || nuevoPrecio.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("El precio no puede ser negativo");
        }

        productRepository.actualizarProducto(idProducto, nuevoNombre, nuevoPrecio);
    }
}
