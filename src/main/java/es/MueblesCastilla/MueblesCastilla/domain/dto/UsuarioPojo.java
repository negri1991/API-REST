package es.MueblesCastilla.MueblesCastilla.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPojo {
	
	private Integer id;
	private String nombre;
	private String username;
	private String email;
	private String direccion;
	private String telefono;
	private String tipo;
	private String password;

}
