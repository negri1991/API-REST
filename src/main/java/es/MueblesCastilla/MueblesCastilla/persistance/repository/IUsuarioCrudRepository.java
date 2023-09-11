package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.MueblesCastilla.MueblesCastilla.persistance.entity.Usuario;
/**
 * DAO DATA ACCESS OBJECT (Objeto accesible a la base de datos)
 */
public interface IUsuarioCrudRepository extends JpaRepository<Usuario, Integer>{
	
	//Query method
	//Ahorra--> @Query("select * from usuario where email = ?1 ")
	Optional<Usuario> findByEmail(String email);

}
