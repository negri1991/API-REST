package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.IUsuarioRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.crud.IUsuarioCrudRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.IUsuarioMapper;
import lombok.RequiredArgsConstructor;
/**
 * Repository de Usuario (es el que se conecta a la base de datos DAO)
 */
@RequiredArgsConstructor//Anotara el constructor con los atributos final.
@Repository
public class UsuarioRepository implements IUsuarioRepository{
	/**
	 * Crud de Usuario
	 */
	private final IUsuarioCrudRepository iUsuarioCrudRepository;
	/**
	 * Mapper de usuario
	 */
	private final IUsuarioMapper iUsuarioMapper;
	
	/*public UsuarioRepository(IUsuarioCrudRepository iUsuarioCrudRepository, IUsuarioMapper iUsuarioMapper) {
		
		this.iUsuarioCrudRepository=iUsuarioCrudRepository;
		this.iUsuarioMapper=iUsuarioMapper;
		
		****lo creo con lombok****
	}*/
	
	
    /**
     * Retorna una lista de usuario transformada a pojo de una lista de entidades
     * @param usuarioEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<UsuarioPojo> getAll() {
		
		return iUsuarioMapper.toUsuarioPojo(iUsuarioCrudRepository.findAll());
	}
	
	
	/**
	 * Retorna un opcional dada su id
	 * @param id de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioByEmail(String email) {
		
		return iUsuarioCrudRepository.findByEmail(email).map(iUsuarioMapper::toUsuarioPojo);//mapea la interfaz mapper y llama al metodo toUsuarioPojo.
		
//		return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
	}
	
	/**
	 * Retorna un opcional dada su id
	 * @param id de usuario
	 * @return Opcional de UsuarioPojo
	 */
	@Override
	public Optional<UsuarioPojo> getUsuarioById(Integer id) {
		
		return iUsuarioCrudRepository.findById(id).map(iUsuarioMapper::toUsuarioPojo);//mapea la interfaz mapper y llama al metodo toUsuarioPojo.
		
//		return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
	}
	/**
	 * Retorna un usuario guardado
	 * @param nuevo usuario
	 * @return crea usuario
	 */
	@Override
	public UsuarioPojo save(UsuarioPojo newUsuario) {
		
		return iUsuarioMapper.toUsuarioPojo(iUsuarioCrudRepository.save(iUsuarioMapper.toUsuarioEntity(newUsuario)));
	}
	/**
	 * Elimina usuario
	 * @param usuario a eliminar
	 * @return elimina usuario
	 */
	@Override
	public void delete(Integer idUsuario) {
		iUsuarioCrudRepository.deleteById(idUsuario);
		
	}

}
