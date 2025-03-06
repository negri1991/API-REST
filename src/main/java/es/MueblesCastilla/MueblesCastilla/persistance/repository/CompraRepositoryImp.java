package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.CompraRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.crud.CompraCrudRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.CompraMapper;


/**
 * Repositorio de compra
 */
@Repository
public class CompraRepositoryImp implements CompraRepository{
	/**
	 * Crud de compra
	 */
	private final CompraCrudRepository compraCrudRepository;
	
	/**
	 * Mapper de compra
	 */
	private final CompraMapper compraMapper;
	
	@Autowired
	public CompraRepositoryImp (CompraCrudRepository compraCrudRepository, CompraMapper compraMapper) {
		this.compraCrudRepository=compraCrudRepository;
		this.compraMapper = compraMapper;
		
	}

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
	
	return compraMapper.toCompraPojo(compraCrudRepository.findAll());
}

/**
 * Retorna un opcional dada su id
 * @param id de compra
 * @return Opcional de CompraPojo
 */
@Override
public Optional<CompraPojo> getCompraById(Integer id) {
	
	return compraCrudRepository.findById(id).map(compraMapper::toCompraPojo);//mapea la interfaz mapper y llama al metodo toCompraPojo.
	
//	return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
}

/**
 * Retorna una compra guardada
 * @param nueva compra
 * @return crea compra
 */
@Override
public CompraPojo save(CompraPojo newCompra) {
	
	return compraMapper.toCompraPojo(compraCrudRepository.save(compraMapper.toCompraEntity(newCompra)));
}

/**
 * Elimina compra
 * @param compra a eliminar
 * @return elimina usuario
 */
@Override
public void delete(Integer idCompra) {
	compraCrudRepository.deleteById(idCompra);
	
}


}
