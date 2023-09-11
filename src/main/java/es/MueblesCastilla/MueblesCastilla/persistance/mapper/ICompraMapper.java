package es.MueblesCastilla.MueblesCastilla.persistance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.MueblesCastilla.MueblesCastilla.domain.dto.CompraPojo;
import es.MueblesCastilla.MueblesCastilla.persistance.entity.Compra;


	/**
	 * Mapper que transforma objetos de Compra a pojos o entidades
	 */
	@Mapper(componentModel = "spring")
	public interface ICompraMapper {


	    /**
	     * Convierte una entidad a un pojo de compra
	     * @param compraEntity Entidad a convertir
	     * @return Pojo convertido
	     */
	    /*
	    @Mapping(source = "id", target = "id")
	    @Mapping(source = "numero", target = "numero")
	    @Mapping(source = "fechaCreacion", target = "fechaCreacion")
	    @Mapping(source = "fechaRecibida", target = "fechaRecibida")
	    
****** NO SE UTILIZA LOS MAPPING PORQUE TIENEN LOS MISMO NOMBRES     ******/
		
	    
	    CompraPojo toCompraPojo(Compra compraEntity);


	    /**
	     * Convierte un pojo a una entidad de compra
	     * @param compraPojo Pojo a convertir
	     * @return Entity convertido
	     */
	  //@InheritInverseConfiguration NO LO UTILIZO PORQUE TIENEN EL MISMO NOMBRE
	    @Mapping(target = "usuario", ignore = true)//ignoramos los objetos
	    @Mapping(target = "detalleCompra", ignore = true)//ignoramos los objetos
	    Compra toCompraEntity(CompraPojo compraPojo);

	    /**
	     * Retorna una lista de compra transformada a pojo de una lista de entidades
	     * @param compraEntity Entidad a transformar
	     * @return Lista transformada
	     */
	    List<CompraPojo> toCompraPojo(List<Compra> compraEntity);
	}


