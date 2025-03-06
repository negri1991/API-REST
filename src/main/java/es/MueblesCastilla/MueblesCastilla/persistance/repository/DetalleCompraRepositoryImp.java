package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.DetalleCompraRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.crud.DetalleCompraCrudRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.DetalleCompraMapper;
import lombok.RequiredArgsConstructor;

/**
 * Repositorio de Detalle Compra
 */
@RequiredArgsConstructor
@Repository
public class DetalleCompraRepositoryImp implements DetalleCompraRepository{
	/**
	 * Crud de detalle compra
	 */
	private final DetalleCompraCrudRepository detalleCompraCrudRepository;
	/**
	 * Mapper de detalle compra
	 */
	private final DetalleCompraMapper detalleCompraMapper;
	
	@Autowired
	public DetalleCompraRepositoryImp(DetalleCompraCrudRepository detalleCompraCrudRepository, DetalleCompraMapper detalleCompraMapper) {
		this.detalleCompraCrudRepository=detalleCompraCrudRepository;
		this.detalleCompraMapper=detalleCompraMapper;
	}
	
    /**
     * Retorna una lista de DetalleCompra transformada a pojo de una lista de entidades
     * @param DetalleCompraEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<DetalleCompraPojo> getAll() {
		
		return detalleCompraMapper.toDetalleCompraPojo(detalleCompraCrudRepository.findAll());
	}
	
	/**
	 * Retorna un opcional dada su id
	 * @param id de DetalleCompra
	 * @return Opcional de DetalleCompraPojo
	 */
	@Override
	public Optional<DetalleCompraPojo> getDetalleCompraById(Integer id) {
		
		return detalleCompraCrudRepository.findById(id).map(detalleCompraMapper::toDetalleCompraPojo);//mapea la interfaz mapper y llama al metodo toDetalleCompra.
		
//		return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
	}

	/**
	 * Retorna un DetalleCompra guardado
	 * @param nuevo DetalleCompra
	 * @return crea DetalleCompra
	 */
	@Override
	public DetalleCompraPojo save(DetalleCompraPojo newDetalleCompra) {
		
		return detalleCompraMapper.toDetalleCompraPojo(detalleCompraCrudRepository.save(detalleCompraMapper.toDetalleCompraEntity(newDetalleCompra)));
	}

	/**
	 * Elimina DetalleCompra
	 * @param DetalleCompra a eliminar
	 * @return elimina DetalleCompra
	 */
	@Override
	public void delete(Integer idDetalleCompra) {
		detalleCompraCrudRepository.deleteById(idDetalleCompra);
		
	}
	
}
