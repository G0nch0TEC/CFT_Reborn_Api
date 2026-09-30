package Reborn_backend.Backend.domain.use_case.categoria;

import Reborn_backend.Backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class VerificarCategoriaCase {
    private final CategoryRepository categoryRepository;

    public VerificarCategoriaCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean existeCategoriaPorNombre(String nombre){
        return categoryRepository.existsByNombre(nombre);
    }
}
