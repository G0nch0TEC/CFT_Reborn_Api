package Reborn_backend.Backend.domain.use_case.producto;

import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductByCatalogCase {
    private final ProductRepository productRepository;

    public GetProductByCatalogCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Producto> getProductByCatalog(Integer idCategoria){
        return productRepository.findByCategoria(idCategoria);
    }
}
