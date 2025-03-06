package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.UsuarioRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.crud.UsuarioCrudRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.UsuarioMapper;
/**
 * Repository de Usuario (es el que se conecta a la base de datos DAO)
 */
@Repository
public class UsuarioRepositoryImp implements UsuarioRepository{
	/**
	 * Crud de Usuario
	 */
	private final UsuarioCrudRepository usuarioCrudRepository;
	/**
	 * Mapper de usuario
	 */
	private final UsuarioMapper usuarioMapper;
	
	public UsuarioRepositoryImp(UsuarioCrudRepository usuarioCrudRepository, UsuarioMapper usuarioMapper) {
		
		this.usuarioCrudRepository=usuarioCrudRepository;
		this.usuarioMapper=usuarioMapper;
	}
	
    /**
     * Retorna una lista de usuario transformada a pojo de una lista de entidades
     * @param usuarioEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<UsuarioPojo> getAll() {
		
		return usuarioMapper.toUsuarioPojo(usuarioCrudRepository.findAll());
	}
	
	
	/**
	 * Retorna un opcional dada su id
	 * @param id de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioByEmail(String email) {
		
		return usuarioCrudRepository.findByEmail(email).map(usuarioMapper::toUsuarioPojo);//mapea la interfaz mapper y llama al metodo toUsuarioPojo.
		
//		return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
	}
	
	/**
	 * Retorna un opcional dada su id
	 * @param id de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioById(Integer id) {
		
		return usuarioCrudRepository.findById(id).map(usuarioMapper::toUsuarioPojo);//mapea la interfaz mapper y llama al metodo toUsuarioPojo.
		
//		return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
	}
	/**
	 * Retorna un usuario guardado
	 * @param nuevo usuario
	 * @return crea usuario
	 */
	@Override
	public UsuarioPojo save(UsuarioPojo newUsuario) {
		
		return usuarioMapper.toUsuarioPojo(usuarioCrudRepository.save(usuarioMapper.toUsuarioEntity(newUsuario)));
	}
	/**
	 * Elimina usuario
	 * @param usuario a eliminar
	 * @return elimina usuario
	 */
	@Override
	public void delete(Integer idUsuario) {
		usuarioCrudRepository.deleteById(idUsuario);
		
	}

}
