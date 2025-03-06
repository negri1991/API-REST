package es.MueblesCastilla.MueblesCastilla.domain.dto;

public class DetalleCompraPojo {

	private Integer id;
	private double precio;
	private double total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
