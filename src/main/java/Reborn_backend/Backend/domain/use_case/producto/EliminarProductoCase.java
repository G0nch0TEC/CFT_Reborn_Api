package Reborn_backend.Backend.domain.use_case.producto;

import Reborn_backend.Backend.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EliminarProductoCase {
    private final ProductRepository productRepository;

    public EliminarProductoCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public void eliminarProducto(Integer idCliente){
        productRepository.deleteById(idCliente);
    }
}
