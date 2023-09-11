package es.MueblesCastilla.MueblesCastilla.domain.userCase;

import java.util.List;
import java.util.Optional;

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;

public interface ICompraUseCase {
	
	/**
	  * Devuelve una lista con todos las compras
	  * @return Lista todas las compras.
	  */
	List<CompraPojo> getAll();
	/**
	 * Devuelve un usuario dado su id
	 * @param id de usuario
	 * @return Optional de usuario
	 */
	Optional<CompraPojo> getCompraById(Integer id);//Optional evita la exception nullPointerException
	
	/**
	 * Guarda una compra
	 * @param newCompra compra a guardar
	 * @return compra guardado
	 */
	CompraPojo save(CompraPojo newCompra);
	
	/**
	 * Actualiza una compra
	 * @param Recibe una compra
	 * @return Devuelve la compra actualizada
	 */
	Optional <CompraPojo> update (CompraPojo compra);
	
	/**
	 * Elimina una compra dada su id
	 * @param idCompra Id para eliminar la compra
	 */
	boolean delete (Integer idCompra);

}
