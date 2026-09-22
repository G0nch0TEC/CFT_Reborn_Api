package Reborn_backend.Backend.domain.use_case.categoria;

import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrearCategoriaCase {
    private final CategoryRepository categoryRepository;

    public CrearCategoriaCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Categoria crearCategoria(Categoria categoria){
        return categoryRepository.save(categoria);
    }
}
