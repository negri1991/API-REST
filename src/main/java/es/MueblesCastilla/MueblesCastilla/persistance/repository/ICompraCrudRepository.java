package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.MueblesCastilla.MueblesCastilla.persistance.entity.Compra;
/**
 * DAO DATA ACCESS OBJECT (Objeto accesible a la base de datos)
 */
public interface ICompraCrudRepository extends JpaRepository<Compra, Integer>{

}
