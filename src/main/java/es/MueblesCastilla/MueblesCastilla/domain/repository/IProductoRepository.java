package es.MueblesCastilla.MueblesCastilla.domain.repository;

import java.util.List;
import java.util.Optional;


import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;

public interface IProductoRepository {
	 /**
	  * Devuelve una lista con todos los productos
	  * @return Lista todos los productos.
	  */
	List<ProductoPojo> getAll();
	/**
	 * Devuelve un producto dado su id
	 * @param id de producto
	 * @return Optional de producto
	 */
	Optional<ProductoPojo> getProductoById(Integer id);//Optional evita la exception nullPointerException

	/**
	 * Devuelve un objecto de producto dado su nombre
	 * @param nombre
	 * @return Producto
	 */
	List<ProductoPojo> findByName(String nombre);
	
	/**
	 * Guarda un producto
	 * @param newProducto Producto a guardar
	 * @return Producto guardado
	 */
	ProductoPojo save(ProductoPojo newProducto);
	
	/**
	 * Elimina un Producto dado su id
	 * @param idProducto Id para eliminar el producto
	 */
	void delete (Integer idProducto);
	
}
