package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {
    @PersistenceContext
    private EntityManager em;

    //Guardar producto
    public Producto save(Producto producto) {
        if (producto.getKeyproduct() == null){
            em.persist(producto);
            return producto;
        } else {
            return em.merge(producto);
        }
    }

    //Ver productos
    public List<Producto> findAll() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    //Ver por categoria
    public List<Producto> findByCategoria(Integer categoria) {
        return em.createQuery("SELECT p FROM Producto p WHERE p.categoria.idcat = :categoria",  Producto.class)
                .setParameter("categoria", categoria).getResultList();
    }

    //Eliminar por id
    public void deleteById(Integer keyproduct){
        Producto producto = em.find(Producto.class, keyproduct);
        if (producto != null){
            em.remove(producto);
        }
    }
}
