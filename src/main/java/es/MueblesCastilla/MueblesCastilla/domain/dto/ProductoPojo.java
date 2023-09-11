package es.MueblesCastilla.MueblesCastilla.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPojo {
	
	private Integer id;
	private String nombre;
	private String imagen;
	private double precio;
	private int cantidad;
	private String descripcion;
	private Integer idUsuario;

}
