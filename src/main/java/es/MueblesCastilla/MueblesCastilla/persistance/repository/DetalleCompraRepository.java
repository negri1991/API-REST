package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.IDetalleCompraRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.crud.IDetalleCompraCrudRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.IDetalleCompraMapper;
import lombok.RequiredArgsConstructor;

/**
 * Repositorio de Detalle Compra
 */
@RequiredArgsConstructor
@Repository
public class DetalleCompraRepository implements IDetalleCompraRepository{
	/**
	 * Crud de detalle compra
	 */
	private final IDetalleCompraCrudRepository iDetalleCompraCrudRepository;
	/**
	 * Mapper de detalle compra
	 */
	private final IDetalleCompraMapper iDetalleCompraMapper;
	
    /**
     * Retorna una lista de DetalleCompra transformada a pojo de una lista de entidades
     * @param DetalleCompraEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<DetalleCompraPojo> getAll() {
		
		return iDetalleCompraMapper.toDetalleCompraPojo(iDetalleCompraCrudRepository.findAll());
	}
	
	/**
	 * Retorna un opcional dada su id
	 * @param id de DetalleCompra
	 * @return Opcional de DetalleCompraPojo
	 */
	@Override
	public Optional<DetalleCompraPojo> getDetalleCompraById(Integer id) {
		
		return iDetalleCompraCrudRepository.findById(id).map(iDetalleCompraMapper::toDetalleCompraPojo);//mapea la interfaz mapper y llama al metodo toDetalleCompra.
		
//		return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
	}

	/**
	 * Retorna un DetalleCompra guardado
	 * @param nuevo DetalleCompra
	 * @return crea DetalleCompra
	 */
	@Override
	public DetalleCompraPojo save(DetalleCompraPojo newDetalleCompra) {
		
		return iDetalleCompraMapper.toDetalleCompraPojo(iDetalleCompraCrudRepository.save(iDetalleCompraMapper.toDetalleCompraEntity(newDetalleCompra)));
	}

	/**
	 * Elimina DetalleCompra
	 * @param DetalleCompra a eliminar
	 * @return elimina DetalleCompra
	 */
	@Override
	public void delete(Integer idDetalleCompra) {
		iDetalleCompraCrudRepository.deleteById(idDetalleCompra);
		
	}
	
}
