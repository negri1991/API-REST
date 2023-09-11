package es.MueblesCastilla.MueblesCastilla.persistance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.MueblesCastilla.MueblesCastilla.domain.dto.DetalleCompraPojo;
import es.MueblesCastilla.MueblesCastilla.persistance.entity.DetalleCompra;

	
	/**
	 * Mapper que transforma objetos de Detalle Compra a pojos o entidades
	 */
	@Mapper(componentModel = "spring")
	public interface IDetalleCompraMapper {


	    /**
	     * Convierte una entidad a un pojo de detalle compra
	     * @param detalle compra Entidad a convertir
	     * @return Pojo convertido
	     */
	    /*
	    @Mapping(source = "id", target = "id")
	    @Mapping(source = "nombre", target = "nombre")
	    @Mapping(source = "cantidad", target = "cantidad")
	    @Mapping(source = "precio", target = "precio")
	    @Mapping(source = "total", target = "total")
	    @Mapping(source = "compra", target ="compra")
	    @Mapping(source = "producto", target = "producto")
	    
****** NO SE UTILIZA LOS MAPPING PORQUE TIENEN LOS MISMO NOMBRES     ******/
	    DetalleCompraPojo toDetalleCompraPojo(DetalleCompra detalleCompraEntity);


	    /**
	     * Convierte un pojo a una entidad de detalle compra
	     * @param detalleCompraPojo Pojo a convertir
	     * @return Entity convertido
	     */
	  //@InheritInverseConfiguration NO LO UTILIZO PORQUE TIENEN EL MISMO NOMBRE
	    @Mapping(target ="compra", ignore = true)//ignoramos los objetos
	    @Mapping(target ="producto", ignore = true)//ignoramos los objetos
	    DetalleCompra toDetalleCompraEntity(DetalleCompraPojo detalleCompraPojo);
	    

	    /**
	     * Retorna una lista de detalle compra transformada a pojo de una lista de entidades
	     * @param detalleCompraEntity Entidad a transformar
	     * @return Lista transformada
	     */
	    List<DetalleCompraPojo> toDetalleCompraPojo(List<DetalleCompra> detalleCompraEntity);
	}




