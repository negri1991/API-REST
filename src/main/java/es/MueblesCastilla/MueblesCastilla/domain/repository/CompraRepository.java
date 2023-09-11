package es.MueblesCastilla.MueblesCastilla.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.ICompraMapper;
import es.MueblesCastilla.MueblesCastilla.persistance.repository.ICompraCrudRepository;
import lombok.RequiredArgsConstructor;

/**
 * Repositorio de compra
 */
@RequiredArgsConstructor
@Repository
public class CompraRepository implements ICompraRepository{
	/**
	 * Crud de compra
	 */
	private final ICompraCrudRepository iCompraCrudRepository;
	/**
	 * Mapper de compra
	 */
	private final ICompraMapper iCompraMapper;
	/*public UsuarioRepository(IUsuarioCrudRepository iUsuarioCrudRepository, IUsuarioMapper iUsuarioMapper) {
	
	this.iUsuarioCrudRepository=iUsuarioCrudRepository;
	this.iUsuarioMapper=iUsuarioMapper;
	
	****lo creo con lombok****
}*/


/**
 * Retorna una lista de compra transformada a pojo de una lista de entidades
 * @param compraEntity Entidad a transformar
 * @return Lista transformada
 */
@Override
public List<CompraPojo> getAll() {
	
	return iCompraMapper.toCompraPojo(iCompraCrudRepository.findAll());
}

/**
 * Retorna un opcional dada su id
 * @param id de compra
 * @return Opcional de CompraPojo
 */
@Override
public Optional<CompraPojo> getCompraById(Integer id) {
	
	return iCompraCrudRepository.findById(id).map(iCompraMapper::toCompraPojo);//mapea la interfaz mapper y llama al metodo toCompraPojo.
	
//	return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
}

/**
 * Retorna una compra guardada
 * @param nueva compra
 * @return crea compra
 */
@Override
public CompraPojo save(CompraPojo newCompra) {
	
	return iCompraMapper.toCompraPojo(iCompraCrudRepository.save(iCompraMapper.toCompraEntity(newCompra)));
}

/**
 * Elimina compra
 * @param compra a eliminar
 * @return elimina usuario
 */
@Override
public void delete(Integer idCompra) {
	iCompraCrudRepository.deleteById(idCompra);
	
}


}
