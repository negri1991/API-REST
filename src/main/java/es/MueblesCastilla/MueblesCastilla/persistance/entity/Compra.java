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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="facturas")
@Getter
@Setter
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


}