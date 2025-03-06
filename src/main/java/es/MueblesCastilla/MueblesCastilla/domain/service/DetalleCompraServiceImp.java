package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.DetalleCompraRepository;
import es.MueblesCastilla.MueblesCastilla.domain.userCase.DetalleCompraService;

/**
 * Servicio Usuario (Son todas las validaciones que lleva).
 */
@Service
public class DetalleCompraServiceImp implements DetalleCompraService{
	
	private final DetalleCompraRepository detalleCompraRepository;
	
	public DetalleCompraServiceImp (DetalleCompraRepository detalleCompraRepository) {
		this.detalleCompraRepository=detalleCompraRepository;
	}
	
	/**
     * Retorna una lista de DetalleCompra transformada a pojo de una lista de entidades
     * @param DetalleCompraEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<DetalleCompraPojo> getAll() {
		
		return detalleCompraRepository.getAll();
	}

	/**
	 * Retorna un opcional dada su id
	 * @param id de DetalleCompra
	 * @return Opcional de DetalleCompraPojo
	 */
	@Override
	public Optional<DetalleCompraPojo> getDetalleCompraById(Integer id) {
		
		return detalleCompraRepository.getDetalleCompraById(id);
	}
	
	/**
	 * Retorna un DetalleCompra guardado
	 * @param nuevo DetalleCompra
	 * @return crea DetalleCompra
	 */
	@Override
	public DetalleCompraPojo save(DetalleCompraPojo newDetalleCompra) {
		return detalleCompraRepository.save(newDetalleCompra);
	}
	
	/**
	 * Elimina DetalleCompra
	 * @param DetalleCompra a eliminar
	 * @return elimina DetalleCompra
	 */
	@Override
	public boolean delete(Integer idDetalleCompra) {
		
		if (detalleCompraRepository.getDetalleCompraById(idDetalleCompra).isEmpty()) {
			return false;
		}
			detalleCompraRepository.delete(idDetalleCompra);
			return true;
	
		
	}
	
	/**
	 * DetalleCompra a actualizar
	 * @param DetalleCompra
	 * @return DetalleCompra actualizado
	 */
	@Override
	public Optional<DetalleCompraPojo> update(DetalleCompraPojo detalleCompra) {
		
		if (detalleCompraRepository.getDetalleCompraById(detalleCompra.getId()).isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(detalleCompraRepository.save(detalleCompra));
		
	}

}
