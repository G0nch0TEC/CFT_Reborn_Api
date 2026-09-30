package Reborn_backend.Backend.domain.use_case.categoria;

import Reborn_backend.Backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ActualizarCategoriaCase {
    private final CategoryRepository categoryRepository;

    public  ActualizarCategoriaCase(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void actualizarCategoria(Integer idCategoria, String nombre){
        categoryRepository.actualizarCategoria(idCategoria, nombre);
    }
}
