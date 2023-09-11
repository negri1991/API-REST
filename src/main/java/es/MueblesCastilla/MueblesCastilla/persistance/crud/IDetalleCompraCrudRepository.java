package es.MueblesCastilla.MueblesCastilla.persistance.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import es.MueblesCastilla.MueblesCastilla.persistance.entity.DetalleCompra;
/**
 * DAO DATA ACCESS OBJECT (Objeto accesible a la base de datos)
 */
public interface IDetalleCompraCrudRepository extends JpaRepository<DetalleCompra, Integer>{

}
