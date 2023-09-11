package es.MueblesCastilla.MueblesCastilla.persistance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import es.MueblesCastilla.MueblesCastilla.domain.dto.UsuarioPojo;
import es.MueblesCastilla.MueblesCastilla.persistance.entity.Usuario;


	/**
	 * Mapper que transforma objetos de usuario entity a pojos y al inversa
	 */
	@Mapper(componentModel = "spring")
	public interface IUsuarioMapper {


	    /**
	     * Convierte una entidad a un pojo de usuario
	     * @param Usuario Entidad a convertir
	     * @return Pojo convertido
	     */
	    
	    /*@Mapping(source = "id", target = "id")
	    @Mapping(source = "nombre", target = "nombre")
	    @Mapping(source = "username", target = "username")
	    @Mapping(source = "email", target = "email")
	    @Mapping(source = "direccion", target = "direccion")
	    @Mapping(source = "telefono", target ="telefono")
	    @Mapping(source = "tipo", target ="tipo")
	    @Mapping(source = "password", target ="password")
****** NO SE UTILIZA LOS MAPPING PORQUE TIENEN LOS MISMO NOMBRES     ******/
	    UsuarioPojo toUsuarioPojo(Usuario usuarioEntity);


	    /**
	     * Convierte un pojo a una entidad de Usuario
	     * @param usuarioPojo Pojo a convertir
	     * @return Entity convertido
	     */
	    //@InheritInverseConfiguration NO LO UTILIZO PORQUE TIENEN EL MISMO NOMBRE
	    @Mapping(target ="productos", ignore=true)//ignoramos los objetos
	    @Mapping(target ="compras", ignore=true)//ignoramos los objetos
	    Usuario toUsuarioEntity(UsuarioPojo usuarioPojo);
	    

	    /**
	     * Retorna una lista de usuarios transformada de entidades a pojo
	     * @param usuarioEntity Entidad a transformar
	     * @return Lista transformada
	     */
	    List<UsuarioPojo> toUsuarioPojo(List<Usuario> usuarioEntity);
	}