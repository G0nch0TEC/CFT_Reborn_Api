package Reborn_backend.Backend.domain.use_case.categoria;

import Reborn_backend.Backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class EliminarCategoriaCase {
    private final CategoryRepository categoryRepository;

    public EliminarCategoriaCase(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void eliminarCategoria(Integer idCategoria){
        categoryRepository.deleteById(idCategoria);
    }
}
