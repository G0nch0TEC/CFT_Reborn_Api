package Reborn_backend.Backend.Infraestructure.repository;

import Reborn_backend.Backend.domain.entities.Producto;
import Reborn_backend.Backend.domain.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    //Guardar producto
    @Override
    public Producto save(Producto producto) {
        if (producto.getId() == null){
            em.persist(producto);
            return producto;
        } else {
            return em.merge(producto);
        }
    }

    //Ver productos
    @Override
    public List<Producto> findAll() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    //Ver por categoria
    @Override
    public List<Producto> findByCategoria(Integer id) {
        return em.createQuery("SELECT p FROM Producto p WHERE p.categoria.id = :id",  Producto.class)
                .setParameter("id", id).getResultList();
    }

    //Buscar por id
    @Override
    public Optional<Producto> findById(Integer id){
        Producto producto = em.find(Producto.class, id);
        return Optional.ofNullable(producto);
    }

    //Actualizar Nombre Producto
    public Optional<Producto> updateNombre(Integer id, String nuevoNombre){
        Producto producto = em.find(Producto.class, id);

        if (producto == null){
            return Optional.empty();
        }

        producto.setNombre(nuevoNombre);
        return Optional.of(producto);
    }

    //Actualizar Nombre
    public void actualizarProducto(Integer idProducto, String nombre, BigDecimal precio){
        em.createQuery("UPDATE Producto p SET p.nombre = :nombre,  p.precio = :precio WHERE p.id = :id")
                .setParameter("idProducto", idProducto)
                .setParameter("nombre", nombre)
                .setParameter("precio", precio)
                .executeUpdate();
    }

    //Eliminar por id
    @Override
    public void deleteById(Integer id){
        Producto producto = em.find(Producto.class, id);
        if (producto != null){
            em.remove(producto);
        }
    }
}
