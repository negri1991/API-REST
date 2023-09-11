package es.MueblesCastilla.MueblesCastilla.domain.repository;

import java.util.List;
import java.util.Optional;

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;

public interface ICompraRepository {
	
	 /**
	  * Devuelve una lista con todas las compras
	  * @return Lista todas las compras.
	  */
	List<CompraPojo> getAll();
	/**
	 * Devuelve una compra dado su id
	 * @param id Id de compra
	 * @return Optional de la compra
	 */
	Optional<CompraPojo> getCompraById(Integer id);//Optional evita la exception nullPointerException


	/**
	 * Guarda una compra
	 * @param newCompra Compra a guardar
	 * @return Compra guardada
	 */
	CompraPojo save(CompraPojo newCompra);
	
	/**
	 * Elimina una compra dada su id
	 * @param idCompra Id para eliminar la compra
	 */
	void delete (Integer idCompra);
}
