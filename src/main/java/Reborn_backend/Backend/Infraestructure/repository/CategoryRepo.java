package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Categoria;
import Reborn_backend.Backend.domain.repository.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepo implements CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    // Guardar una categoria
    @Override
    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            em.persist(categoria);
            return categoria;
        } else  {
            return em.merge(categoria);
        }
    }

    //Mostrar categorias
    @Override
    public List<Categoria> findAll() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    //Buscar por id
    @Override
    public Optional<Categoria> findById(Integer id) {
        Categoria categoria = em.find(Categoria.class, id);
        return  Optional.ofNullable(categoria);
    }

    //Verificar si categoria ya existe
    @Override
    public boolean existsByNombre(String nombre) {
        Long count = em.createQuery("SELECT COUNT(c) FROM Categoria c WHERE c.nombre = :nombre", Long.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
        return count > 0;
    }

    //Eliminar categoria
    @Override
    public void deleteById(Integer id) {
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            em.remove(categoria);
        }
    }
}