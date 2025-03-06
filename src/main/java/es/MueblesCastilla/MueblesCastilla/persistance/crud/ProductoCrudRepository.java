package es.MueblesCastilla.MueblesCastilla.persistance.crud;



import org.springframework.data.jpa.repository.JpaRepository;

import es.MueblesCastilla.MueblesCastilla.persistance.entity.Producto;
import java.util.List;

/**
 * DAO DATA ACCESS OBJECT (Objeto accesible a la base de datos)
 */
public interface ProductoCrudRepository extends JpaRepository<Producto, Integer>{

	List<Producto> findByNombre(String name);
}
