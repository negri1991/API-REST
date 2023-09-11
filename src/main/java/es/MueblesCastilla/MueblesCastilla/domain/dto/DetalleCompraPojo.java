package es.MueblesCastilla.MueblesCastilla.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleCompraPojo {

	private Integer id;
	private double total;
	private CompraPojo compra;
	private ProductoPojo producto;
}
