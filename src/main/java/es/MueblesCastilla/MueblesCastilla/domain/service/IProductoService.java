package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;

import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;

public interface IProductoService {

	/**
	  * Devuelve una lista con todos los Producto
	  * @return Lista todos los Producto.
	  */
	List<ProductoPojo> getAll();
	/**
	 * Devuelve un Producto dado su id
	 * @param id de Producto
	 * @return Optional de Producto
	 */
	Optional<ProductoPojo> getProductoById(Integer id);//Optional evita la exception nullPointerException
	
	/**
	 * Guarda un Producto
	 * @param newProducto Producto a guardar
	 * @return Producto guardado
	 */
	ProductoPojo save(ProductoPojo newProducto);
	
	/**
	 * Actualiza un Producto
	 * @param Recibe un Producto
	 * @return Devuelve el Producto actualizado
	 */
	Optional <ProductoPojo> update (ProductoPojo producto);
	
	/**
	 * Elimina un Producto dado su id
	 * @param idProducto Id para eliminar el Producto
	 */
	boolean delete (Integer idProducto);

}
