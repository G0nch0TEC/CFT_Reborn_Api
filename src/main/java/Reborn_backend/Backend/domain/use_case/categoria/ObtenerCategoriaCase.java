package Reborn_backend.Backend.domain.use_case.categoria;

import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerCategoriaCase {

    private final CategoryRepository categoryRepository;

    public ObtenerCategoriaCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Categoria> obtenerCategorias() {
        return categoryRepository.findAll();
    }
}
