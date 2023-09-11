package es.MueblesCastilla.MueblesCastilla.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;
import es.MueblesCastilla.MueblesCastilla.domain.repository.IProductoRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.crud.IProductoCrudRepository;
import es.MueblesCastilla.MueblesCastilla.persistance.mapper.IProductoMapper;
import lombok.RequiredArgsConstructor;
/**
 * Repositorio de Producto (es el que se conecta a la base de datos DAO)
 */
@RequiredArgsConstructor
@Repository
public class ProductoRepository implements IProductoRepository{
	/**
	 * Crud de producto
	 */
	private final IProductoCrudRepository iProductoCrudRepository;
	/**
	 * Mapper de producto
	 */
	private final IProductoMapper iProductoMapper;

	/*public UsuarioRepository(IUsuarioCrudRepository iUsuarioCrudRepository, IUsuarioMapper iUsuarioMapper) {
	
	this.iUsuarioCrudRepository=iUsuarioCrudRepository;
	this.iUsuarioMapper=iUsuarioMapper;
	
	****lo creo con lombok****
}*/


/**
 * Retorna una lista de producto transformado a pojo de una lista de entidades
 * @param productoEntity Entidad a transformar
 * @return Lista transformada
 */
@Override
public List<ProductoPojo> getAll() {
	
	return iProductoMapper.toProductoPojo(iProductoCrudRepository.findAll());
}
/**
 * Retorna un opcional dada su id
 * @param id de producto
 * @return Opcional de ProductoPojo
 */
@Override
public Optional<ProductoPojo> getProductoById(Integer id) {
	
	return iProductoCrudRepository.findById(id).map(iProductoMapper::toProductoPojo);//mapea la interfaz mapper y llama al metodo toProductoPojo.
	
//	return iUsuarioCrudRepository.findById(id).map(hola -> iUsuarioMapper.toUsuarioPojo(hola)); Función lambda(programacion funcional).
}

/**
 * Retorna un producto guardado
 * @param nuevo producto
 * @return crea producto
 */
@Override
public ProductoPojo save(ProductoPojo newProducto) {
	
	return iProductoMapper.toProductoPojo(iProductoCrudRepository.save(iProductoMapper.toProductoEntity(newProducto)));
}

/**
 * Elimina Producto
 * @param Producto a eliminar
 * @return elimina Producto
 */
@Override
public void delete(Integer idProducto) {
	iProductoCrudRepository.deleteById(idProducto);
	
}
@Override
public List<ProductoPojo> findByName(String nombre) {
	return iProductoMapper.toProductoPojo(iProductoCrudRepository.findByNombre(nombre));
}

}
