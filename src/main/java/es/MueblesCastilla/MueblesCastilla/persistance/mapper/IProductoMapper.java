package es.MueblesCastilla.MueblesCastilla.persistance.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.domain.dto.ProductoPojo;
import es.MueblesCastilla.MueblesCastilla.persistance.entity.DetalleCompra;
import es.MueblesCastilla.MueblesCastilla.persistance.entity.Producto;


	/**
	 * Mapper que transforma objetos de Detalle Compra a pojos o entidades
	 */
	@Mapper(componentModel = "spring")
	public interface IProductoMapper {


	    /**
	     * Convierte una entidad a un pojo de producto
	     * @param producto Entidad a convertir
	     * @return Pojo convertido
	     */
	    
	    /*@Mapping(source = "id", target = "id")
	    @Mapping(source = "nombre", target = "nombre")
	    @Mapping(source = "imagen", target = "imagen")
	    @Mapping(source = "precio", target = "precio")
	    @Mapping(source = "cantidad", target = "cantidad")
	    @Mapping(source = "descripcion", target ="descripcion")
	    
****** NO SE UTILIZA LOS MAPPING PORQUE TIENEN LOS MISMO NOMBRES     ******/
		
	    ProductoPojo toProductoPojo(Producto productoEntity);


	    /**
	     * Convierte un pojo a una entidad de producto
	     * @param detalleCompraPojo Pojo a convertir
	     * @return Entity convertido
	     */
	  //@InheritInverseConfiguration NO LO UTILIZO PORQUE TIENEN EL MISMO NOMBRE
	    Producto toProductoEntity(ProductoPojo productoPojo);
	    

	    /**
	     * Retorna una lista de producto transformada a pojo de una lista de entidades
	     * @param productoEntity Entidad a transformar
	     * @return Lista transformada
	     */
	    List<ProductoPojo> toProductoPojo(List<Producto> productoEntity);
	}


