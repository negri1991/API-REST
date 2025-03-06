package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.ProductoRepository;
import es.MueblesCastilla.MueblesCastilla.domain.userCase.ProductoService;

	/**
	 * Servicio Producto (Son todas las validaciones que lleva).
	 */
	@Service
	public class ProductoServiceImp implements ProductoService{
		
		private final ProductoRepository productoRepository;
		
		public ProductoServiceImp (ProductoRepository productoRepository) {
			this.productoRepository=productoRepository;
		}
		
		/**
	     * Retorna una lista de Producto transformada a pojo de una lista de entidades
	     * @param ProductoEntity Entidad a transformar
	     * @return Lista transformada
	     */
		@Override
		public List<ProductoPojo> getAll() {
			
			return productoRepository.getAll();
		}

		/**
		 * Retorna un opcional dada su id
		 * @param id de Producto
		 * @return Opcional de ProductoPojo
		 */
		@Override
		public Optional<ProductoPojo> getProductoById(Integer id) {
			
			return productoRepository.getProductoById(id);
		}
		
		/**
		 * Retorna un opcional dada su nombre
		 * @param nombre de Producto
		 * @return Opcional de ProductoPojo
		 */
		@Override
		public List<ProductoPojo> findByName(String nombre) {
			List<ProductoPojo> productos = productoRepository.getAll().stream().filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()) || p.getNombre().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList());
			List<ProductoPojo> productos2 = productoRepository.getAll().stream().filter(p -> p.getDescripcion().toLowerCase().contains(nombre.toLowerCase()) || p.getDescripcion().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList());
			productos.addAll(productos2);
			return productos;
		}
		
		/**
		 * Retorna un Producto guardado
		 * @param nuevo Producto
		 * @return crea Producto
		 */
		@Override
		public ProductoPojo save(ProductoPojo newProducto) {
			return productoRepository.save(newProducto);
		}
		
		/**
		 * Elimina Producto
		 * @param Producto a eliminar
		 * @return elimina Producto
		 */
		@Override
		public boolean delete(Integer idProducto) {
			
			if (productoRepository.getProductoById(idProducto).isEmpty()) {
				return false;
			}
				productoRepository.delete(idProducto);
				return true;
		
			
		}
		
		/**
		 * Producto a actualizar
		 * @param Producto
		 * @return Producto actualizado
		 */
		@Override
		public Optional<ProductoPojo> update(ProductoPojo producto) {
			
			if (productoRepository.getProductoById(producto.getId()).isEmpty()) {
				return Optional.empty();
			}
			return Optional.of(productoRepository.save(producto));
			
		}

	}

