package es.MueblesCastilla.MueblesCastilla.domain.userCase;

import java.util.List;
import java.util.Optional;

import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;

public interface ProductoService {

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
	 * Devuelve un producto dado su nombre
	 * @param nombre de producto
	 * @return Optional de producto
	 */
	List<ProductoPojo> findByName(String nombre);//Optional evita la exception 
	
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
