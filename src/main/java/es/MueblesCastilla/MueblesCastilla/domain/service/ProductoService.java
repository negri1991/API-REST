package es.MueblesCastilla.MueblesCastilla.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.IProductoRepository;
import es.MueblesCastilla.MueblesCastilla.domain.userCase.IProductoUseCase;
import lombok.RequiredArgsConstructor;

	/**
	 * Servicio Producto (Son todas las validaciones que lleva).
	 */
	@RequiredArgsConstructor
	@Service
	public class ProductoService implements IProductoUseCase{
		
		private final IProductoRepository iProductoRepository;
		
		/**
	     * Retorna una lista de Producto transformada a pojo de una lista de entidades
	     * @param ProductoEntity Entidad a transformar
	     * @return Lista transformada
	     */
		@Override
		public List<ProductoPojo> getAll() {
			
			return iProductoRepository.getAll();
		}

		/**
		 * Retorna un opcional dada su id
		 * @param id de Producto
		 * @return Opcional de ProductoPojo
		 */
		@Override
		public Optional<ProductoPojo> getProductoById(Integer id) {
			
			return iProductoRepository.getProductoById(id);
		}
		
		/**
		 * Retorna un opcional dada su nombre
		 * @param nombre de Producto
		 * @return Opcional de ProductoPojo
		 */
		@Override
		public List<ProductoPojo> findByName(String nombre) {
			List<ProductoPojo> productos = iProductoRepository.getAll().stream().filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()) || p.getNombre().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList());
			List<ProductoPojo> productos2 = iProductoRepository.getAll().stream().filter(p -> p.getDescripcion().toLowerCase().contains(nombre.toLowerCase()) || p.getDescripcion().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList());
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
			return iProductoRepository.save(newProducto);
		}
		
		/**
		 * Elimina Producto
		 * @param Producto a eliminar
		 * @return elimina Producto
		 */
		@Override
		public boolean delete(Integer idProducto) {
			
			if (iProductoRepository.getProductoById(idProducto).isEmpty()) {
				return false;
			}
				iProductoRepository.delete(idProducto);
				return true;
		
			
		}
		
		/**
		 * Producto a actualizar
		 * @param Producto
		 * @return Producto actualizado
		 */
		@Override
		public Optional<ProductoPojo> update(ProductoPojo producto) {
			
			if (iProductoRepository.getProductoById(producto.getId()).isEmpty()) {
				return Optional.empty();
			}
			return Optional.of(iProductoRepository.save(producto));
			
		}

	}

