package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.IDetalleCompraRepository;
import lombok.RequiredArgsConstructor;

/**
 * Servicio Usuario (Son todas las validaciones que lleva).
 */
@RequiredArgsConstructor
@Service
public class DetalleCompraService implements IDetalleCompraService{
	
	private final IDetalleCompraRepository iDetalleCompraRepository;
	
	/**
     * Retorna una lista de DetalleCompra transformada a pojo de una lista de entidades
     * @param DetalleCompraEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<DetalleCompraPojo> getAll() {
		
		return iDetalleCompraRepository.getAll();
	}

	/**
	 * Retorna un opcional dada su id
	 * @param id de DetalleCompra
	 * @return Opcional de DetalleCompraPojo
	 */
	@Override
	public Optional<DetalleCompraPojo> getDetalleCompraById(Integer id) {
		
		return iDetalleCompraRepository.getDetalleCompraById(id);
	}
	
	/**
	 * Retorna un DetalleCompra guardado
	 * @param nuevo DetalleCompra
	 * @return crea DetalleCompra
	 */
	@Override
	public DetalleCompraPojo save(DetalleCompraPojo newDetalleCompra) {
		return iDetalleCompraRepository.save(newDetalleCompra);
	}
	
	/**
	 * Elimina DetalleCompra
	 * @param DetalleCompra a eliminar
	 * @return elimina DetalleCompra
	 */
	@Override
	public boolean delete(Integer idDetalleCompra) {
		
		if (iDetalleCompraRepository.getDetalleCompraById(idDetalleCompra).isEmpty()) {
			return false;
		}
			iDetalleCompraRepository.delete(idDetalleCompra);
			return true;
	
		
	}
	
	/**
	 * DetalleCompra a actualizar
	 * @param DetalleCompra
	 * @return DetalleCompra actualizado
	 */
	@Override
	public Optional<DetalleCompraPojo> update(DetalleCompraPojo detalleCompra) {
		
		if (iDetalleCompraRepository.getDetalleCompraById(detalleCompra.getId()).isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(iDetalleCompraRepository.save(detalleCompra));
		
	}

}
