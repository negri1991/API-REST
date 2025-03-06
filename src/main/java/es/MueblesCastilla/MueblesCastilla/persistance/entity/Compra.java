package es.MueblesCastilla.MueblesCastilla.persistance.entity;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="facturas")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Para generar autoincrementable
	private Integer id;
	private String numero;
	private Date fechaCreacion;
	private Date fechaRecibida;
	private Integer idUsuario;
	private double total;
		
	   @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
	    private List<DetalleCompra> detalleCompra;

	    @ManyToOne//Muchas compras por un usuario.
	    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
	    private Usuario usuario;

	public Compra() {

	}

	public Compra(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, Integer idUsuario, double total,
			List<DetalleCompra> detalleCompra, Usuario usuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.idUsuario = idUsuario;
		this.total = total;
		this.detalleCompra = detalleCompra;
		this.usuario = usuario;
	}

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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<DetalleCompra> getDetalleCompra() {
		return detalleCompra;
	}

	public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
		this.detalleCompra = detalleCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}