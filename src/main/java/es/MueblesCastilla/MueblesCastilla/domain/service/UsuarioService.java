package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.IUsuarioRepository;
import es.MueblesCastilla.MueblesCastilla.domain.userCase.IUsuarioUseCase;
import es.MueblesCastilla.MueblesCastilla.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;

/**
 * Servicio Usuario (Son todas las validaciones que lleva).
 */
@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioUseCase{
	
	private final IUsuarioRepository iUsuarioRepository;
	
	/**
     * Retorna una lista de usuario transformada a pojo de una lista de entidades
     * @param usuarioEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<UsuarioPojo> getAll() {
		
		return iUsuarioRepository.getAll();
	}

	/**
	 * Retorna un opcional dada su id
	 * @param id de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioById(Integer id) {
		
		return iUsuarioRepository.getUsuarioById(id);
	}
	
	/**
	 * Retorna un opcional dada su email
	 * @param email de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioByEmail(String email) {
		
		return iUsuarioRepository.getUsuarioByEmail(email);
	}
	
	/**
	 * Retorna un usuario guardado
	 * @param nuevo usuario
	 * @return crea usuario
	 */
	@Override
	public UsuarioPojo save(UsuarioPojo newUsuario) {
		
		newUsuario.setTipo("USER");
		

        if (!newUsuario.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        
		}
		return iUsuarioRepository.save(newUsuario);
	}
	
	/**
	 * Elimina usuario
	 * @param usuario a eliminar
	 * @return elimina usuario
	 */
	@Override
	public boolean delete(Integer idUsuario) {
		
		if (iUsuarioRepository.getUsuarioById(idUsuario).isEmpty()) {
			return false;
		}
			iUsuarioRepository.delete(idUsuario);
			return true;
	
		
	}
	
	/**
	 * Usuario a actualizar
	 * @param usuario
	 * @return usuario actualizado
	 */
	@Override
	public Optional<UsuarioPojo> update(UsuarioPojo usuario) {
		
		if (iUsuarioRepository.getUsuarioById(usuario.getId()).isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(iUsuarioRepository.save(usuario));
		
	}

}
