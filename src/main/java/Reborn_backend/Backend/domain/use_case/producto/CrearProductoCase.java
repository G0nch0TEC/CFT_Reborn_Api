package Reborn_backend.Backend.domain.use_case.producto;

import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.repository.CategoryRepository;
import Reborn_backend.Backend.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrearProductoCase {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public CrearProductoCase(ProductRepository productRepository,
                             CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Producto crearProducto(Producto producto, Integer idCat){
        Categoria categoria = categoryRepository.findById(idCat)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        producto.setCategoria(categoria);

        return productRepository.save(producto);
    }
}
