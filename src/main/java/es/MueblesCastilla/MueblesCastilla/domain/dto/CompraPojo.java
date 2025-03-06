package es.MueblesCastilla.MueblesCastilla.domain.dto;

import java.util.Date;
import java.util.List;

import es.MueblesCastilla.MueblesCastilla.persistance.entity.DetalleCompra;
import es.MueblesCastilla.MueblesCastilla.persistance.entity.Usuario;


public class CompraPojo {
	
	private Integer id;
	private String numero;
	private Date fechaCreacion;
	private Date fechaRecibida;
	private double total;
	private Integer idUsuario;
	private Usuario usuario;
	private List<DetalleCompra> detalleCompra;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaRecibida() {
		return fechaRecibida;
	}
	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	public List<DetalleCompra> getDetalleCompra(){
		return detalleCompra;
	}
	public void setDetalleCompra(List<DetalleCompra> detalleCompra){
		this.detalleCompra=detalleCompra;
		
	}

}
