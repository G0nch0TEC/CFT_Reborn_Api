package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepo {
    @PersistenceContext
    private EntityManager em;

    // Guardar una categoria
    public Categoria save(Categoria categoria) {
        if (categoria.getIdcat() == null) {
            em.persist(categoria);
            return categoria;
        } else  {
            return em.merge(categoria);
        }
    }

    //Mostrar categorias
    public List<Categoria> findAll() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    //Buscar por id
    public Optional<Categoria> findById(Integer idcat) {
        Categoria categoria = em.find(Categoria.class, idcat);
        return  Optional.ofNullable(categoria);
    }

    //Verificar si categoria ya existe
    public boolean existsByNombre(String nombre) {
        Long count = em.createQuery("SELECT COUNT(c) FROM Categoria c WHERE c.nombre = :nombre", Long.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
        return count > 0;
    }

    //Eliminar categoria
    public void deleteById(Integer idcat) {
        Categoria categoria = em.find(Categoria.class, idcat);
        if (categoria != null) {
            em.remove(categoria);
        }
    }
}