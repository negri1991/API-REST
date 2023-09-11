package es.MueblesCastilla.MueblesCastilla.domain.dto;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraPojo {
	
	private Integer id;
	private String numero;
	private Date fechaCreacion;
	private Date fechaRecibida;
	private double total;
	private Integer idUsuario;

}
