package es.MueblesCastilla.MueblesCastilla.domain.userCase;

import java.util.List;
import java.util.Optional;

import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;

public interface UsuarioService {
	/**
	  * Devuelve una lista con todos los usuarios
	  * @return Lista todos los usuario.
	  */
	List<UsuarioPojo> getAll();
	/**
	 * Devuelve un usuario dado su id
	 * @param id de usuario
	 * @return Optional de usuario
	 */
	Optional<UsuarioPojo> getUsuarioById(Integer id);//Optional evita la exception nullPointerException
	
	/**
	 * Devuelve un usuario dado su email
	 * @param email de usuario
	 * @return Optional de usuario
	 */
	Optional<UsuarioPojo> getUsuarioByEmail(String email);//Optional evita la exception nullPointerException

	/**
	 * Guarda un usuario
	 * @param newUsuario usuario a guardar
	 * @return Usuario guardado
	 */
	UsuarioPojo save(UsuarioPojo newUsuario);
	
	/**
	 * Actualiza un usuario
	 * @param Recibe un usuario
	 * @return Devuelve el usuario actualizado
	 */
	Optional <UsuarioPojo> update (UsuarioPojo usuario);
	
	/**
	 * Elimina un usuario dado su id
	 * @param idUsuario Id para eliminar la usuario
	 */
	boolean delete (Integer idUsuario);

}


