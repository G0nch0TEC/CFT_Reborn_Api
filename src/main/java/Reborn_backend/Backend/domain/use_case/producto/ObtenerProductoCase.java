package Reborn_backend.Backend.domain.use_case.producto;

import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerProductoCase {
    private final ProductRepository productRepository;

    public ObtenerProductoCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Producto> obtenerProductos(){
        return productRepository.findAll();
    }
}
