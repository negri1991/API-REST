package es.MueblesCastilla.MueblesCastilla.domain.repository;

import java.util.List;
import java.util.Optional;


import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;

public interface IDetalleCompraRepository {
	 /**
	  * Devuelve una lista con todos los detalle compras
	  * @return Lista todos los detalles compras.
	  */
	List<DetalleCompraPojo> getAll();
	/**
	 * Devuelve un detalle compra dado su id
	 * @param id Id de  detalle compra
	 * @return Optional de detalle compra
	 */
	Optional<DetalleCompraPojo> getDetalleCompraById(Integer id);//Optional evita la exception nullPointerException

	/**
	 * Guarda un detalle compra
	 * @param newDetalleCompra DetaññeCompra a guardar
	 * @return Detalle Compra guardado
	 */
	DetalleCompraPojo save(DetalleCompraPojo newDetalleCompra);
	
	/**
	 * Elimina una compra dada su id
	 * @param idDetalleCompra Id para eliminar la compra
	 */
	void delete (Integer idDetalleCompra);
	

}
