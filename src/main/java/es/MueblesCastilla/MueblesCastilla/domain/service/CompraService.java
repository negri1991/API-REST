package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.ICompraRepository;
import lombok.RequiredArgsConstructor;

/**
 * Servicio compra (Son todas las validaciones que lleva).
 */
@RequiredArgsConstructor
@Service
public class CompraService implements ICompraService{
	
	private final ICompraRepository iCompraRepository;
	/**
     * Retorna una lista de compra transformada a pojo de una lista de entidades
     * @param compraEntity Entidad a transformar
     * @return Lista transformada
     */
	@Override
	public List<CompraPojo> getAll() {
		
		return iCompraRepository.getAll();
	}

	/**
	 * Retorna un opcional dada su id
	 * @param id de compra
	 * @return Opcional de CompraPojo
	 */
	@Override
	public Optional<CompraPojo> getCompraById(Integer id) {
		
		return iCompraRepository.getCompraById(id);
	}

	/**
	 * Retorna una compra guardada
	 * @param nueva compra
	 * @return crea una compra
	 */
	@Override
	public CompraPojo save(CompraPojo newCompra) {
		
		return iCompraRepository.save(newCompra);
	}

	/**
	 * Compra a actualizar
	 * @param compra
	 * @return compra actualizado
	 */
	@Override
	public Optional<CompraPojo> update(CompraPojo compra) {
		
		if (iCompraRepository.getCompraById(compra.getId()).isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(iCompraRepository.save(compra));
		
	}

	/**
	 * Elimina compra
	 * @param compra a eliminar
	 * @return elimina compra
	 */
	@Override
	public boolean delete(Integer idCompra) {
		
		if (iCompraRepository.getCompraById(idCompra).isEmpty()) {
			return false;
		}
			iCompraRepository.delete(idCompra);
			return true;
	
		
	}
	

}
