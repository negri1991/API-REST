package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.UsuarioRepository;
import es.MueblesCastilla.MueblesCastilla.domain.userCase.UsuarioService;
import es.MueblesCastilla.MueblesCastilla.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;

/**
 * Servicio Usuario (Son todas las validaciones que lleva).
 */
@RequiredArgsConstructor
@Service
public class UsuarioServiceImp implements UsuarioService{
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
		this.usuarioRepository=usuarioRepository;
	}
	
	/**
     * Retorna una lista de usuario transformada a pojo de una lista de entidades
     * @param usuarioEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<UsuarioPojo> getAll() {
		
		return usuarioRepository.getAll();
	}

	/**
	 * Retorna un opcional dada su id
	 * @param id de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioById(Integer id) {
		
		return usuarioRepository.getUsuarioById(id);
	}
	
	/**
	 * Retorna un opcional dada su email
	 * @param email de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioByEmail(String email) {
		
		return usuarioRepository.getUsuarioByEmail(email);
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
		return usuarioRepository.save(newUsuario);
	}
	
	/**
	 * Elimina usuario
	 * @param usuario a eliminar
	 * @return elimina usuario
	 */
	@Override
	public boolean delete(Integer idUsuario) {
		
		if (usuarioRepository.getUsuarioById(idUsuario).isEmpty()) {
			return false;
		}
			usuarioRepository.delete(idUsuario);
			return true;
	
		
	}
	
	/**
	 * Usuario a actualizar
	 * @param usuario
	 * @return usuario actualizado
	 */
	@Override
	public Optional<UsuarioPojo> update(UsuarioPojo usuario) {
		
		if (usuarioRepository.getUsuarioById(usuario.getId()).isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(usuarioRepository.save(usuario));
		
	}

}
