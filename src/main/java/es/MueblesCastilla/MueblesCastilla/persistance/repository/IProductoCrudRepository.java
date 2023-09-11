package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.MueblesCastilla.MueblesCastilla.persistance.entity.Producto;
/**
 * DAO DATA ACCESS OBJECT (Objeto accesible a la base de datos)
 */
public interface IProductoCrudRepository extends JpaRepository<Producto, Integer>{

}
