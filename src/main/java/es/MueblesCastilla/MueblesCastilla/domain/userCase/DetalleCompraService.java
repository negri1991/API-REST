package es.MueblesCastilla.MueblesCastilla.domain.userCase;

import java.util.List;
import java.util.Optional;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;

public interface DetalleCompraService {
	/**
	  * Devuelve una lista con todos los DetalleCompra
	  * @return Lista todos los DetalleCompra.
	  */
	List<DetalleCompraPojo> getAll();
	/**
	 * Devuelve un DetalleCompra dado su id
	 * @param id de DetalleCompra
	 * @return Optional de DetalleCompra
	 */
	Optional<DetalleCompraPojo> getDetalleCompraById(Integer id);//Optional evita la exception nullPointerException
	
	/**
	 * Guarda un DetalleCompra
	 * @param newDetalleCompra DetalleCompra a guardar
	 * @return DetalleCompra guardado
	 */
	DetalleCompraPojo save(DetalleCompraPojo newDetalleCompra);
	
	/**
	 * Actualiza un DetalleCompra
	 * @param Recibe un DetalleCompra
	 * @return Devuelve el DetalleCompra actualizado
	 */
	Optional <DetalleCompraPojo> update (DetalleCompraPojo usuario);
	
	/**
	 * Elimina un DetalleCompra dado su id
	 * @param idDetalleCompra Id para eliminar la DetalleCompra
	 */
	boolean delete (Integer idUsuario);

}