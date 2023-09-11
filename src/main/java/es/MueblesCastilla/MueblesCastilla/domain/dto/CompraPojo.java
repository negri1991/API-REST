package es.MueblesCastilla.MueblesCastilla.domain.dto;

import java.util.Date;
import java.util.List;


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
	private UsuarioPojo usuario;
	private List<DetalleCompraPojo> detalleCompra;

}
