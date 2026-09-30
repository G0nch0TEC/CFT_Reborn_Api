package Reborn_backend.Backend.domain.use_case.categoria;

import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrearCategoriaCase {
    private final CategoryRepository categoryRepository;
    private final VerificarCategoriaCase verificarCategoriaCase;

    public CrearCategoriaCase(CategoryRepository categoryRepository,
                              VerificarCategoriaCase verificarCategoriaCase) {
        this.categoryRepository = categoryRepository;
        this.verificarCategoriaCase = verificarCategoriaCase;
    }

    @Transactional
    public Categoria crearCategoria(Categoria categoria){

        if (verificarCategoriaCase.existeCategoriaPorNombre(categoria.getNombre())){
            throw new RuntimeException("Esta Categoria ya existe");
        }

        return categoryRepository.save(categoria);
    }
}
